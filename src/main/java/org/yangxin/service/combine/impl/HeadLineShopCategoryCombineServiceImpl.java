package org.yangxin.service.combine.impl;

import org.simpleframework.core.annotation.Service;
import org.simpleframework.inject.annotation.Autowired;
import org.yangxin.entity.bo.HeadLine;
import org.yangxin.entity.bo.ShopCategory;
import org.yangxin.entity.dto.MainPageInfoDTO;
import org.yangxin.entity.dto.Result;
import org.yangxin.service.combine.HeadLineShopCategoryCombineService;
import org.yangxin.service.solo.HeadLineService;
import org.yangxin.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @author yangxin
 * 2020/06/19 11:41
 */
@SuppressWarnings("unused")
@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {

    @Autowired
    private HeadLineService headLineService;
    @Autowired
    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        // 1. 获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headLineService.queryHeadLine(headLineCondition, 1, 4);

        // 2. 获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 4);

        // 3. 合并两者并返回
        return mergeMainPageInfoResult(headLineResult, shopCategoryResult);
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult,
                                                            Result<List<ShopCategory>> shopCategoryResult) {
        return null;
    }
}
