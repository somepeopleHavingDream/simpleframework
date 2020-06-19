package org.yangxin.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author yangxin
 * 2020/06/18 21:24
 */
@Data
public class ShopCategory {

    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
