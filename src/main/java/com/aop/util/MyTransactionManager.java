package com.aop.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 定义事务管理类工具
 */
public class MyTransactionManager {
    //开启事务
    public static void beginTransaction(Connection connection) {
        try {
            //关闭自动提交
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public static void commitTransaction(Connection connection) {
        try {
            //报错：Can't call commit when autocommit=true
            //这里先把自动提交再次关闭，再手动提交
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚事务
    public static void rollbackTransaction(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
