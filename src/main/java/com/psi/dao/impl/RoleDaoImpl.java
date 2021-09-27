package com.psi.dao.impl;

import com.psi.bean.Role;
import com.psi.dao.RoleDao;

public class RoleDaoImpl implements RoleDao {
    public RoleDaoImpl() {
        System.out.println("创建RoleDao实例");
    }

    public void init(){
        System.out.println("初始化RoleDao的方法");
    }
    // 获取role
    @Override
    public Role getRoleByRid(int rid) {
        System.out.println("查找到了一个role");
        return null;
    }
}
