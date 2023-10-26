package org.simpleframework.mvc;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.aop.AspectWeaver;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.DependencyInjector;
import org.simpleframework.mvc.processor.RequestProcessor;
import org.simpleframework.mvc.processor.impl.ControllerRequestProcessor;
import org.simpleframework.mvc.processor.impl.JspRequestProcessor;
import org.simpleframework.mvc.processor.impl.PreRequestProcessor;
import org.simpleframework.mvc.processor.impl.StaticResourceRequestProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 拦截所有请求
 * 2. 解析请求
 * 3. 派发给对应的Controller里面的方法进行处理
 *
 * @author yangxin
 * 2020/06/25 23:53
 */
@WebServlet("/*")
@Slf4j
public class DispatcherServlet extends HttpServlet {

    private static final List<RequestProcessor> PROCESSOR = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // 1 初始化容器
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("org.yangxin");
        new AspectWeaver().doAop();
        new DependencyInjector().doIoc();

        // 2 初始化请求处理器责任链
        PROCESSOR.add(new PreRequestProcessor());
        PROCESSOR.add(new StaticResourceRequestProcessor());
        PROCESSOR.add(new JspRequestProcessor());
        PROCESSOR.add(new ControllerRequestProcessor());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 创建责任链对象实例
        RequestProcessorChain requestProcessorChain = new RequestProcessorChain(PROCESSOR.iterator(), req, resp);
        // 2 通过责任链模式来依次调用请求处理器对请求进行处理
        requestProcessorChain.doRequestProcessorChain();
        // 3 对处理结果进行渲染
        requestProcessorChain.doRender();
    }
}
