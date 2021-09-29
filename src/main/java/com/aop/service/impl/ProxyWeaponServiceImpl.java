package com.aop.service.impl;

import com.aop.service.WeaponService;
import com.aop.util.MyJdbcFactory;
import com.aop.util.MyTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 在不改变源代码的情况下添加事务
 * 新增静态代理类，使用代理类执行目标方法，添加额外功能
 */
@Service
public class ProxyWeaponServiceImpl implements WeaponService {
    @Autowired
    @Qualifier("weaponServiceImpl_proxy")//搭配Autowired使用，通过指定实例的别名来注入实例
    private WeaponService weaponService;

    @Override
    public void changeWeapon(int rid, int wid) {
        //开启事务
        MyTransactionManager.beginTransaction(MyJdbcFactory.getConnection());
        try {
            //执行代理方法
            weaponService.changeWeapon(rid, wid);
            //提交事务
            MyTransactionManager.commitTransaction(MyJdbcFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            System.out.println("回滚事务");
            MyTransactionManager.rollbackTransaction(MyJdbcFactory.getConnection());

        } finally {
            //关闭连接
            MyJdbcFactory.closeConnection(MyJdbcFactory.getConnection());
        }
    }
}
