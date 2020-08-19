package org.simpleframework.core;

import org.junit.jupiter.api.*;
import org.simpleframework.core.annotation.Controller;
import org.yangxin.controller.frontend.MainPageController;
import org.yangxin.service.solo.HeadLineService;
import org.yangxin.service.solo.impl.HeadLineServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yangxin
 * 2020/07/02 13:59
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @DisplayName("加载目标类及其实例到BeanContainer")
    @Test
    @Order(1)
    void loadBeans() {
        assertFalse(beanContainer.isLoaded());
        beanContainer.loadBeans("org.yangxin");
        Assertions.assertEquals(6, beanContainer.size());
        assertTrue(beanContainer.isLoaded());
    }

    @SuppressWarnings("ConstantConditions")
    @DisplayName("根据类获取其实例：getBean")
    @Test
    @Order(2)
    void getBean() {
        MainPageController controller = (MainPageController) beanContainer.getBean(MainPageController.class);
        assertTrue(controller instanceof MainPageController);
    }

    @Test
    @DisplayName("根据注解获取对应的实例：getClassesByAnnotation")
    @Order(3)
    void getClassesByAnnotation() {
        assertTrue(beanContainer.isLoaded());
        Assertions.assertEquals(3, beanContainer.getClassesByAnnotation(Controller.class).size());
    }

    @DisplayName("根据接口获取实现类：getClassesBySuper")
    @Order(4)
    @Test
    void getClassesBySuper() {
        assertTrue(beanContainer.isLoaded());
        assertTrue(beanContainer.getClassesBySuper(HeadLineService.class).contains(HeadLineServiceImpl.class));
    }
}