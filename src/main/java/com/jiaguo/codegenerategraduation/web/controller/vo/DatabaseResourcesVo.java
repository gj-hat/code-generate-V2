package com.jiaguo.codegenerategraduation.web.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 数据源管理(DatabaseResources)实体类
 *
 * @author JiaGuo
 * @since 2022-07-06 10:36:46
 */
@Accessors(chain = true)
@Data
@ApiModel(value = "数据库请求实体: 数据源管理", description = "数据源管理(DatabaseResources)")
public class DatabaseResourcesVo {

    @ApiModelProperty(value = "主键", name = "id", example = "1")
    private int id;
    @ApiModelProperty(value = "连接名", name = "connectionName", example = "test")
    private String name;
    @ApiModelProperty(value = "备注", name = "remark", example = "test")
    private String remark;
    @ApiModelProperty(value = "主机连接地址", name = "host", example = "127.0.0.1")
    private String host;
    @ApiModelProperty(value = "端口", name = "port", example = "3306")
    private Integer port;
    @ApiModelProperty(value = "数据库名", name = "databaseName", example = "test")
    private String databaseName;
    @ApiModelProperty(value = "数据库类型", name = "databaseType", example = "1")
    private String databaseType;
    @ApiModelProperty(value = "数据库用户名", name = "username", example = "root")
    private String username;
    @ApiModelProperty(value = "数据库密码", name = "password", example = "123456")
    private String password;
    @ApiModelProperty(value = "驱动id 外键", name = "driverId", example = "1")
    private Integer driverId;
    @ApiModelProperty(value = "驱动名", name = "driverName", example = "mysql")
    private String driverName;
    @ApiModelProperty(value = "驱动地址", name = "driverUrl", example = "/usr/local/mysql/bin/mysql")
    private String driverUrl;
    //    @ApiModelProperty(value = "预留:所属角色功能", name = "roleId", example = "1")
//    private Integer roleId;
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-07-06 10:36:46")
    private Date createTime;
    @ApiModelProperty(value = "创建人", name = "createBy", example = "1")
    private String createBy;
    @ApiModelProperty(value = "更新时间", name = "updateTime", example = "2020-07-06 10:36:46")
    private Date updateTime;
    @ApiModelProperty(value = "更新人", name = "updateBy", example = "1")
    private String updateBy;
//    @ApiModelProperty(value = "删除标记", name = "delFlag", example = "1")
//    private Integer delFlag;
}
