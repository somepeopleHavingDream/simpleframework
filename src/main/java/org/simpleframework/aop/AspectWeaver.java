package org.simpleframework.aop;

import org.simpleframework.aop.annotation.Aspect;
import org.simpleframework.aop.annotation.Order;
import org.simpleframework.aop.aspect.AspectInfo;
import org.simpleframework.aop.aspect.DefaultAspect;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @author yangxin
 * 2022/5/26 21:07
 */
public class AspectWeaver {

    private final BeanContainer beanContainer;

    public AspectWeaver() {
        this.beanContainer = BeanContainer.getInstance();
    }

    public void doAop() {
        // 1 获取所有的切面类
        Set<Class<?>> aspectSet = beanContainer.getClassesByAnnotation(Aspect.class);
        if (ValidationUtil.isEmpty(aspectSet)) {
            return;
        }

        // 2 拼装AspectInfoList
        List<AspectInfo> aspectInfoList = packAspectInfoList(aspectSet);

        // 3 遍历容器里的类
        Set<Class<?>> classSet = beanContainer.getClasses();
        for (Class<?> targetClass : classSet) {
            // 排除AspectClass自身
            if (targetClass.isAnnotationPresent(Aspect.class)) {
                continue;
            }

            // 4 粗筛符合条件的Aspect
            List<AspectInfo> roughMatchedAspectList = collectRoughMatchedAspectListForSpecificClass(aspectInfoList,
                    targetClass);
            // 5 尝试进行Aspect的织入
            wrapIfNecessay(roughMatchedAspectList, targetClass);
        }
    }

    private void wrapIfNecessay(List<AspectInfo> roughMatchedAspectList, Class<?> targetClass) {
        if (ValidationUtil.isEmpty(roughMatchedAspectList)) {
            return;
        }

        // 创建动态代理对象
        AspectListExecutor aspectListExecutor = new AspectListExecutor(targetClass, roughMatchedAspectList);
        Object proxyBean = ProxyCreator.createProxy(targetClass, aspectListExecutor);
        beanContainer.addBean(targetClass, proxyBean);
    }

    private List<AspectInfo> collectRoughMatchedAspectListForSpecificClass(List<AspectInfo> aspectInfoList, Class<?> targetClass) {
        List<AspectInfo> roughMatchedAspectList = new ArrayList<>();
        for (AspectInfo aspectInfo : aspectInfoList) {
            // 粗筛
            if (aspectInfo.getPointcutLocator().roughMatches(targetClass)) {
                roughMatchedAspectList.add(aspectInfo);
            }
        }

        return roughMatchedAspectList;
    }

    private List<AspectInfo> packAspectInfoList(Set<Class<?>> aspectSet) {
        List<AspectInfo> aspectInfoList = new ArrayList<>();
        for (Class<?> aspectClass : aspectSet) {
            if (verifyAspect(aspectClass)) {
                Order orderTag = aspectClass.getAnnotation(Order.class);
                Aspect aspectTag = aspectClass.getAnnotation(Aspect.class);
                DefaultAspect defaultAspect = (DefaultAspect) beanContainer.getBean(aspectClass);

                // 初始化表达式定位器
                PointcutLocator pointcutLocator = new PointcutLocator(aspectTag.pointcut());
                AspectInfo aspectInfo = new AspectInfo(orderTag.value(), defaultAspect, pointcutLocator);
                aspectInfoList.add(aspectInfo);
            } else {
                // 不遵守规则则直接抛出异常
                throw new RuntimeException("@Aspect and @Order must be added to the Aspect class," +
                        " and Aspect class must extend from DefaultAspect");
            }
        }

        return aspectInfoList;
    }

    private void weaveByCategory(Class<? extends Annotation> category, List<AspectInfo> aspectInfoList) {
        // 1 获取被代理类的集合
        Set<Class<?>> classSet = beanContainer.getClassesByAnnotation(category);
        if (ValidationUtil.isEmpty(classSet)) {
            return;
        }

        // 2 遍历被代理类，分别为每个被代理类生成动态代理实例
        for (Class<?> targetClass : classSet) {
            // 创建动态代理对象
            AspectListExecutor aspectListExecutor = new AspectListExecutor(targetClass, aspectInfoList);
            Object proxyBean = ProxyCreator.createProxy(targetClass, aspectListExecutor);

            // 3 将动态代理对象实例添加到容器里，取代未被代理前的类实例
            beanContainer.addBean(targetClass, proxyBean);
        }
    }

    /**
     * 框架中一定要遵守给Aspect类添加@Aspect和@Order标签的规范，
     * 同时，必须继承自DefaultAspect.class，
     * 此外，@Aspect的属性值不能是它本身
     *
     * @param aspectClass 切面类对象
     * @return 是否是合规的切面类
     */
    private boolean verifyAspect(Class<?> aspectClass) {
        return aspectClass.isAnnotationPresent(Aspect.class)
                && aspectClass.isAnnotationPresent(Order.class)
                && DefaultAspect.class.isAssignableFrom(aspectClass);
    }
}
