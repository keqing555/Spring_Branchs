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
            System.out.println("######开启事务######");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public static void commitTransaction(Connection connection) {
        try {
            connection.commit();
            System.out.println("######提交事务######");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚事务
    public static void rollbackTransaction(Connection connection) {
        try {
            connection.rollback();
            System.out.println("######回滚事务######");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
