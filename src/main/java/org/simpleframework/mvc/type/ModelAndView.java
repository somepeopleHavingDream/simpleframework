package org.simpleframework.mvc.type;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储处理完后的结果数据，以及显示该数据的视图
 *
 * @author yangxin
 * 2023/11/29 21:01
 */
@SuppressWarnings("UnusedReturnValue")
@Getter
public class ModelAndView {

    /**
     * 页面所在的路径
     */
    private String view;

    /**
     * 页面的 data 数据
     */
    private final Map<String, Object> model = new HashMap<>();

    public ModelAndView setView(String view) {
        this.view = view;
        return this;
    }

    public ModelAndView addViewData(String attributeName, Object attributeValue) {
        model.put(attributeName, attributeValue);
        return this;
    }
}
