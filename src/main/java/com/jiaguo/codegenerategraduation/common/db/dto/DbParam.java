package com.jiaguo.codegenerategraduation.common.db.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/7/6 20:48
 * @description：jdbc连接参数
 * @modified By：
 * @version: 1.0
 */
@Data
@Accessors(chain = true)
@Deprecated
public class DbParam {

    String driverUrl;
    String username;
    String password;
    String host;
    String databaseName;
    int port;
    String dbType;

}
