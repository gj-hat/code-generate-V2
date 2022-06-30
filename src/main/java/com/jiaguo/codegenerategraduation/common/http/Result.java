package com.jiaguo.codegenerategraduation.common.http;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/27 18:46
 * @description：统一返回相应
 * @modified By：
 * @version: 1.0
 */
@ApiModel(value = "统一返回相应", description = "统一返回相应")
public class Result<T> {

    /**
     * 返回成功
     */
    public static final int DEFAULT_SUCCESS_CODE = 200;
    public static final String DEFAULT_SUCCESS_MSG = "success";

    /**
     * 返回失败
     */
    public static final int DEFAULT_FAIL_CODE = -1;
    public static final String DEFAULT_FAIL_MSG = "fail";


    @ApiModelProperty(value = "返回码", name = "code", example = "200")
    private int code;
    @ApiModelProperty(value = "返回消息", name = "msg", example = "success")
    private String msg;
    @ApiModelProperty(value = "返回数据", name = "data", example = "")
    private T data;

    public Result() {
    }


    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return success(DEFAULT_SUCCESS_MSG, data);
    }

    public static <T> Result<Map<String, Object>> successWithData(String key, T value) {
        HashMap<String, Object> data = new HashMap<>(4);
        data.put(key, value);
        return success(DEFAULT_SUCCESS_MSG, data);
    }

    public static <T> Result<T> success(String message, T data) {
//        if (data instanceof Page) {
//            Page p = (Page) data;
//            PageResult pageResult = new PageResult(p.getTotal(), p.getRecords());
//            return new Result(DEFAULT_SUCCESS_CODE, message, pageResult);
//        }
        return new Result(DEFAULT_SUCCESS_CODE, message, data);
    }

    public static <T> Result<T> success(String msg) {
        return new Result<T>(DEFAULT_SUCCESS_CODE, msg, null);
    }

    public static <T> Result<T> success() {
        return new Result<T>(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG, null);
    }

    public static <T> Result<T> fail() {
        return new Result<T>(DEFAULT_FAIL_CODE, DEFAULT_FAIL_MSG, null);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result<T>(code, msg, null);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<T>(DEFAULT_FAIL_CODE, msg, null);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<T>(DEFAULT_FAIL_CODE, DEFAULT_FAIL_MSG, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }




}
