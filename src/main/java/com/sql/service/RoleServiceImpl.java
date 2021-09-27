package com.sql.service;

import com.sql.bean.Role;
import com.sql.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    //service层，创建该类的实例，并放入到容器里
public class RoleServiceImpl implements RoleService{
    @Autowired  //给成员变量设置初始值（根据类型从容器中取出实例注入到属性值中）
    private RoleDao roleDao;
    @Override
    public Role selectRoleByRid(int rid) {
        Role role = roleDao.selectRoleByRid(1);
        return role;
    }
}
