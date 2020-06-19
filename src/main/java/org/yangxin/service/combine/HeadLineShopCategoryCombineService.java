package org.yangxin.service.combine;

import org.yangxin.entity.dto.MainPageInfoDTO;
import org.yangxin.entity.dto.Result;

/**
 * @author yangxin
 * 2020/06/19 11:37
 */
public interface HeadLineShopCategoryCombineService {

    Result<MainPageInfoDTO> getMainPageInfo();
}
