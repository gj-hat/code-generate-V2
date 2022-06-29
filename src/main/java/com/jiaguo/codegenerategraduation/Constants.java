package com.jiaguo.codegenerategraduation;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/28 09:08
 * @description：常量
 * @modified By：
 * @version: 1.0
 */
public class Constants {


    public final static String PACKAGE_NAME = "com.jiaguo.codegenerategraduation";

    // jwt相关常量
    public final static String JWT_KEY = "this token from JiaGuo";
    public final static String JWT_ISSUER = "JiaGuo";
    public final static Long JWT_TTL = 60 * 60 *24*1000L;

    public final static String JWT_KEY_ACCOUNT = "account";
    public final static String JWT_KEY_NICKNAME = "nickname";
    public final static String JWT_KEY_USERID = "id";
    public final static String JWT_KEY_TYPE = "type";


    public final static String REQUEST_HEAD = "token";


}
