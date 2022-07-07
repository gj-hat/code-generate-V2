package com.jiaguo.codegenerategraduation.common.http;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebResult
{
    /**
     * 将字符串渲染到客户端
     * 
     * @param response 渲染对象
     * @param result 待渲染的字符串
     * @return null
     */
    public static String renderString(HttpServletResponse response, Result result) {
        try
        {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(result);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}