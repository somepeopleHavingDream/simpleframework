package org.simpleframework.aop.annotation;

import java.lang.annotation.*;

/**
 * @author yangxin
 * 2022/05/25 22:09
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    String pointcut();
}
