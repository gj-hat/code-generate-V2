package com.jiaguo.codegenerategraduation.advice;

public enum RequestHandlerCode {

    /**
     * ************************************************************************************************************
     * <p>
     * , 账户
     * <p>
     * *************************************************************************************************************
     */
    ACCOUNT(1000, Series.ACCOUNT, ""),

    ACCOUNT_VERIFICATION_CODE_GENERATE_FAILED(1001, Series.ACCOUNT, "验证码生成失败"),

    ACCOUNT_VERIFICATION_CODE_CHECK_FAILED(1001, Series.ACCOUNT, "验证码校验失败"),

    ACCOUNT_NOT_FOUND(1003, Series.ACCOUNT, "账户未找到"),

    ACCOUNT_EXPIRED(1004, Series.ACCOUNT, "账户已经过期"),

    ACCOUNT_DISABLE(1005, Series.ACCOUNT, "账户已经禁用"),

    ACCOUNT_LOCKED(1006, Series.ACCOUNT, "该账户已被禁用/锁定，如有需处理，请联系管理员"),

    ACCOUNT_AUTHENTICATION_FAILURE(1007, Series.ACCOUNT, "账户认证失败"),

    ACCOUNT_BAD_CREDENTIALS_FAILED(1008, Series.ACCOUNT, "账号或密码错误，您还有 %s 次机会，请慎重登录"),

    ACCOUNT_TOKEN_EXPIRE(1105, Series.ACCOUNT, "token过期或者失败"),

    ACCOUNT_TENANT_DISABLED(1106, Series.ACCOUNT, "该用户已被禁用，如需处理，请联系管理员"),

    /**
     * ************************************************************************************************************
     * <p>
     * 参数校验
     * <p>
     * *************************************************************************************************************
     */

    PARAMETER(2000, Series.PARAMS, "参数校验"),

    PARAMETER_LACK(2001, Series.PARAMS, "请求参数缺少"),

    PARAMETER_TYPE_ERROR(2002, Series.PARAMS, "参数类型不匹配"),

    PARAMETER_API_INTERFACE_CHECK_ERROR(2000, Series.PARAMS, "API接口参数校验失败"),

    /**
     * ************************************************************************************************************
     * <p>
     * 业务处理
     * <p>
     * *************************************************************************************************************
     */

    SERVICE(3000, Series.SERVICE, "业务处理"),

    SERVICE_EXECUTION_FAILED(3001, Series.SERVICE, "执行业务操作错误"),

    /**
     * ************************************************************************************************************
     * <p>
     * 数据库
     * <p>
     * *************************************************************************************************************
     */

    DATABASE(4000, Series.DATABASE, "数据库错误"),

    DATABASE_SQL_PARAMETER_LACK(4001, Series.DATABASE, "SQL参数缺少"),

    DATABASE_SQL_ILLEGAL(4002, Series.DATABASE, "SQL语法错误"),

    DATABASE_SQL_CONNECT_ERROR(4102, Series.DATABASE, "无法获取数据库连接,数据库连接已断开"),

    /**
     * ************************************************************************************************************
     * <p>
     * 文件
     * <p>
     * *************************************************************************************************************
     */

    FILE(5000, Series.FILE, "文件操作"),

    FILE_SIZE_ILLEGAL(5001, Series.FILE, "上传文件超过系统限制,不合法的文件大小"),

    FILE_MEDIA_TYPE_ILLEGAL(5002, Series.FILE, "不合法的媒体文件类型"),

    FILE_TYPE_ILLEGAL(5003, Series.FILE, "不合法的文件类型"),

    FILE_IMG_SIZE(5004, Series.FILE, "不合法的图片文件大小"),

    FILE_NOT_FOUNT(5004, Series.FILE, "访问不存在的文件"),


    /**
     * ************************************************************************************************************
     * <p>
     * 其他情况
     * <p>
     * *************************************************************************************************************
     */

    DISK_FULL(9101, Series.UNKNOWN, "无可用磁盘空间"),

    UNKNOWN(9999, Series.UNKNOWN, "System internal exception."),


    /**
     * 成功
     */
    SUCCESS(200, Series.SUCCESS, "success.");


    /**
     * 状态码值
     */
    private final int code;

    /**
     * 系列
     */
    private final Series series;

    /**
     * 原因描述
     */
    private final String reasonPhrase;

    /**
     * @param code          错误状态码
     * @param informational 错误分类信息
     * @param reasonPhrase  错误原因说明
     */
    RequestHandlerCode(int code, Series informational, String reasonPhrase) {
        this.code = code;
        this.series = informational;
        this.reasonPhrase = reasonPhrase;
    }

    /**
     * 错误状态码
     *
     * @return
     */
    public int code() {
        return code;
    }

    public int getCode(){
        return code;
    }

    /**
     * @return
     */
    public int getSeriesVal() {
        return series.getValue();
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public enum Series {

        /**
         * 请求处理成功
         */
        SUCCESS(0),


        /**
         * 账户类
         */
        ACCOUNT(1),

        /**
         * 参数类
         */
        PARAMS(2),

        /**
         * 业务
         */
        SERVICE(3),

        /**
         * 数据库访问类
         */
        DATABASE(4),

        /**
         * File
         */
        FILE(5),

        /**
         * 其他未知分类
         */
        UNKNOWN(6),

        /**
         * 开放 API 错误
         */
        OPENAPI(7);

        private final int value;

        Series(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
