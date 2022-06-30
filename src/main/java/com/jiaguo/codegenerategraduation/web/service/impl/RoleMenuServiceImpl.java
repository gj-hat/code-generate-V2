package com.jiaguo.codegenerategraduation.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysMenuVo;
import com.jiaguo.codegenerategraduation.web.mapper.RoleMenuMapper;
import com.jiaguo.codegenerategraduation.web.mapper.SysMenuMapper;
import com.jiaguo.codegenerategraduation.web.po.RoleMenu;
import com.jiaguo.codegenerategraduation.web.po.SysMenu;
import com.jiaguo.codegenerategraduation.web.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 11:40
 * @description：角色和资源关联业务接口
 * @modified By：
 * @version: 1.0
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private SysMenuServiceImpl sysMenuService;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 更新角色 权限表
     * @param roleId
     * @param menuList
     * @return
     */
    @Override
    public Boolean updateData(int roleId, List<SysMenuVo> menuList) {

        // TODO JiaGuo 2022/7/1:
        return null;
    }

    /**
     * 根据角色id  查询菜单实体
     *
     * @param roleId
     * @return
     */
    public List<SysMenuVo> getMenuList(int roleId) {
        HashMap<String, Object> o = new HashMap<>();
        o.put("role_id", roleId);
        o.put("del_flag", 0);

        List<RoleMenu> roleMenus = roleMenuMapper.selectByMap(o);

        List<SysMenuVo> sysMenuVos = new ArrayList<>();

        for (RoleMenu r : roleMenus) {
            SysMenuVo s = sysMenuMapper.selectListByMenuId(r.getMenuId());
            sysMenuVos.add(s);
        }

        return sysMenuVos;
    }


}




















