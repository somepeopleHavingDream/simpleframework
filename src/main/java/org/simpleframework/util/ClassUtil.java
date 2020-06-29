package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.Collections;
import java.util.Set;

/**
 * 字节码工具类
 *
 * @author yangxin
 * 2020/06/29 10:44
 */
@Slf4j
public class ClassUtil {

    /**
     * 获取包下类集合
     *
     * @param packageName 包名
     * @return 包下的类集合
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        // 1. 获取到类的加载器
        ClassLoader classLoader = getClassLoader();

        // 2. 通过类加载器获取到加载的资源
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (url == null) {
            log.warn("Unable to retrieve anything from package: [{}]", packageName);
            return Collections.emptySet();
        }

        // 3. 依据不同的资源类型，采用不同的方式获取资源的集合
        return Collections.emptySet();
    }

    /**
     * 获取类加载器
     *
     * @return 当前类加载器
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }
}
