package org.yangxin.entity.dto;

import lombok.Data;
import org.yangxin.entity.bo.HeadLine;
import org.yangxin.entity.bo.ShopCategory;

import java.util.List;

/**
 * @author yangxin
 * 2020/06/19 11:38
 */
@Data
public class MainPageInfoDTO {

    private List<HeadLine> headLineList;

    private List<ShopCategory> shopCategoryList;
}
