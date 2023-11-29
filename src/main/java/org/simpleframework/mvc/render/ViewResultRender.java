package org.simpleframework.mvc.render;

import org.simpleframework.mvc.RequestProcessorChain;
import org.simpleframework.mvc.type.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 页面渲染器
 *
 * @author yangxin
 * 2023/10/26 21:39
 */
public class ViewResultRender implements ResultRender {

    public static final String VIEW_PATH = "/templates/";
    private final ModelAndView modelAndView;

    /**
     * 对传入的参数进行处理，并赋值给 ModelAndView 成员变量
     */
    public ViewResultRender(Object mv) {
        if (mv instanceof ModelAndView) {
            // 1 如果入参类型是 ModelAndView ，则直接赋值给成员变量
            this.modelAndView = (ModelAndView) mv;
        } else if (mv instanceof String) {
            // 2 如果入参类型是 String ，则为视图，需要包装后才赋值给成员变量
            this.modelAndView = new ModelAndView().setView((String) mv);
        } else {
            // 3 针对其他情况，则直接抛出异常
            throw new RuntimeException("illegal request result type");
        }
    }

    /**
     * 将请求处理结果按照视图路径转发至对应视图进行展示
     */
    @Override
    public void render(RequestProcessorChain requestProcessorChain) throws Exception {
        HttpServletRequest request = requestProcessorChain.getRequest();
        HttpServletResponse response = requestProcessorChain.getResponse();

        String path = modelAndView.getView();
        Map<String, Object> model = modelAndView.getModel();
        for (Map.Entry<String, Object> entry : model.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }

        // JSP
        request.getRequestDispatcher(VIEW_PATH + path).forward(request, response);
    }
}
