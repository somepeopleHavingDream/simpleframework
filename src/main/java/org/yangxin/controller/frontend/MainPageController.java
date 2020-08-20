package org.yangxin.controller.frontend;

import lombok.Getter;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;
import org.yangxin.entity.dto.MainPageInfoDTO;
import org.yangxin.entity.dto.Result;
import org.yangxin.service.combine.HeadLineShopCategoryCombineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangxin
 * 2020/06/26 00:03
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
@Controller
@Getter
public class MainPageController {

    @Autowired
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest request, HttpServletResponse response) {
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
