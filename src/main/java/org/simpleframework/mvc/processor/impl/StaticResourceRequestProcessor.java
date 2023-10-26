package org.simpleframework.mvc.processor.impl;

import org.simpleframework.mvc.RequestProcessorChain;
import org.simpleframework.mvc.processor.RequestProcessor;

/**
 * 静态资源请求处理，包括但不限于图片、css以及js文件等
 *
 * @author yangxin
 * 2023/10/26 21:20
 */
public class StaticResourceRequestProcessor implements RequestProcessor {
    @Override
    public boolean process(RequestProcessorChain requestProcessorChain) throws Exception {
        return false;
    }
}
