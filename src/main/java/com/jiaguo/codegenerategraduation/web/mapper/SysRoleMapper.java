package com.jiaguo.codegenerategraduation.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysRoleVo;
import com.jiaguo.codegenerategraduation.web.entity.SysRole;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 15:23
 * @description：系统角色Mapeper
 * @modified By：
 * @version: 1.0
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    IPage<SysRoleVo> pageQueryMenu(IPage<SysRoleVo> page,@Param("vo") SysRoleVo data);
}
