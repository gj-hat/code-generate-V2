package com.jiaguo.codegenerategraduation.web.controller;

import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.entity.SysUser;
import com.jiaguo.codegenerategraduation.web.service.impl.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/28 10:30
 * @description：登录
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/admin")
@Api(value = "登录相关", tags = "登录相关")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/logout", method = {RequestMethod.POST})
    @ApiOperation(value = "退出登录接口", notes="需要token")
    public Result logout() {
        return loginService.logout();
    }



    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ApiOperation(value = "登录接口", notes="不需要token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名",  dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string")
    })
    public Result login(@RequestBody SysUser user) {
        return loginService.login(user);
    }





}
