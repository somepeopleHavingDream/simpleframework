package org.yangxin.aop;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.aop.annotation.Aspect;
import org.simpleframework.aop.annotation.Order;
import org.simpleframework.aop.aspect.DefaultAspect;
import org.simpleframework.core.annotation.Controller;

import java.lang.reflect.Method;

/**
 * @author yangxin
 * 2022/5/26 21:50
 */
@Aspect(value = Controller.class)
@Order(10)
@Slf4j
public class ControllerInfoRecordAspect extends DefaultAspect {

    @Override
    public void before(Class<?> targetClass, Method method, Object[] args) {
        log.info("方法开始执行了，执行的类是[{}]，执行的方法是[{}]，参数是[{}]", targetClass.getName(), method.getName(), args);
    }

    @Override
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) {
        log.info("方法顺利完成，执行的类是[{}]，执行的方法是[{}]，参数是[{}]，返回值是[{}]",
                targetClass.getName(), method.getName(), args,  returnValue);
        return returnValue;
    }

    @Override
    public void afterThrowing(Class<?> targetClass, Method method, Object[] args, Throwable e) {
        log.info("方法执行失败，执行的类是[{}]，执行的方法是[{}]，参数是[{}]，异常值是[{}]",
                targetClass.getName(), method.getName(), args,  e.getMessage());
    }
}
