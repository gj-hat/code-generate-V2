package com.jiaguo.codegenerategraduation.web.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 系统参数(SysParams)表实体类
 *
 * @author JiGuo
 * @since 2022-07-07 17:31:12
 */
@ApiModel(value = "数据库实体:系统参数")
@TableName(value = "sys_params")
@Data
@Accessors(chain = true)
public class SysParams {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键" , name = "id", example = "1", required = true)
    private Integer id;
    @TableField(value = "key")
    @ApiModelProperty(value = "key", name = "key", example = "key", required = true)
    private String key;
    @TableField(value = "value")
    @ApiModelProperty(value = "value", name = "value", example = "value", required = true)
    private String value;
    @TableField(value = "del_flag")
    @ApiModelProperty(value = "删除标记", name = "delFlag", example = "1")
    private Integer delFlag;
    @TableField(value = "remark")
    @ApiModelProperty(value = "备注", name = "remark", example = "备注", required = true)
    private String remark;
    @TableField(value = "create_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-07-07 17:31:12")
    private Date createTime;
    @TableField(value = "create_by", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "创建人", name = "createBy", example = "JiGuo")
    private String createBy;
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新时间", name = "updateTime", example = "2020-07-07 17:31:12")
    private Date updateTime;
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新人", name = "updateBy", example = "JiGuo")
    private String updateBy;
}

