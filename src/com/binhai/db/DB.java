package com.binhai.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3309/jsp";
    private static String username = "root";
    private static String password = "root";

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnetion() {
        Connection connection = null;
        //加载驱动
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }
}
