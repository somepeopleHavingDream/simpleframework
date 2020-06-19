package org.yangxin.service.solo;

import org.yangxin.entity.bo.HeadLine;
import org.yangxin.entity.dto.Result;

import java.util.List;

/**
 * @author yangxin
 * 2020/06/19 11:17
 */
public interface HeadLineService {

    Result<Boolean> addHeadLine(HeadLine headLine);
    Result<Boolean> removeHeadLine(int headLineId);
    Result<Boolean> modifyHeadLine(HeadLine headLine);
    Result<HeadLine> queryHeadLineById(int headLineId);
    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize);
}
