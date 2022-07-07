package com.jiaguo.codegenerategraduation.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysMenuVo;
import com.jiaguo.codegenerategraduation.web.entity.SysMenu;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface SysMenuMapper extends BaseMapper<SysMenu> {

    IPage<SysMenuVo> pageQueryMenu(IPage<SysMenuVo> page,@Param("vo")  SysMenuVo data);

    List<SysMenuVo> selectByLoginUser(@Param("list") List<Integer> ids);

    SysMenuVo selectListByMenuId(@Param("id") int id);


}

