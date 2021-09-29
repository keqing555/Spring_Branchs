package com.aop.dao.impl;

import com.aop.bean.Weapon;
import com.aop.dao.WeaponDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 使用Spring-Jdbc实现WeaponDao接口
 */
@Service
public class WeaponDaoImpl_Spring_Jdbc implements WeaponDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void update(int rid, int wid) {

    }

    @Override
    public Weapon getWeaponByWid(int wid) {
        return null;
    }

    @Override
    public Weapon getWeaponByRid(int rid) {
        return null;
    }

    @Override
    public int getMaxWid() {
        return 0;
    }

    @Override
    public boolean weaponExists(int wid) {
        return false;
    }
}
