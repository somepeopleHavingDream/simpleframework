package org.simpleframework.mvc.processor.impl;

import org.simpleframework.mvc.RequestProcessorChain;
import org.simpleframework.mvc.processor.RequestProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import java.util.Objects;

/**
 * jsp资源请求处理
 *
 * @author yangxin
 * 2023/10/26 21:21
 */
public class JspRequestProcessor implements RequestProcessor {

    /**
     * jsp请求的RequestDispatcher的名称
     */
    private static final String JSP_SERVLET = "jsp";

    /**
     * Jsp请求资源路径前缀
     */
    private static final String JSP_RESOURCE_PREFIX = "/templates/";

    /**
     * jsp的RequestDispatcher，处理jsp资源
     */
    private RequestDispatcher jspServlet;

    public JspRequestProcessor(ServletContext servletContext) {
        this.jspServlet = servletContext.getNamedDispatcher(JSP_SERVLET);
        if (Objects.isNull(this.jspServlet)) {
            throw new RuntimeException("there is no jsp servlet");
        }
    }

    @Override
    public boolean process(RequestProcessorChain requestProcessorChain) throws Exception {
        if (isJspResource(requestProcessorChain.getRequestPath())) {
            jspServlet.forward(requestProcessorChain.getRequest(), requestProcessorChain.getResponse());
            return false;
        }
        return true;
    }

    /**
     * 是否请求的是jsp资源
     */
    private boolean isJspResource(String url) {
        return url.startsWith(JSP_RESOURCE_PREFIX);
    }
}
