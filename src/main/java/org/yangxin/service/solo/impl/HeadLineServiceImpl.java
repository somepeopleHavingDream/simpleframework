package org.yangxin.service.solo.impl;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Service;
import org.yangxin.entity.bo.HeadLine;
import org.yangxin.entity.dto.Result;
import org.yangxin.service.solo.HeadLineService;

import java.util.Collections;
import java.util.Date;
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
        log.info("headLine -> {}", headLine);

        Result<Boolean> result = new Result<>();
        result.setCode(200);
        result.setMsg("请求成功啦");
        result.setData(true);

        return result;
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
        HeadLine headLine = new HeadLine();
        headLine.setLineId(0L);
        headLine.setLineName("");
        headLine.setLineLink("");
        headLine.setLineImg("");
        headLine.setPriority(0);
        headLine.setEnableStatus(0);
        headLine.setCreateTime(new Date());
        headLine.setLastEditTime(new Date());

        Result<List<HeadLine>> result = new Result<>();
        result.setData(Collections.singletonList(headLine));
        result.setCode(200);
        return result;
    }
}
