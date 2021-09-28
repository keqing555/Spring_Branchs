package com.aop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyJdbcFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/genshin?characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    //private Connection connection;

    //把连接绑定到线程里
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        //加载驱动
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        //保证每个线程使用的都是同一个连接
        if (connection != null) {
            return connection;
        }
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
