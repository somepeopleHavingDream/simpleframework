package org.simpleframework.inject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;
import org.yangxin.controller.frontend.MainPageController;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yangxin
 * 2020/08/20 16:05
 */
@SuppressWarnings("ConstantConditions")
class DependencyInjectorTest {

    @Test
    @DisplayName("依赖注入doIOC")
    void doIOC() {
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("org.yangxin");
        assertTrue(beanContainer.isLoaded());

        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        assertTrue(mainPageController instanceof MainPageController);
        assertNull(mainPageController.getHeadLineShopCategoryCombineService());

        new DependencyInjector().doIoc();
        assertNotNull(mainPageController.getHeadLineShopCategoryCombineService());
    }
}