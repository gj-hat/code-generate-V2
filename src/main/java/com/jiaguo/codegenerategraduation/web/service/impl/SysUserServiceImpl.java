package com.jiaguo.codegenerategraduation.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.dto.SysUserDto;
import com.jiaguo.codegenerategraduation.web.dao.SysUser;
import com.jiaguo.codegenerategraduation.web.manager.RequestHolder;
import com.jiaguo.codegenerategraduation.web.mapper.SysUserMapper;
import com.jiaguo.codegenerategraduation.web.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
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


    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public IPage pageQuery(ReqParams<SysUser> params) {
        IPage<SysUser> page = new Page<>();
        page.setCurrent(params.getPageNum());
        page.setSize(params.getPageSize());
        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.eq("del_flag", 0);
        qw.orderByDesc("create_time");
        page = this.page(page, qw);
        return page;
    }


    @Override
    public Result saveSysUser(SysUserDto sysUserDto) {

        SysUser sysUser = new SysUser();

        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.eq("username", sysUser.getUsername());
        List<SysUser> sysUsers = sysUserMapper.selectList(qw);

        if (sysUsers.size() != 0) {
            return Result.fail("账号重复！ 请重试");
        }

        sysUser.setUsername(sysUserDto.getUsername())
                .setPassword(sysUserDto.getPassword())
                .setNickname(sysUserDto.getNickname())
                .setCreateTime(new Date())
                .setCreateBy(RequestHolder.getAccountName())
                .setUpdateTime(new Date())
                .setUpdateBy(RequestHolder.getAccountName())
                .setDelFlag(0);

        return Result.success(save(sysUser));

    }

    @Override
    public Result updateUser(SysUserDto sysUserDto) {
        SysUser sysUser = new SysUser();

        sysUser.setId(sysUserDto.getId())
                .setUsername(sysUserDto.getUsername())
                .setPassword(sysUserDto.getPassword())
                .setNickname(sysUserDto.getNickname())
                .setUpdateTime(new Date())
                .setUpdateBy(RequestHolder.getAccountName());

        return Result.success(updateById(sysUser));

    }
}

