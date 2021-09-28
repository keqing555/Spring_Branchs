package com.aop.service.impl;

import com.aop.bean.Weapon;
import com.aop.dao.WeaponDao;
import com.aop.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 在业务中添加事务
 */
@Service
public class WeaponServiceImpl implements WeaponService {
    @Autowired
    private WeaponDao weaponDao;

    /**
     * 实现切换业务
     */
    @Override
    public void changeWeapon(int rid, int wid) {
        Weapon weapon = weaponDao.getWeaponByWid(wid);
        if (weapon != null) {
            if (rid != weapon.getRid()) {
                try {
                    int new_wid = weaponDao.getWeaponByRid(rid).getWid();
                    int new_rid = weapon.getRid();
                    weaponDao.update(rid, wid);
                    if (new_wid != 0) {
                        weaponDao.update(new_rid, new_wid);
                    }
                    System.out.println("切换武器成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("切换失败");
                }
            } else {
                System.out.println("正在使用当前武器");
            }
        }else{
            System.out.println("该武器不存在");
        }
    }
}
