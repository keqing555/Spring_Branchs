package com.ssm.service;

import com.ssm.bean.Employee;
import com.ssm.bean.Erole;

import java.util.List;

public interface RoleService {
    //查询所有角色
    List<Erole> getAllRoles();

    //获取当前员工角色
    List<Erole> getRoleByEid(long eid);

    //根据分页条件获取角色
    List<Erole> findRolesByCondition(Erole role);
}
