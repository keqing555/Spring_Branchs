package com.ssm.controller;

import com.ssm.bean.Employee;
import com.ssm.bean.Erole;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 获取所有角色
     */
    @RequestMapping("getAllRoles")
    @ResponseBody
    public List<Erole> getAllRoles() {
        return roleService.getAllRoles();
    }

    /**
     * 根据分页条件获取角色
     */
    @RequestMapping("findRolesByCondition")
    @ResponseBody
    public List<Erole> findRolesByCondition(Erole role) {
        return roleService.findRolesByCondition(role);
    }
}
