package com.jiaguo.codegenerategraduation.web.mapper.dto;

import com.jiaguo.codegenerategraduation.web.po.SysUser;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/29 00:31
 * @description：SysUserDto
 * @modified By：
 * @version: 1.0
 */

@Data

@ApiModel(value = "数据库实体: 用户表", description = "用户表")
public class SysUserDto {


    private Long id;
    private String username;
    private String password;
    private String nickname;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;

}

