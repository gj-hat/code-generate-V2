package com.jiaguo.codegenerategraduation.web.controller.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/29 00:31
 * @description：SysUserDto
 * @modified By：
 * @version: 1.0
 */

@Data
@TableName("sys_user")
public class SysUserDto  {

    private Long id = null;

    @NotBlank(message = "用户名不能为空")
    private String username;
    @Size(min = 6, max = 18, message = "密码长度必须在6-18位之间")
    private String password;
    @NotBlank(message = "昵称不能为空")
    private String nickname;


}
