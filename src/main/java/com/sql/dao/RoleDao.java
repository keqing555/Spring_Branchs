package com.sql.dao;

import com.sql.bean.Role;

import java.util.List;

//定义dao层接口
public interface RoleDao {

    public void insertRole(Role role);

    public void deleteRole(int rid);

    public void updateRole(Role role);

    public Role selectRoleByRid(int rid);

    public List<Role> selectAllRole();
}
