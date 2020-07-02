package org.simpleframework.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author yangxin
 * 2020/07/02 13:45
 */
public class ValidationUtil {

    /**
     * String是否为null或""
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * Collection是否为null或size为0
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Array是否为null或者size为0
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Map是否为null或size为0
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
