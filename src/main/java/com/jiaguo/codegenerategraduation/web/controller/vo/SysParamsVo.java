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
@ApiModel(value = "请求实体: 系统参数", description = "系统参数(SysParams)表实体类")
@Data
@Accessors(chain = true)
public class SysParamsVo {
    @ApiModelProperty(value = "主键", name = "id", example = "1", required = true)
    private Integer id;
    @ApiModelProperty(value = "key", name = "key", example = "key", required = true)
    private String key;
    @ApiModelProperty(value = "value", name = "value", example = "value", required = true)
    private String value;
    @ApiModelProperty(value = "备注", name = "remark", example = "备注", required = true)
    private String remark;
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-07-07 17:31:12")
    private Date createTime;
    @ApiModelProperty(value = "创建人", name = "createBy", example = "JiGuo")
    private String createBy;
    @ApiModelProperty(value = "更新时间", name = "updateTime", example = "2020-07-07 17:31:12")
    private Date updateTime;
    @ApiModelProperty(value = "更新人", name = "updateBy", example = "JiGuo")
    private String updateBy;
}

