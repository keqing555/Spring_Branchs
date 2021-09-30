package com.aop.service.impl;

import com.aop.util.MyJdbcFactory;
import com.aop.util.MyTransactionManager;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理，给任意类加任意额外功能
 */
public class CglibProxy implements MethodInterceptor {
    //任意目标对象
    private Object target;

    //构造方法
    public CglibProxy(Object target) {
        this.target = target;
    }

    public CglibProxy() {
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //开启事务
        MyTransactionManager.beginTransaction(MyJdbcFactory.getConnection());
        Object result = null;
        try {
            //调用任意方法
            result = method.invoke(target, objects);
            //提交事务
            MyTransactionManager.commitTransaction(MyJdbcFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            MyTransactionManager.rollbackTransaction(MyJdbcFactory.getConnection());
        } finally {
            //关闭连接
            MyJdbcFactory.closeConnection(MyJdbcFactory.getConnection());
        }
        return result;
    }
}
