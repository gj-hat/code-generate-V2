package com.jiaguo.codegenerategraduation.common.http;


import lombok.Data;

@Data
public class ReqParams<T> {

    /**
     * 分页参数
     */
    private int pageNum = 1;
    private int pageSize = 10;

    private T data;


}