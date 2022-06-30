package com.jiaguo.codegenerategraduation.common.http;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "分页: 请求参数", description = "请求参数")
public class ReqParams<T> {

    /**
     * 分页参数
     */
    @ApiModelProperty(value = "分页参数", name = "page", example = "1")
    private int pageNum = 1;
    @ApiModelProperty(value = "分页参数", name = "size", example = "10")
    private int pageSize = 10;

    /**
     * 查询参数
     */
    @ApiModelProperty(value = "实体: 查询参数", name = "query", example = "")
    private T data;


}