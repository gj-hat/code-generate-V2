package com.jiaguo.codegenerategraduation.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaguo.codegenerategraduation.common.exception.DatabaseException;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysMenuVo;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysUserVo;
import com.jiaguo.codegenerategraduation.web.entity.SysUser;
import com.jiaguo.codegenerategraduation.web.manager.RequestHolder;
import com.jiaguo.codegenerategraduation.web.mapper.SysUserMapper;
import com.jiaguo.codegenerategraduation.web.entity.UserRole;
import com.jiaguo.codegenerategraduation.web.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author JiaGuo
 * @since 2022-06-27 18:42:35
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;


    @Autowired
    private SysRoleServiceImpl sysRoleService;

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Autowired
    private SysMenuServiceImpl sysMenuService;

    @Autowired
    private RoleMenuServiceImpl roleMenuService;


    @Override
    public Result pageQuery(ReqParams<SysUserVo> params) {
        IPage<SysUserVo> page = new Page<>();
        page.setCurrent(params.getPageNum());
        page.setSize(params.getPageSize());
        IPage<SysUserVo> sysUserVoIPage;
        try {
            sysUserVoIPage = sysUserMapper.pageQueryUser(page, params.getData());
            sysUserVoIPage.getRecords().forEach(sysUserVo -> {
                // 传入用户id，查询user_role表的角色id
                int roleId = userRoleService.getRoleIdByUserId(sysUserVo.getId()).getRoleId();
                // 根据角色id查询sys_role表中的角色名称
                String roleName = sysRoleService.getRoleNameByRoleId(roleId);
                sysUserVo.setRoleId(roleId);
                sysUserVo.setRoleName(roleName);
            });
        }catch (DatabaseException e){
            logger.error("sysUserMapper.pageQuery 查询失败", e);
            return Result.fail("sysUserMapper.pageQuery 查询失败");
        }

        return Result.success(sysUserVoIPage);
    }

    @Override
    public Result saveSysUser(SysUserVo sysUserVo) {
        SysUser sysUser = new SysUser();
        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.eq("username", sysUser.getUsername());
        List<SysUser> sysUsers = sysUserMapper.selectList(qw);
        if (sysUsers.size() > 0) {
            throw new DatabaseException("用户名已存在");
        }
        sysUser.setUsername(sysUserVo.getUsername())
                .setPassword(sysUserVo.getPassword())
                .setNickname(sysUserVo.getNickname())
//                .setCreateTime(new Date())
//                .setCreateBy(RequestHolder.getAccountName())
//                .setUpdateTime(new Date())
//                .setUpdateBy(RequestHolder.getAccountName())
                .setDelFlag(0);

        this.save(sysUser);
        // 根据用户name查询sys_user表中的id
        QueryWrapper<SysUser> eq = new QueryWrapper<SysUser>().eq("username", sysUser.getUsername());
        SysUser sysUser1 = sysUserMapper.selectOne(eq);
        // 根据用户id和角色id插入user_role表
        userRoleService.saveData(sysUser1.getId(), sysUserVo.getRoleId());

        return Result.success("添加成功");

    }

    @Override
    public Result updateUser(SysUserVo sysUserVo) {
        SysUser sysUser = new SysUser();
        sysUser.setId(sysUserVo.getId())
                .setUsername(sysUserVo.getUsername())
                .setPassword(sysUserVo.getPassword())
                .setNickname(sysUserVo.getNickname());
//                .setUpdateTime(new Date())
//                .setUpdateBy(RequestHolder.getAccountName());
        try {
            updateById(sysUser);
            userRoleService.updateData(sysUserVo.getId(), sysUserVo.getRoleId());
        }catch (DatabaseException e){
            logger.error("updateUser 更新失败", e);
            return Result.fail("updateUser 更新失败");
        }
        return Result.success("更新成功");
    }

    @Override
    public Result removeUserByIds(List<Long> idList) {
        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.in("id", idList);
        try {
            sysUserMapper.selectList(qw).forEach(sysUser -> {
                sysUser.setDelFlag(1);
//                sysUser.setUpdateTime(new Date());
//                sysUser.setUpdateBy(RequestHolder.getAccountName());
                updateById(sysUser);
                // 根据用户id删除user_role表中的数据
                userRoleService.deleteByUserId(sysUser.getId());
            });
            return Result.success("删除成功");
        } catch (DatabaseException e) {
            e.printStackTrace();
            return Result.fail("删除失败");
        }

    }


    @Override
    public Result selectByLoginUser() {

        QueryWrapper<UserRole> qw = new QueryWrapper<>();
        qw.eq("user_id", RequestHolder.getUserId());
        UserRole one = userRoleService.getOne(qw);

        List<SysMenuVo> menuList = roleMenuService.getMenuList(one.getRoleId());

        return Result.success(menuList);
    }
}

