package com.jiaguo.codegenerategraduation.web.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 11:05
 * @description：系统角色管理表
 * @modified By：
 * @version: 1.0
 */
@Data
@TableName("sys_role")
@Accessors(chain = true)
@ApiModel(value = "数据库实体: 系统角色管理表", description = "系统角色管理表")
public class SysRole {

    @ApiModelProperty(value = "角色id", name = "roleId", example = "1", required = true)
    @TableId(value = "role_id", type = IdType.AUTO)
    private int roleId;
    @ApiModelProperty(value = "角色名称", name = "roleName", example = "管理员", required = true)
    @TableField("role_name")
    private String roleName;
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
