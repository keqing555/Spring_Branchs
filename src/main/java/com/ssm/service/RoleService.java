package com.ssm.service;

import com.ssm.bean.Erole;

import java.util.List;

public interface RoleService {
    //查询所有角色
     List<Erole> getAllRoles();
     //获取当前员工角色
    List<Erole> getRoleByEid(long eid);
}
