package com.psi.util;

import com.psi.dao.RoleDao;
import com.psi.dao.impl.RoleDaoImpl;
import com.psi.dao.impl.RoleDaoImpl2;

public class RoleDaoFactory {
    public RoleDao getRoleDao1() {
        return new RoleDaoImpl();
    }

    //静态方法
    public static RoleDao getRoleDao2() {
        return new RoleDaoImpl2();
    }
}
