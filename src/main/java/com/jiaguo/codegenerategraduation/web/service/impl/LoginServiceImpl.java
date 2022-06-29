package com.jiaguo.codegenerategraduation.web.service.impl;

import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.config.security.jwtManager.JwtManager;
import com.jiaguo.codegenerategraduation.config.security.jwtManager.JwtUser;
import com.jiaguo.codegenerategraduation.util.RedisCache;
import com.jiaguo.codegenerategraduation.web.dao.SysUser;
import com.jiaguo.codegenerategraduation.web.manager.RequestHolder;
import com.jiaguo.codegenerategraduation.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;


    @Override
    public Result login(SysUser user) {

        // AuthenticationManager进行认证   查询数据库找到用户名和密码
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // authenticate不通给出对应的提示 抛出异常登录失败
        if (authenticate == null) {
            throw new RuntimeException("登录失败");
        }

        // 认证成功，使用userid生成一个jwt
        JwtUser loginUser = (JwtUser) authenticate.getPrincipal();
        Map<String, Object> stringObjectMap = JwtManager.builderClaims(loginUser, "");
        String jwt = JwtManager.builderToken(stringObjectMap);

        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);

        // 把完整的用户信息存入redis中 userid作为key
        redisCache.setCacheObject("login:" + loginUser.getId(), loginUser);

        return Result.success("登录成功", map);
    }


    @Override
    public Result logout() {

        // 删除redis
        redisCache.deleteObject("login:" + RequestHolder.getUserId());

        return Result.success("退出成功");
    }
}

