package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean容器
 *
 * @author yangxin
 * 2020/07/02 11:00
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     * 存放所有被配置标记的目标对象的Map
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 加载bean的注解列表
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION_LIST
            = Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);

    /**
     * 容器是否已经被加载过
     */
    private boolean loaded = false;

    /**
     * 是否已经加载过Bean
     *
     * @return 是否已加载过
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * Bean实例数量
     *
     * @return 数量
     */
    public int size() {
        return beanMap.size();
    }

    /**
     * 获取Bean容器实例
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    /**
     * 看一下枚举类的反汇编代码吧！
     *
     * @author yangxin
     * 2020/07/02 11:05
     */
    private enum ContainerHolder {

        HOLDER;

        private final BeanContainer instance;

        ContainerHolder() {
            instance = new BeanContainer();
        }
    }

    /**
     * 扫描加载所有Bean
     *
     * @param packageName 包名
     */
    public synchronized void loadBeans(String packageName) {
        // 判断bean容器是否被加载过
        if (isLoaded()) {
            log.warn("BeanContainer has been loaded.");
            return;
        }

        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (ValidationUtil.isEmpty(classSet)) {
//        if (classSet.isEmpty()) {
            log.warn("extract nothing from package: [{}]", packageName);
            return;
        }

        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotationClazz : BEAN_ANNOTATION_LIST) {
                // 如果类上面标记了定义的注解
                if (clazz.isAnnotationPresent(annotationClazz)) {
                    // 将目标类本身作为键，目标类的实例作为值，放入到beanMap中
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }

        // 设置加载标记
        loaded = true;
    }
}