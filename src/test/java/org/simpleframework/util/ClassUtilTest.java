package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClassUtilTest {

    @DisplayName("提取目标类方法：extractPackageClass")
    @Test
    void extractPackageClass() {
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("org.yangxin.entity");
        Assertions.assertEquals(4, classSet.size());
    }
}