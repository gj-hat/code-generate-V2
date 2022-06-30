package com.jiaguo.codegenerategraduation.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaguo.codegenerategraduation.common.exception.DatabaseException;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysMenuVo;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysRoleVo;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysRoleVo;
import com.jiaguo.codegenerategraduation.web.manager.RequestHolder;
import com.jiaguo.codegenerategraduation.web.mapper.RoleMenuMapper;
import com.jiaguo.codegenerategraduation.web.mapper.SysRoleMapper;
import com.jiaguo.codegenerategraduation.web.mapper.UserRoleMapper;
import com.jiaguo.codegenerategraduation.web.po.RoleMenu;
import com.jiaguo.codegenerategraduation.web.po.SysRole;
import com.jiaguo.codegenerategraduation.web.po.UserRole;
import com.jiaguo.codegenerategraduation.web.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 15:25
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private static final Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Autowired
    private RoleMenuServiceImpl roleMenuService;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 根据角色id查询角色名
     *
     * @param roleId
     * @return
     */
    @Override
    public String getRoleNameByRoleId(int roleId) {

        QueryWrapper<SysRole> qw = new QueryWrapper<>();
        qw.eq("role_id", roleId);
        qw.eq("del_flag", 0);
        SysRole sysRole = sysRoleMapper.selectOne(qw);
        if (sysRole == null) {
            throw new DatabaseException("角色不存在");
        }
        return sysRole.getRoleName();
    }

    /**
     * 角色分页查询
     * @param params
     * @return
     */
    @Override
    public Result pageQuery(ReqParams<SysRoleVo> params) {
        IPage<SysRoleVo> page = new Page<>(params.getPageNum(), params.getPageSize());
        IPage<SysRoleVo> sysRoleVoIPage;
        try {
            sysRoleVoIPage = sysRoleMapper.pageQueryMenu(page, params.getData());
            sysRoleVoIPage.getRecords().forEach(sysRoleVo -> {
                int roleId = sysRoleVo.getRoleId();
                // 根据roleId  查询 该角色的菜单权限
                List<SysMenuVo> menuList1 = roleMenuService.getMenuList(roleId);

                sysRoleVo.setMenuList(menuList1);

            });


        } catch (DatabaseException e) {
            logger.error("sysRoleMapper.pageQuery 查询失败", e);
            return Result.fail("sysRoleMapper.pageQuery 查询失败");
        }
        return Result.success(sysRoleVoIPage);
    }

    /**
     * 新增数据
     *
     * @param sysRoleVo
     * @return
     */
    @Override
    public Result saveSysRole(SysRoleVo sysRoleVo) {
        SysRole sysRole = new SysRole()
                .setRoleName(sysRoleVo.getRoleName())
                .setCreateTime(new Date())
                .setCreateBy(RequestHolder.getAccountName())
                .setUpdateTime(new Date())
                .setUpdateBy(RequestHolder.getAccountName())
                .setDelFlag(0);
        try {
            this.save(sysRole);
        } catch (DatabaseException e) {
            logger.error("sysRoleMapper.saveSysRole 新增失败", e);
            return Result.fail("sysRoleMapper.saveSysRole 新增失败");
        }
        return Result.success("添加成功");
    }

    /**
     * 修改数据
     *
     * @param sysRoleVo
     * @return
     */

    @Override
    public Result updateRole(SysRoleVo sysRoleVo) {
        SysRole sysRole = new SysRole()
                .setRoleName(sysRoleVo.getRoleName())
                .setUpdateTime(new Date())
                .setUpdateBy(RequestHolder.getAccountName());

        this.saveOrUpdate(sysRole);
        // 传入角色id，更新角色与菜单的关联关系
        roleMenuService.updateData(sysRoleVo.getRoleId(), sysRoleVo.getMenuList());

        return Result.success("更新成功");
    }

    /**
     * 删除数据
     *
     * @param idList
     * @return
     */
    @Override
    public Result removeRoleByIds(List<Integer> idList) {


        // TODO JiaGuo 2022/6/30: 这里可以使用selectBatchIds批量查询优化
//        List<UserRole> userRoles = userRoleMapper.selectBatchIds(idList);

        // 需要先判断 用户角色关联表 是否有数据
        for (int id : idList) {
            QueryWrapper<UserRole> qw = new QueryWrapper<>();
            qw.eq("role_id", id);
            UserRole one = userRoleService.getOne(qw);
            if (one != null) {
                return Result.fail("角色已被用户使用，先修改或者删除对应角色");
            } else {
                // 删除标记为1
                SysRole sysRole = new SysRole().setDelFlag(1);
                this.update(sysRole, new UpdateWrapper<SysRole>().eq("role_id", id));

                // 删除角色权限表数据    删除标记为1
                roleMenuService.update(new UpdateWrapper<RoleMenu>()
                        .eq("role_id", id)
                        .set("del_flag", 1)
                        .set("update_time", new Date())
                        .set("update_by", RequestHolder.getAccountName()));
            }
        }
        return Result.success("删除成功");
    }
}
