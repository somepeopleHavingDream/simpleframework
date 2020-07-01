package org.yangxin.service.solo.impl;

import org.yangxin.entity.bo.ShopCategory;
import org.yangxin.entity.dto.Result;
import org.yangxin.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @author yangxin
 * 2020/06/19 11:35
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
