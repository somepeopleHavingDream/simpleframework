package org.yangxin.service.solo;

import org.yangxin.entity.bo.HeadLine;
import org.yangxin.entity.bo.ShopCategory;
import org.yangxin.entity.dto.Result;

import java.util.List;

/**
 * @author yangxin
 * 2020/06/19 11:32
 */
public interface ShopCategoryService {

    Result<Boolean> addShopCategory(ShopCategory shopCategory);
    Result<Boolean> removeShopCategory(int shopCategoryId);
    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);
    Result<ShopCategory> queryShopCategoryById(int shopCategoryId);
    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}
