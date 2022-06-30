package com.jiaguo.codegenerategraduation.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaguo.codegenerategraduation.common.exception.DatabaseException;
import com.jiaguo.codegenerategraduation.web.manager.RequestHolder;
import com.jiaguo.codegenerategraduation.web.mapper.UserRoleMapper;
import com.jiaguo.codegenerategraduation.web.po.UserRole;
import com.jiaguo.codegenerategraduation.web.service.UserRoleService;
import net.bytebuddy.utility.nullability.AlwaysNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 11:42
 * @description：用户和角色关联业务接口
 * @modified By：
 * @version: 1.0
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;


    /**
     * 根据用户id查询角色id
     *
     * @param id
     * @return
     */
    @Override
    public UserRole getRoleIdByUserId(Long id) {
        QueryWrapper<UserRole> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        qw.eq("del_flag", 0);
        UserRole userRole = userRoleMapper.selectOne(qw);
        if (userRole == null) {
            throw new DatabaseException("用户没有设定角色");
        }
        return userRole;
    }

    /**
     * 根据用户id删除用户和角色关联
     *
     * @param id
     * @return
     */
    public Boolean deleteByUserId(Long id) {
        UserRole userRole = new UserRole();
        userRole.setDelFlag(1)
                .setUpdateTime(new Date())
                .setUpdateBy(RequestHolder.getAccountName());

        return updateData(userRole);
    }

    /**
     * 新增数据
     *
     * @param userId
     * @param roleId
     * @return
     */
    public Boolean saveData(Long userId, int roleId) {
        UserRole userRole = new UserRole()
                .setUserId(userId)
                .setRoleId(roleId)
                .setDelFlag(0)
                .setCreateTime(new Date())
                .setCreateBy(RequestHolder.getAccountName())
                .setUpdateTime(new Date())
                .setUpdateBy(RequestHolder.getAccountName());

        return userRoleMapper.insert(userRole) > 0;
    }

    /**
     * 根据用户id更新用户和角色关联
     *
     * @param userRole
     * @return
     */
    public Boolean updateData(UserRole userRole) {
        int user_id = userRoleMapper.update(userRole, new QueryWrapper<UserRole>().eq("user_id", userRole.getUserId()));
        return user_id > 0;
    }

    /**
     * 根据用户id更新用户和角色关联
     *
     * @param id
     * @param roleId
     * @return
     */
    @Override
    public int updateData(Long id, int roleId) {

        return userRoleMapper.update(new UserRole()
                        .setRoleId(roleId)
                        .setUpdateTime(new Date())
                        .setUpdateBy(RequestHolder.getAccountName()),
                new QueryWrapper<UserRole>().eq("user_id", id));

    }
}
