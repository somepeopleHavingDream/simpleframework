package org.yangxin.aop;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.aop.annotation.Aspect;
import org.simpleframework.aop.annotation.Order;
import org.simpleframework.aop.aspect.DefaultAspect;

import java.lang.reflect.Method;

/**
 * @author yangxin
 * 2022/5/26 21:50
 */
@SuppressWarnings("unused")
@Aspect(pointcut = "execution(* org.yangxin.controller.superadmin.HeadLineOperationController.*(..))")
@Order(0)
@Slf4j
public class ControllerTimeCalculatorAspect extends DefaultAspect {

    private long timestampCache;

    @Override
    public void before(Class<?> targetClass, Method method, Object[] args) {
        log.info("开始计时，执行的类是[{}]，执行的方法是[{}]，参数是[{}]", targetClass.getName(), method.getName(), args);
        timestampCache = System.currentTimeMillis();
    }

    @Override
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) {
        long endTime = System.currentTimeMillis();
        long costTime = endTime - timestampCache;

        log.info("结束计时，执行的类是[{}]，执行的方法是[{}]，参数是[{}]，返回值是[{}]，时间为[{}]ms",
                targetClass.getName(), method.getName(), args,  returnValue, costTime);
        return returnValue;
    }
}
