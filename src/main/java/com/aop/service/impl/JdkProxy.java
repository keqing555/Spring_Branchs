package com.aop.service.impl;

import com.aop.util.MyJdbcFactory;
import com.aop.util.MyTransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 在不改变源代码的情况下给任意功能加事务
 * 定义任意代理类
 * 实现JDK自带接口
 */
public class JdkProxy implements InvocationHandler {
    //任意目标对象
    private Object target;

    //添加构造方法
    public JdkProxy() {
    }

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //开启事务
        MyTransactionManager.beginTransaction(MyJdbcFactory.getConnection());
        Object returnObject = null;
        try {
            //调用任意对象的任意方法
            returnObject = method.invoke(target, args);
            //提交事务
            MyTransactionManager.commitTransaction(MyJdbcFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("回滚事务");
            MyTransactionManager.rollbackTransaction(MyJdbcFactory.getConnection());
        } finally {
            //关闭连接
            MyJdbcFactory.closeConnection(MyJdbcFactory.getConnection());
        }
        return returnObject;
    }
}
