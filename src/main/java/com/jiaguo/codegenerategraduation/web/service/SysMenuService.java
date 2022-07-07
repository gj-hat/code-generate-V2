package com.jiaguo.codegenerategraduation.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysMenuVo;
import com.jiaguo.codegenerategraduation.web.entity.SysMenu;

import java.util.List;

public interface SysMenuService  extends IService<SysMenu> {
    Result pageQuery(ReqParams<SysMenuVo> param);

//    Result selectByLoginUser();

    List<SysMenuVo> selectByLoginUser(List<Integer> ids);


    SysMenuVo selectListByMenuId(int id);





}
