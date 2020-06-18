package org.yangxin.entity.bo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author yangxin
 * 2020/06/18 21:19
 */
@Data
public class HeadLine {

    private Long lineId;
    private String lineName;
    private String lineLine;
    private String lineImg;
    private Integer priority;
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;
}
