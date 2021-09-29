package com.aop.service.impl;

import com.aop.bean.Weapon;
import com.aop.dao.WeaponDao;
import com.aop.service.WeaponService;
import com.aop.util.MyJdbcFactory;
import com.aop.util.MyTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 在业务中添加事务
 */
@Service    //创建该类实例，放到容器里
public class WeaponServiceImpl implements WeaponService {
    @Autowired  //给成员变量赋初始值（从容器中拿）
    @Qualifier("weaponDaoImpl")
    private WeaponDao weaponDao;

    /**
     * 实现切换业务
     */
    @Override
    public void changeWeapon(int rid, int wid) {
        //开启事务
        MyTransactionManager.beginTransaction(MyJdbcFactory.getConnection());
        try {
            Weapon weapon = weaponDao.getWeaponByWid(wid);
            //目标武器是否存在，存在
            if (weapon.getWname() != null) {
                //是否在使用当前武器，否
                if (rid != weapon.getRid()) {
                    //目标武器使用者rid
                    int target_rid = weapon.getRid();
                    //获取角色当前武器wid
                    int current_wid = weaponDao.getWeaponByRid(rid).getWid();
                    //更换武器
                    weaponDao.update(rid, wid);
                    //修改一半，模拟故障
                    int error=1/0;
                    weaponDao.update(target_rid, current_wid);
                    System.out.println("切换武器成功");
                } else {
                    System.out.println("正在使用当前武器");
                }
            } else {
                System.out.println("该武器不存在");
            }
            //提交事务
            MyTransactionManager.commitTransaction(MyJdbcFactory.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            System.out.println("ERROR！回滚事务！！！");
            MyTransactionManager.rollbackTransaction(MyJdbcFactory.getConnection());
        } finally {
            //关闭连接
            MyJdbcFactory.closeConnection(MyJdbcFactory.getConnection());
        }
    }
}
