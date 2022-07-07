package com.jiaguo.codegenerategraduation.filter;

import com.jiaguo.codegenerategraduation.Constants;
import com.jiaguo.codegenerategraduation.config.security.jwtManager.JwtManager;
import com.jiaguo.codegenerategraduation.config.security.jwtManager.JwtUser;
import com.jiaguo.codegenerategraduation.util.RedisCache;
import com.jiaguo.codegenerategraduation.web.manager.RequestHolder;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 过滤器 每个请求都会执行一次
 *
 * @author JiaGuo
 * @since 2022-06-27 18:42:35
 */


@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader(Constants.REQUEST_HEAD);
        // 没有token
        if (!StringUtils.hasText(token) || token.equals(" ") || token.equals("undefined")) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }
        //解析token
        Long userid;

        try {
            Claims claims = JwtManager.parse(token);
            userid = (Long) claims.get(Constants.JWT_KEY_USERID);
            RequestHolder.setAttribute(Constants.JWT_KEY_ACCOUNT, claims.get(Constants.JWT_KEY_ACCOUNT, String.class), RequestAttributes.SCOPE_REQUEST);
            RequestHolder.setAttribute(Constants.JWT_KEY_USERID, claims.get(Constants.JWT_KEY_USERID, Long.class), RequestAttributes.SCOPE_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }

        //从redis中获取用户信息
        String redisKey = "login:" + userid;
        JwtUser loginUser;
        try {
             loginUser = redisCache.getCacheObject(redisKey);
        } catch (RedisConnectionFailureException e) {
            throw new RuntimeException("认证失败");
        }


        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }
        //存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //放行
        filterChain.doFilter(request, response);
    }
}