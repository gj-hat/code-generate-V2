package com.jiaguo.codegenerategraduation.common.exception;

import com.jiaguo.codegenerategraduation.advice.RequestHandlerCode;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/3/10 10:43
 * @description：数据库异常
 * @modified By：
 * @version: 1.0
 */
public class DatabaseException extends RuntimeException{

    private String msg = RequestHandlerCode.DATABASES.getReasonPhrase();

    private int code = RequestHandlerCode.DATABASES.getCode();

    public DatabaseException(){}

    public DatabaseException(String message) {
        this.msg = message;
    }

    public DatabaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public DatabaseException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public DatabaseException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
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
