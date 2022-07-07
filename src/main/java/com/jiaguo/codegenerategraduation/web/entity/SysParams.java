package com.jiaguo.codegenerategraduation.web.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 系统参数(SysParams)表实体类
 *
 * @author JiGuo
 * @since 2022-07-07 17:31:12
 */
@ApiModel(value = "SysParams", description = "系统参数(SysParams)表实体类")
@TableName(value = "sys_params")
@Data
@Accessors(chain = true)
public class SysParams {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;
    @TableField(value = "key")
    @ApiModelProperty(value = "key")
    private String key;
    @TableField(value = "value")
    @ApiModelProperty(value = "value")
    private String value;
    //删除标记
    @TableField(value = "del_flag")
    @ApiModelProperty(value = "删除标记")
    private Integer delFlag;
    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;
    @TableField(value = "create_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @TableField(value = "create_by", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新人")
    private String updateBy;
}

