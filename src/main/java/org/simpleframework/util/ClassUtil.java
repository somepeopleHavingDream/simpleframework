package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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
     * 文件协议
     */
    private static final String FILE_PROTOCOL = "file";

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
        Set<Class<?>> classSet;
        // 过滤出文件类型的资源
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            classSet = new HashSet<>();
            File packageDirectory = new File(url.getPath());
            extractClassFile(classSet, packageDirectory, packageName);
        }
        return Collections.emptySet();
    }

    /**
     * 递归获取目标package里面的所有class文件（包括子package里的class文件）
     *
     * @param classSet 装载目标类的集合
     * @param fileSource 文件或者目录
     * @param packageName 包名
     */
    private static void extractClassFile(Set<Class<?>> classSet, File fileSource, String packageName) {
        if (!fileSource.isDirectory()) {
            return;
        }

        // 如果是一个文件夹，则调用其listFiles方法获取文件夹下的文件或文件夹
        File[] files = fileSource.listFiles(file -> {
            if (file.isDirectory()) {
                return true;
            } else {
                // 获取文件的绝对值路径
                String absolutePath = file.getAbsolutePath();
                if (absolutePath.endsWith(".class")) {
                    // 若是class文件，则直接加载
                    addToClassSet(absolutePath);
                }
            }

            return false;
        });

        if (files != null) {
            // 递归调用
            Arrays.stream(files).forEach(file -> extractClassFile(classSet, fileSource, packageName));
        }
    }

    /**
     * 根据class文件的绝对路径，获取并生成class对象，并放入classSet中
     *
     * @param absolutePath 绝对路径
     */
    private static void addToClassSet(String absolutePath) {
        // 1. 从class文件的绝对值路径里提取出包含了package的类名
        // 2. 通过反射机制获取对应的Class对象并加入到classSet里
        // 如/Users/baidu/imooc/springframework/sampleframework/target/classes/com/imooc/entity/dto/MainPageInfoDTO
        // 需要弄成com.imooc.entity.dto.MainPageInfoDTO
    }

    /**
     * 获取类加载器
     *
     * @return 当前类加载器
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static void main(String[] args) {
        extractPackageClass("org.yangxin.entity");
    }
}
