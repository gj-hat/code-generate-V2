package com.jiaguo.codegenerategraduation.web.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@ApiModel(value = "数据库实体: 用户表", description = "用户表")
public class SysUser extends Model<SysUser> {

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
    @TableField("create_time")
    @NotBlank(message = "创建时间不能为空")
    private Date createTime;
    @TableField("create_by")
    @NotBlank(message = "创建人不能为空")
    private String createBy;
    @TableField("update_time")
    @NotBlank(message = "更新时间不能为空")
    private Date updateTime;
    @TableField("update_by")
    private String updateBy;
    @TableField("del_flag")
    private int delFlag;





}


