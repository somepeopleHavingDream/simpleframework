package org.simpleframework.mvc.render;

import org.simpleframework.mvc.RequestProcessorChain;

/**
 * 渲染请求结果
 *
 * @author yangxin
 * 2023/10/26 21:37
 */
public interface ResultRender {

    /**
     * 执行渲染
     */
    void render(RequestProcessorChain requestProcessorChain) throws Exception;
}
