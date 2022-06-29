package com.jiaguo.codegenerategraduation.web.manager;


import com.jiaguo.codegenerategraduation.Constants;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/27 18:46
 * @description：全局请求上下文持有者
 * @modified By：
 * @version: 1.0
 */
public final class RequestHolder {

    private RequestHolder() {
    }

    private static ServletRequestAttributes getRequestContext() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }


    /**
     * @return
     */
    public static HttpServletRequest getRequest() {
        return getRequestContext().getRequest();
    }


    /**
     * 获取 header 信息
     *
     * @param name
     * @return
     */
    public static String getHeader(String name) {
        return getRequest().getHeader(name);
    }




    /**
     *
     * @return
     */
    public static Long getUserId() {
        final HttpServletRequest request = getRequest();
        return (Long) request.getAttribute(Constants.JWT_KEY_USERID);
    }

    public static String getUseAccount() {
        final HttpServletRequest request = getRequest();
        return (String) request.getAttribute(Constants.JWT_KEY_ACCOUNT);
    }



    /**
     * @param key
     * @param value
     * @param scope
     */
    public static void setAttribute(String key, Object value, int scope) {
        RequestAttributes requestAttributes = getRequestContext();
        requestAttributes.setAttribute(key, value, scope);
    }

    public static String getAccountName() {
        final HttpServletRequest request = getRequest();
        return (String) request.getAttribute(Constants.JWT_KEY_ACCOUNT);
    }
}
