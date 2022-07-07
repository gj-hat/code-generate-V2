package com.jiaguo.codegenerategraduation.web.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 数据库驱动表(DatabaseDriver)表实体类
 *
 * @author JiaGuo
 * @since 2022-07-04 10:44:13
 */
@Data
@Accessors(chain = true)
@TableName(value = "database_driver")
@ApiModel(value = "数据库实体: 数据库驱动表", description = "这里放的是数据库的驱动程序")
public class DatabaseDriver {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "驱动id", name = "id", example = "1", required = true)
    private Integer id;
    @ApiModelProperty(value = "驱动名", name = "driverName", example = "mysql", required = true)
    @TableField("name")
    private String name;
    @ApiModelProperty(value = "备注", name = "remark", example = "mysql", required = true)
    @TableField("remark")
    private String remark;
    @ApiModelProperty(value = "驱动地址", name = "driverUrl", example = "jdbc:mysql://localhost:3306/test", required = true)
    @TableField("url")
    private String url;
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-07-06 10:36:46")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人", name = "createBy", example = "JiaGuo", required = true)
    private String createBy;
    @ApiModelProperty(value = "更新时间", name = "updateTime", example = "2020-07-06 10:36:46")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    @ApiModelProperty(value = "删除标记", name = "delFlag", example = "1")
    @TableField("del_flag")
    private Integer delFlag;

    // 这个字段暂时废弃不用
//    @TableField(value = "role_id")
//    @ApiModelProperty(value = "所属角色功能", name = "roleId", example = "1", required = true)
//    private Integer roleId = 0;
}
