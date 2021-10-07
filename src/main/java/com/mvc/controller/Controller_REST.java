package com.mvc.controller;

import com.mvc.bean.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * REST风格编程
 */
@Controller
@RequestMapping("restful")
public class Controller_REST {
    //新增
    @RequestMapping(value = "role", method = RequestMethod.POST)
    public String addRole(Role role) {
        System.out.println("新增角色：" + role);
        return "success";
    }

    //修改
    @RequestMapping(value = "role", method = RequestMethod.PUT)
    public String updateRole(Role role) {
        System.out.println("新增角色：" + role);
        return "success";
    }

    //删除
    @RequestMapping(value = "role/{rid}", method = RequestMethod.DELETE)
    public String deleteRole(@PathVariable int rid) {
        System.out.println("删除角色rid：" + rid);
        return "success";
    }

    //查询
    @RequestMapping(value = "role/{rid}", method = RequestMethod.GET)
    public String selectRole(@PathVariable int rid) {
        System.out.println("查询用户rid:" + rid);
        return "success";
    }

}
