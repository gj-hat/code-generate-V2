package com.jiaguo.codegenerategraduation.common.exception;

import com.jiaguo.codegenerategraduation.advice.RequestHandlerCode;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/3/10 10:44
 * @description：未知其他异常
 * @modified By：
 * @version: 1.0
 */
public class UnknownException extends RuntimeException{


    private String msg = RequestHandlerCode.ACCOUNT.getReasonPhrase();

    private int code = RequestHandlerCode.ACCOUNT.getCode();

    public UnknownException(){}


    public UnknownException(int code) {
        this.code = code;
    }

    public UnknownException(String message, int code) {
        super(message);
        this.code = code;
    }

    public UnknownException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public UnknownException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public UnknownException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }



}
