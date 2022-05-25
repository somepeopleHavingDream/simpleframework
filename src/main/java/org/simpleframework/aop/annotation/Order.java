package org.simpleframework.aop.annotation;

import java.lang.annotation.*;

/**
 * @author yangxin
 * 2022/05/25 22:10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {

    /**
     * 控制类的执行顺序，值越小优先级越高
     *
     * @return 值
     */
    int value();
}
