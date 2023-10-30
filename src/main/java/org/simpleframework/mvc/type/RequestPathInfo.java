package org.simpleframework.mvc.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 存储http请求路径和请求方法
 *
 * @author yangxin
 * 2023/10/30 21:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPathInfo {

    /**
     * http请求方法
     */
    private String httpMethod;

    /**
     * http请求路径
     */
    private String httpPath;
}
