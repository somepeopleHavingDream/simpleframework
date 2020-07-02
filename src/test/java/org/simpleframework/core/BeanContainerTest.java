package org.simpleframework.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yangxin
 * 2020/07/02 13:59
 */
class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @DisplayName("加载目标类及其实例到BeanContainer")
    @Test
    void loadBeans() {
        assertFalse(beanContainer.isLoaded());
        beanContainer.loadBeans("org.yangxin");
        Assertions.assertEquals(6, beanContainer.size());
        assertTrue(beanContainer.isLoaded());
    }
}