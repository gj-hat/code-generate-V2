package com.jiaguo.codegenerategraduation.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.dto.SysUserDto;
import com.jiaguo.codegenerategraduation.web.dao.SysUser;

/**
 * (SysUser)表服务接口
 *
 * @author JiaGuo
 * @since 2022-06-27 18:42:35
 */
public interface SysUserService extends IService<SysUser> {


    public IPage pageQuery(ReqParams<SysUser> params);


    public Result saveSysUser(SysUserDto sysUserDto);

    Result updateUser(SysUserDto sysUserDto);
}

