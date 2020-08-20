package org.simpleframework.inject;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.annotation.Autowired;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Field;

/**
 * @author yangxin
 * 2020/08/20 14:36
 */
@Slf4j
public class DependencyInjector {

    /**
     * Bean容器
     */
    private final BeanContainer beanContainer;

    public DependencyInjector() {
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行IOC
     */
    public void doIOC() {
        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("empty classSet in BeanContainer");
        }

        // 1. 遍历Bean容器中所有Class对象
        for (Class<?> clazz : beanContainer.getClasses()) {
            // 2. 遍历Class对象的所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }

            for (Field field : fields) {
                // 3. 找出被Autowired标记的成员变量
                if (field.isAnnotationPresent(Autowired.class)) {
                    // 4. 获取这些成员变量的类型
                    Class<?> fieldClass = field.getType();
                    // 5. 获取这些成员变量的类型在容器里对应的实例
                    Object fieldValue = getFieldInstance(fieldClass);
                    if (fieldValue == null) {
                        throw new RuntimeException("Unable to inject relevant type, target fieldClass is: "
                                + fieldClass.getName());
                    } else {
                        // 6. 通过反射将对应的成员变量实例注入到成员变量所在类的实例里
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setField(field, targetBean, fieldValue, true);
                    }
                }
            }
        }
    }

    /**
     * 根据Class在beanContainer里面获取其实例或者实现类
     */
    private Object getFieldInstance(Class<?> fieldClass) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        if (fieldValue != null) {
            return fieldValue;
        }

        Class<?> implementedClass = getImplementClass(fieldClass);
        if (implementedClass != null) {
            return beanContainer.getBean(implementedClass);
        } else {
            return null;
        }
    }

    private Class<?> getImplementClass(Class<?> fieldClass) {
        return null;
    }
}
