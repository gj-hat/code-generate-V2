package com.jiaguo.codegenerategraduation.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysUserVo;
import com.jiaguo.codegenerategraduation.web.entity.SysUser;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author JiaGuo
 * @since 2022-06-27 18:42:35
 */
public interface SysUserService extends IService<SysUser> {


    public Result pageQuery(ReqParams<SysUserVo> params);


    public Result saveSysUser(SysUserVo sysUserVo);

    Result updateUser(SysUserVo sysUserVo);

    Result removeUserByIds(List<Long> idList);

    Result selectByLoginUser();
}

