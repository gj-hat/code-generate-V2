package com.jiaguo.codegenerategraduation.config.security.handler;

import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.common.http.WebResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/7/6 15:19
 * @description：身份验证处理器
 * @modified By：
 * @version: 1.0
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        WebResult.renderString(response, Result.fail(HttpStatus.FORBIDDEN.value(), "身份校验失败"));
    }
}