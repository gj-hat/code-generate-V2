package com.jiaguo.codegenerategraduation.web.controller.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 系统参数(SysParams)表实体类
 *
 * @author JiGuo
 * @since 2022-07-07 17:31:12
 */
@ApiModel(value = "SysParams", description = "系统参数(SysParams)表实体类")
@Data
@Accessors(chain = true)
public class SysParamsVo {
    @ApiModelProperty(value = "主键")
    private Integer id;
    @ApiModelProperty(value = "key")
    private String key;
    @ApiModelProperty(value = "value")
    private String value;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "更新人")
    private String updateBy;
}

