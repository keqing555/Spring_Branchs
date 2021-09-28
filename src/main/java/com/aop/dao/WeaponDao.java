package com.aop.dao;

import com.aop.bean.Weapon;

public interface WeaponDao {
    public void update(int rid, int wid);

    public Weapon getWeaponByWid(int wid);

    public Weapon getWeaponByRid(int rid);

    public int getMaxWid();

    public boolean weaponExists(int wid);

}
