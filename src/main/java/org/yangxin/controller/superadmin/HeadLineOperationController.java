package org.yangxin.controller.superadmin;

import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;
import org.simpleframework.mvc.annotation.RequestMapping;
import org.simpleframework.mvc.type.RequestMethod;
import org.yangxin.entity.bo.HeadLine;
import org.yangxin.entity.dto.Result;
import org.yangxin.service.solo.HeadLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author yangxin
 * 2020/06/26 00:06
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
@Controller
@RequestMapping(value = "/headline")
public class HeadLineOperationController {

    @Autowired(value = "HeadLineServiceImpl")
    private HeadLineService headLineService;

    public Result<Boolean> addHeadLine(HttpServletRequest request, HttpServletResponse response) {
        // todo: 参数校验一级请求参数转换
        return headLineService.addHeadLine(new HeadLine());
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public void removeHeadLine() {
        System.out.println("删除HeadLine");
    }

    public Result<Boolean> modifyHeadLine(HttpServletRequest request, HttpServletResponse response) {
        // todo: 参数校验一级请求参数转换
        return headLineService.modifyHeadLine(new HeadLine());
    }

    public Result<HeadLine> queryHeadLineById(HttpServletRequest request, HttpServletResponse response) {
        // todo: 参数校验一级请求参数转换
        return headLineService.queryHeadLineById(1);
    }

    public Result<List<HeadLine>> queryHeadLine(HttpServletRequest request, HttpServletResponse response) {
        // todo: 参数校验一级请求参数转换
        return headLineService.queryHeadLine(null, 1, 100);
    }
}