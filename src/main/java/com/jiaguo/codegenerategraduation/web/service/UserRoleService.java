package com.jiaguo.codegenerategraduation.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaguo.codegenerategraduation.web.entity.UserRole;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 11:42
 * @description：用户和角色关联业务接口
 * @modified By：
 * @version: 1.0
 */
public interface UserRoleService  extends IService<UserRole> {


    UserRole getRoleIdByUserId(Long id);

    int updateData(Long id, int roleId);
}
