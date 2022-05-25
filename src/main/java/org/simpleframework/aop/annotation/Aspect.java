package org.simpleframework.aop.annotation;

import java.lang.annotation.*;

/**
 * @author yangxin
 * 2022/05/25 22:09
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 需要被织入横切逻辑的注解标签
     *
     * @return 值
     */
    Class<? extends Annotation> value();
}
