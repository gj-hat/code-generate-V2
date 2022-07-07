package com.jiaguo.codegenerategraduation;

import java.io.File;

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
    public final static String JWT_SUBJECT = "JiaGuo";
    public final static String JWT_AUDIENCE = "JiaGuo";


    public final static Long JWT_TTL = 60 * 60 *24*1000L;

    public final static String JWT_KEY_ACCOUNT = "account";
    public final static String JWT_KEY_NICKNAME = "nickname";
    public final static String JWT_KEY_USERID = "id";
    public final static String JWT_KEY_TYPE = "type";


    public final static String REQUEST_HEAD = "Authorization";


    // TODO JiaGuo 2022/7/4: 之后写在数据库中  作为全局参数
    public final static String DRIVER_PATH_PREFIX = File.separator+"Volumes"+File.separator+"SoftWare"+File.separator+"JetBrains"+File.separator+"IDEA"+File.separator+"code-generate-graduation"+File.separator+"code-generate-graduation"+File.separator+"localFile"+File.separator+"DbDriverDriver"+File.separator;




}
