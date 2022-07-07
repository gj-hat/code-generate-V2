package com.jiaguo.codegenerategraduation.web.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * 数据源管理(DatabaseResources)实体类
 *
 * @author JiaGuo
 * @since 2022-07-06 10:36:46
 */
@TableName("database_resources")
@Accessors(chain = true)
@Data
@ApiModel(value = "数据库实体: 数据源管理", description = "数据源管理(DatabaseResources)")
public class DatabaseResources implements Serializable {
    @Serial
    private static final long serialVersionUID = -69486951337918199L;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键", name = "id", example = "1")
    private int id;
    @ApiModelProperty(value = "连接名", name = "connectionName", example = "test")
    @TableField("name")
    private String name;
    @ApiModelProperty(value = "备注", name = "remark", example = "test")
    @TableField("remark")
    private String remark;
    @ApiModelProperty(value = "主机连接地址", name = "host", example = "127.0.0.1")
    @TableField("host")
    private String host;
    @ApiModelProperty(value = "端口", name = "port", example = "3306")
    @TableField("port")
    private Integer port;
    @ApiModelProperty(value = "数据库名", name = "databaseName", example = "test")
    @TableField("database_name")
    private String databaseName;
    @ApiModelProperty(value = "数据库用户名", name = "username", example = "root")
    @TableField("username")
    private String username;
    @ApiModelProperty(value = "数据库密码", name = "password", example = "123456")
    @TableField("password")
    private String password;
    @ApiModelProperty(value = "驱动id 外键", name = "driverId", example = "1")
    @TableField("driver_id")
    private Integer driverId;
    @ApiModelProperty(value = "数据库类型", name = "databaseType", example = "1")
    @TableField("database_type")
    private String databaseType;
    @ApiModelProperty(value = "预留:所属角色功能", name = "roleId", example = "1")
    @TableField("role_id")
    private Integer roleId;
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

