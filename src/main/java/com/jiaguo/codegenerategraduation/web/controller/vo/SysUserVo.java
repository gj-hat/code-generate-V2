package com.jiaguo.codegenerategraduation.web.controller.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
@Accessors(chain = true)
@ApiModel(value = "请求实体: 系统用户", description = "系统用户")
public class SysUserVo {

    private Long id = null;
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", name = "username", example = "admin", required = true)
    private String username;
    @Size(min = 6, max = 18, message = "密码长度必须在6-18位之间")
    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    private String password;
    @NotBlank(message = "昵称不能为空")
    @ApiModelProperty(value = "昵称", name = "nickname", example = "admin")
    private String nickname;
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-06-29 00:31:00")
    private Date createTime;
    @ApiModelProperty(value = "创建人", name = "createBy", example = "admin")
    private String createBy;
    @ApiModelProperty(value = "更新时间", name = "updateTime", example = "2020-06-29 00:31:00")
    private Date updateTime;
    @ApiModelProperty(value = "更新人", name = "updateBy", example = "admin")
    private String updateBy;
    @ApiModelProperty(value = "角色id", name = "roleId", example = "1")
     private int roleId = -1;
    @ApiModelProperty(value = "角色名称", name = "roleName", example = "管理员")
    private String roleName;


}
