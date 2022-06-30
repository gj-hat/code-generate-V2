package com.jiaguo.codegenerategraduation.web.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 11:16
 * @description：用户角色关联表
 * @modified By：
 * @version: 1.0
 */
@Data
@TableName("user_role")
@Accessors(chain = true)
@ApiModel(value = "数据库实体: 用户角色关联表", description = "用户角色关联表")
public class UserRole {

    @TableField("user_id")
    @ApiModelProperty(value = "用户id", name = "userId", example = "1", required = true)
    private Long userId;
    @TableField("role_id")
    @ApiModelProperty(value = "角色id", name = "roleId", example = "1", required = true)
    private int roleId;
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-06-30 10:56:00", required = true)
    @TableField("create_time")
    private Date createTime;
    @ApiModelProperty(value = "创建人", name = "createUser", example = "1", required = true)
    @TableField("create_by")
    private String createBy;
    @ApiModelProperty(value = "修改时间", name = "updateTime", example = "2020-06-30 10:56:00", required = true)
    @TableField("update_time")
    private Date updateTime;
    @ApiModelProperty(value = "修改人", name = "updateUser", example = "1", required = true)
    @TableField("update_by")
    private String updateBy;
    @ApiModelProperty(value = "菜单状态", name = "menuStatus", example = "1", required = true)
    @TableField("del_flag")
    private int delFlag;




}
