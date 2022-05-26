package org.simpleframework.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author yangxin
 * 2022/5/26 20:59
 */
public class ProxyCreator {

    /**
     * 创建动态代理对象并返回
     *
     * @param targetClass 被代理的Class对象
     * @param methodInterceptor 方法拦截器
     * @return 动态代理对象
     */
    public static Object createProxy(Class<?> targetClass, MethodInterceptor methodInterceptor) {
        return Enhancer.create(targetClass, methodInterceptor);
    }
}
