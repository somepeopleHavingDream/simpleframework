package org.simpleframework.mvc.processor;

import org.simpleframework.mvc.RequestProcessorChain;

/**
 * 请求执行器
 *
 * @author yangxin
 * 2023/10/26 21:17:00
 */
public interface RequestProcessor {

    boolean process(RequestProcessorChain requestProcessorChain) throws Exception;
}
