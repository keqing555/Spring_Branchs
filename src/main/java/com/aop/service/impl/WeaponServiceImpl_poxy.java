package com.aop.service.impl;

import com.aop.bean.Weapon;
import com.aop.dao.WeaponDao;
import com.aop.service.WeaponService;
import com.aop.util.MyJdbcFactory;
import com.aop.util.MyTransactionManager;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 在不改变源代码的情况下新增事务
 */
@Service    //创建该类实例，放到容器里
public class WeaponServiceImpl_poxy implements WeaponService {
    @Autowired  //给成员变量赋初始值（从容器中拿）
    private WeaponDao weaponDao;

    @Override
    public void changeWeapon(int rid, int wid) {
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
                    //int error=1/0;
                    weaponDao.update(target_rid, current_wid);
                    System.out.println("切换武器成功");
                } else {
                    System.out.println("正在使用当前武器");
                }
            } else {
                System.out.println("该武器不存在");
            }
    }
}
