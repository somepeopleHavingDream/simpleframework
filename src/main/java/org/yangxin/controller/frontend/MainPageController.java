package org.yangxin.controller.frontend;

import org.yangxin.entity.dto.MainPageInfoDTO;
import org.yangxin.entity.dto.Result;
import org.yangxin.service.combine.HeadLineShopCategoryCombineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangxin
 * 2020/06/26 00:03
 */
public class MainPageController {

    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest request, HttpServletResponse response) {
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
