package org.simpleframework.aop;

import lombok.Getter;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.simpleframework.aop.aspect.AspectInfo;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

/**
 * @author yangxin
 * 2022/5/25 22:27
 */
public class AspectListExecutor implements MethodInterceptor {

    /**
     * 被代理的类
     */
    private final Class<?> targetClass;

    /**
     * 排好序的Aspect列表
     */
    @Getter
    private final List<AspectInfo> sortedAspectInfoList;

    public AspectListExecutor(Class<?> targetClass, List<AspectInfo> sortedAspectInfoList) {
        this.targetClass = targetClass;
        this.sortedAspectInfoList = sortAspectInfoList(sortedAspectInfoList);
    }

    /**
     * 按照order的值进行升序排序，确保order值小的aspect先被织入
     *
     * @param aspectInfoList 切面信息列表
     * @return 排序后的切面信息列表
     */
    private List<AspectInfo> sortAspectInfoList(List<AspectInfo> aspectInfoList) {
        aspectInfoList.sort(Comparator.comparingInt(AspectInfo::getOrderIndex));
        return aspectInfoList;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object returnValue = null;
        collectAccurateMatchedAspectList(method);
        if (ValidationUtil.isEmpty(this.sortedAspectInfoList)) {
            returnValue = methodProxy.invokeSuper(proxy, args);
            return returnValue;
        }

        // 1 按照order的顺序升序执行完所有Aspect的before方法
        invokeBeforeAdvices(method, args);
        try {
            // 2 执行被代理类的方法
            returnValue = methodProxy.invokeSuper(proxy, args);
            // 3 如果被代理方法正常返回，则按照order的顺序降序执行完所有Aspect的afterReturning方法
            returnValue = invokeAfterReturningAdvices(method, args, returnValue);
        } catch (Exception e) {
            // 4 如果被代理方法抛出异常，则按照order的顺序降序执行完所有Aspect的afterThrowing方法
            invokeAfterThrowingAdvices(method, args, e);
        }

        return returnValue;
    }

    /**
     * 收集精确匹配的切面集
     *
     * @param method 方法对象
     */
    private void collectAccurateMatchedAspectList(Method method) {
        if (ValidationUtil.isEmpty(this.sortedAspectInfoList))  {
            return;
        }

        this.sortedAspectInfoList.removeIf(aspectInfo -> !aspectInfo.getPointcutLocator().accurateMatches(method));
    }

    /**
     * 如果被代理方法抛出异常，则按照order的顺序降序执行完所有Aspect的afterThrowing方法
     *
     * @param method 方法
     * @param args 方法参数
     * @param e 异常
     */
    private void invokeAfterThrowingAdvices(Method method, Object[] args, Exception e) throws Throwable {
        for (int i = this.sortedAspectInfoList.size() - 1; i >= 0; i--) {
            this.sortedAspectInfoList.get(i).getAspectObject().afterThrowing(targetClass, method, args, e);
        }
    }

    /**
     * 如果被代理方法正常返回，则按照order的顺序降序执行完所有Aspect的afterReturning方法
     *
     * @param method 方法
     * @param args 方法参数
     * @param returnValue 返回值
     * @return 切面处理之后的返回值
     */
    private Object invokeAfterReturningAdvices(Method method, Object[] args, Object returnValue) throws Throwable {
        Object result = null;
        for (int i = this.sortedAspectInfoList.size() - 1; i >= 0; i--) {
            result = this.sortedAspectInfoList.get(i)
                    .getAspectObject()
                    .afterReturning(targetClass, method, args, returnValue);
        }
        return result;
    }

    /**
     * 按照order的顺序升序完成所有Aspect的before方法
     *
     * @param method 方法
     * @param args 方法参数
     * @throws Throwable 可抛出实例
     */
    private void invokeBeforeAdvices(Method method, Object[] args) throws Throwable {
        for (AspectInfo aspectInfo : this.sortedAspectInfoList) {
            aspectInfo.getAspectObject().before(targetClass, method, args);
        }
    }
}
