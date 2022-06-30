package com.jiaguo.codegenerategraduation.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysRoleVo;
import com.jiaguo.codegenerategraduation.web.po.SysRole;
import io.swagger.models.auth.In;

import java.util.List;

public interface SysRoleService extends IService<SysRole> {


    String getRoleNameByRoleId(int roleId);

    Result pageQuery(ReqParams<SysRoleVo> params);

    Result saveSysRole(SysRoleVo sysRoleVo);

    Result updateRole(SysRoleVo sysRoleVo);

    Result removeRoleByIds(List<Integer> idList);
}
