//package com.aop.service.impl;
//
//import com.aop.bean.Weapon;
//import com.aop.dao.WeaponDao;
//import com.aop.service.WeaponService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * 添加Spring事务
// */
//@Service    //创建该类实例，放到容器里
//public class WeaponServiceImpl_spring_transaction implements WeaponService {
//    @Autowired  //给成员变量赋初始值（从容器中拿）
//    @Qualifier("weaponDaoImpl_Spring_Jdbc")
//    private WeaponDao weaponDao;
//
//    @Override
//    //在代理方法上添加事务
//    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
//    public void changeWeapon(int rid, int wid) {
//        Weapon weapon = weaponDao.getWeaponByWid(wid);
//        //目标武器是否存在，存在
//        if (weapon.getWname() != null) {
//            //是否在使用当前武器，否
//            if (rid != weapon.getRid()) {
//                //目标武器使用者rid
//                int target_rid = weapon.getRid();
//                //获取角色当前武器wid
//                int current_wid = weaponDao.getWeaponByRid(rid).getWid();
//                //更换武器
//                weaponDao.update(rid, wid);
//                //修改一半，模拟故障
//                int error = 1 / 0;
//                weaponDao.update(target_rid, current_wid);
//                System.out.println("切换武器成功");
//            } else {
//                System.out.println("正在使用当前武器");
//            }
//        } else {
//            System.out.println("该武器不存在");
//        }
//    }
//}