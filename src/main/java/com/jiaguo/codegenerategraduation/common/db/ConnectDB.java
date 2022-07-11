package com.jiaguo.codegenerategraduation.common.db;

import com.jiaguo.codegenerategraduation.Constants;
import com.jiaguo.codegenerategraduation.config.InitParameter;
import com.jiaguo.codegenerategraduation.web.controller.vo.DatabaseResourcesVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/7/6 20:40
 * @description：连接数据库
 * @modified By：
 * @version: 1.0
 */
public class ConnectDB {


    private static final Logger logger = LoggerFactory.getLogger(ConnectDB.class);


    public static   Boolean testConnectDB(DatabaseResourcesVo databaseResourcesVo) {
        // 加载驱动
        String driverUrl = InitParameter.paramsMap.get(Constants.TIMED_REFRESH)+ databaseResourcesVo.getDriverUrl();
        // 数据库jdbc地址
        String url = "jdbc:"
                + databaseResourcesVo.getDatabaseType()
                + "://"
                + databaseResourcesVo.getHost()
                + ":"
                + databaseResourcesVo.getPort()
                + "/"
                + databaseResourcesVo.getDatabaseName();
        // TODO JiaGuo 2022/7/11: 这里需要完善  考虑写入数据库还是枚举类
        String mysqlClassName = "com.mysql.cj.jdbc.Driver";
        String mysqlClassNameOld = "com.mysql.jdbc.Driver";

        try {
            File file = new File(driverUrl);
            ClassLoader loader = new URLClassLoader(new URL[]{file.toURI().toURL()});
            loader.loadClass(mysqlClassName);
            Connection conn = DriverManager.getConnection(url, databaseResourcesVo.getUsername(), databaseResourcesVo.getPassword());
            System.out.println("连接成功！");
            System.out.println(conn);
        } catch (Exception e) {
            logger.error("连接数据库失败！", e);
            return false;
        }
        return true;
    }

}
