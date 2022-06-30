package com.jiaguo.codegenerategraduation.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysUserVo;
import com.jiaguo.codegenerategraduation.web.po.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * (SysUser)表数据库访问层
 *
 * @author JiaGuo
 * @since 2022-06-27 18:42:30
 */

public interface SysUserMapper extends BaseMapper<SysUser> {
    IPage<SysUserVo> pageQueryUser(IPage<SysUserVo> sysUserVoIPage, @Param("vo") SysUserVo sysUserVo);



}

