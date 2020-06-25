package org.yangxin.controller;

import lombok.extern.slf4j.Slf4j;
import org.yangxin.controller.frontend.MainPageController;
import org.yangxin.controller.superadmin.HeadLineOperationController;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 1. 拦截所有请求
 * 2. 解析请求
 * 3. 派发给对应的Controller里面的方法进行处理
 *
 * @author yangxin
 * 2020/06/25 23:53
 */
@WebServlet("/")
@Slf4j
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("request path is: [{}]", req.getServletPath());
        log.info("request method is: [{}]", req.getMethod());

        if (Objects.equals(req.getServletPath(), "/fontend/getmainpageinfo")
                && Objects.equals(req.getMethod(), "GET")) {
            new MainPageController().getMainPageInfo(req, resp);
        } else if (Objects.equals(req.getServletPath(), "/superadmin/addheadline")
                && Objects.equals(req.getMethod(), "POST")) {
            new HeadLineOperationController().addHeadLine(req, resp);
        }
    }
}
