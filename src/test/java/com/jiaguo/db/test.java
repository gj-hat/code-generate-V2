package com.jiaguo.db;

import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.*;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/7/6 20:14
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class test {


    @Test
    public void jdbcall() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动类


        String url = "jdbc:mysql://localhost:3306/test_spring_security";
        String username = "root";
        String password = "321321321";
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        String username = "postgres";
//        String password = "321321";


        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "SELECT * FROM template_library ";

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("template_name"));
        }
        rs.close();
        System.out.println("连接成功！");
        System.out.println(conn);
    }


    @Test
    public void jdbcal2() throws ClassNotFoundException, SQLException, MalformedURLException, InstantiationException, IllegalAccessException {


        File file = new File("/Volumes/SoftWare/JetBrains/IDEA/code-generate-graduation/code-generate-graduation/localFile/dbSourceDriver/mysql-connector-java-8.0.29.jar");//

        URL url = file.toURI().toURL();//jar包的路径

        ClassLoader loader = new URLClassLoader(new URL[]{url});

        loader.loadClass("com.mysql.cj.jdbc.Driver");

        String url1 = "jdbc:mysql://localhost:3306/test_spring_security";
        String username = "root";
        String password = "321321321";
        Connection conn = DriverManager.getConnection(url1, username, password);//用参数得到连接对象
        System.out.println("连接成功！");
        System.out.println(conn);

    }


}
