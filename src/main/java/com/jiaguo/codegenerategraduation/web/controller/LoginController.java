package com.jiaguo.codegenerategraduation.web.controller;

import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.dao.SysUser;
import com.jiaguo.codegenerategraduation.web.service.impl.LoginServiceImpl;
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
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/logout", method = {RequestMethod.POST})
    public Result logout() {
        return loginService.logout();
    }



    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public Result login(@RequestBody SysUser user) {
        return loginService.login(user);
    }




}
