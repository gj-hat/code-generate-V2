package com.jiaguo.codegenerategraduation.web.service;

import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.dao.SysUser;

public interface LoginService {
    Result login(SysUser user);

    Result logout();
}