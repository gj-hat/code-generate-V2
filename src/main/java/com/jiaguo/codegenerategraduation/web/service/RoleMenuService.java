package com.jiaguo.codegenerategraduation.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysMenuVo;
import com.jiaguo.codegenerategraduation.web.po.RoleMenu;

import java.util.List;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 11:40
 * @description：角色和资源关联业务接口
 * @modified By：
 * @version: 1.0
 */

public interface RoleMenuService extends IService<RoleMenu> {


    Boolean updateData(int roleId, List<SysMenuVo> menuList);


    public List<SysMenuVo> getMenuList(int roleId);
}
