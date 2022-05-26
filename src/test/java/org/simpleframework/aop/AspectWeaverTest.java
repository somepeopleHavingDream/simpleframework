package org.simpleframework.aop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.DependencyInjector;
import org.yangxin.controller.superadmin.HeadLineOperationController;

import static org.junit.jupiter.api.Assertions.*;

class AspectWeaverTest {

    @Test
    @DisplayName("织入通用逻辑测试：doAop")
    void doAop() {
        BeanContainer container = BeanContainer.getInstance();
        container.loadBeans("org.yangxin");
        new AspectWeaver().doAop();
        new DependencyInjector().doIoc();
        HeadLineOperationController controller = (HeadLineOperationController) container
                .getBean(HeadLineOperationController.class);
        controller.addHeadLine(null, null);
    }
}