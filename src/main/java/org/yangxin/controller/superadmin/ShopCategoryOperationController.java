package org.yangxin.controller.superadmin;

import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;
import org.yangxin.entity.bo.ShopCategory;
import org.yangxin.entity.dto.Result;
import org.yangxin.service.solo.ShopCategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author yangxin
 * 2020/06/26 00:17
 */
@SuppressWarnings("unused")
@Controller
public class ShopCategoryOperationController {

    @Autowired
    private ShopCategoryService shopCategoryService;

    public Result<Boolean> addShopCategory(HttpServletRequest request, HttpServletResponse response) {
        // todo: 参数校验一级请求参数转换
        return shopCategoryService.addShopCategory(new ShopCategory());
    }

    public Result<Boolean> removeShopCategory(HttpServletRequest request, HttpServletResponse response) {
        // todo: 参数校验一级请求参数转换
        return shopCategoryService.removeShopCategory(1);
    }

    public Result<Boolean> modifyShopCategory(HttpServletRequest request, HttpServletResponse response) {
        // todo: 参数校验一级请求参数转换
        return shopCategoryService.modifyShopCategory(new ShopCategory());
    }

    public Result<ShopCategory> queryShopCategoryById(HttpServletRequest request, HttpServletResponse response) {
        // todo: 参数校验一级请求参数转换
        return shopCategoryService.queryShopCategoryById(1);
    }

    public Result<List<ShopCategory>> queryShopCategory(HttpServletRequest request, HttpServletResponse response) {
        // todo: 参数校验一级请求参数转换
        return shopCategoryService.queryShopCategory(null, 1, 100);
    }
}
