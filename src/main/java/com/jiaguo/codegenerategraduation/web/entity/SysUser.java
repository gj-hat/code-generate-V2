package com.jiaguo.codegenerategraduation.web.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * (SysUser)表实体类
 *
 * @author JiaGuo
 * @since 2022-06-27 18:42:33
 */

@Data
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value = "数据库实体: 系统用户", description = "系统用户")
public class SysUser {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id", name = "id", example = "1")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @TableField(value = "username")
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", name = "username", example = "admin", required = true)
    private String username;
    @TableField("password")
    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    private String password;
    @TableField("nickname")
    @ApiModelProperty(value = "昵称", name = "nickname", example = "admin")
    private String nickname;
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-07-06 10:36:46")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人", name = "createBy", example = "1")
    private String createBy;
    @ApiModelProperty(value = "更新时间", name = "updateTime", example = "2020-07-06 10:36:46")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @ApiModelProperty(value = "更新人", name = "updateBy", example = "1")
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    @ApiModelProperty(value = "删除标记", name = "delFlag", example = "1")
    @TableField("del_flag")
    private Integer delFlag;
}


