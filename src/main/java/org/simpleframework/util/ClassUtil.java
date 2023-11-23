package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
@SuppressWarnings("AlibabaUndefineMagicConstant")
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
        Set<Class<?>> classSet = new HashSet<>();
        // 过滤出文件类型的资源
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            File packageDirectory = new File(url.getPath());
            extractClassFile(classSet, packageDirectory, packageName);
        }

        // todo 此处可以加入针对其他类型资源的处理
        return classSet;
    }

    /**
     * 递归获取目标package里面的所有class文件（包括子package里的class文件）
     *
     * @param emptyClassSet 装载目标类的集合
     * @param fileSource    文件或者目录
     * @param packageName   包名
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        // 如果当前文件不是一个目录则直接退出
        if (!fileSource.isDirectory()) {
            return;
        }

        /*
         如果是一个文件夹，则调用其listFiles方法获取文件夹下的文件或文件夹
         这个地方也算是一个妙用，避免了用一般遍历算法，多写一个方法
         这个files装的全部是目录
        */
        File[] files = fileSource.listFiles(new FileFilter() {

            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    // 获取文件的绝对路径
                    String absolutePath = file.getAbsolutePath();
                    if (absolutePath.endsWith(".class")) {
                        // 若是class文件，则直接加载
                        addToClassSet(absolutePath);
                    }
                }

                return false;
            }

            /**
             * 根据class文件的绝对路径，获取并生成class对象，并放入classSet中
             *
             * @param absoluteFilePath 绝对路径
             */
            private void addToClassSet(String absoluteFilePath) {
                // 1. 从class文件的绝对值路径里提取出包含了package的类名
                // 如/Users/baidu/imooc/springframework/sampleframework/target/classes/com/imooc/entity/dto/MainPageInfoDTO
                // 需要弄成com.imooc.entity.dto.MainPageInfoDTO
                absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName),
                        absoluteFilePath.lastIndexOf("."));

                // 2. 通过反射机制获取对应的Class对象并加入到classSet里
                Class<?> targetClass = loadClass(className);
                emptyClassSet.add(targetClass);
            }
        });

        if (files != null) {
            // 递归调用
            Arrays.stream(files).forEach(file -> extractClassFile(emptyClassSet, file, packageName));
        }
    }

    /**
     * 获取Class对象
     *
     * @param className class全名 = package + 类名
     * @return Class对象
     */
    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error: ", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 实例化class
     *
     * @param clazz      字节码对象
     * @param accessible 是否支持创建出私有class对象的实例
     * @param <T>        class的类型
     * @return 实例化出来的对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<?> clazz, boolean accessible) {
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            /*
             在Java中可以通过反射进行获取实体类中的字段值，当未设置Field的setAccessible方法为true时，会在调用的时候进行访问安全检查，
             会抛出IllegalAccessException异常
            */
            constructor.setAccessible(accessible);
            return (T) constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            log.error("newInstance error", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取类加载器
     *
     * @return 当前类加载器
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 设置类的属性值
     *
     * @param field      成员变量
     * @param target     类实例
     * @param value      成员变量的值
     * @param accessible 是否允许设置私有属性
     */
    public static void setField(Field field, Object target, Object value, boolean accessible) {
        field.setAccessible(accessible);

        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            log.error("setField error", e);
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        extractPackageClass("org.yangxin.entity");
    }
}
