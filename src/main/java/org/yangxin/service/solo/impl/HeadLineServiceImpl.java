package org.yangxin.service.solo.impl;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Service;
import org.yangxin.entity.bo.HeadLine;
import org.yangxin.entity.dto.Result;
import org.yangxin.service.solo.HeadLineService;

import java.util.List;

/**
 * @author yangxin
 * 2020/06/19 11:35
 */
@Service
@Slf4j
public class HeadLineServiceImpl implements HeadLineService {

    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        log.info("addHeadLine被执行啦");
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
