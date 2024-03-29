package org.simpleframework.aop.aspect;

import java.lang.reflect.Method;

/**
 * @author yangxin
 * 2022/5/25 22:14
 */
@SuppressWarnings("RedundantThrows")
public abstract class DefaultAspect {

    /**
     * 事先拦截
     *
     * @param targetClass 被代理的目标类
     * @param method 被代理的目标方法
     * @param args 被代理的目标方法对应的参数列表
     * @throws Throwable 异常
     */
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable {
    }

    /**
     * 事后拦截
     *
     * @param targetClass 被代理的目标类
     * @param method 被代理的目标方法
     * @param args 被代理的目标方法对应的参数列表
     * @param returnValue 被代理的目标方法执行后的返回值
     * @return 被代理的目标方法执行后的返回值
     * @throws Throwable 可抛出异常
     */
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) throws Throwable {
        return returnValue;
    }

    /**
     * @param targetClass 被代理的目标类
     * @param method 被代理的目标方法
     * @param args 被代理的目标方法对应的参数列表
     * @param e 被代理的目标方法抛出的异常
     * @throws Throwable 可抛出异常
     */
    public void afterThrowing(Class<?> targetClass, Method method, Object[] args, Throwable e) throws Throwable {
    }
}
