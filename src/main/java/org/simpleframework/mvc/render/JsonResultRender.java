package org.simpleframework.mvc.render;

import com.google.gson.Gson;
import org.simpleframework.mvc.RequestProcessorChain;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Json渲染器
 *
 * @author yangxin
 * 2023/10/26 21:38
 */
public class JsonResultRender implements ResultRender {

    private final Object jsonData;
    private final Gson gson = new Gson();

    public JsonResultRender(Object jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public void render(RequestProcessorChain requestProcessorChain) throws Exception {
        // 设置响应头
        HttpServletResponse response = requestProcessorChain.getResponse();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 响应流写入经过 gson 格式化之后的处理结果
        try (PrintWriter writer = requestProcessorChain.getResponse().getWriter()) {
            writer.write(gson.toJson(jsonData));
            writer.flush();
        }
    }
}
