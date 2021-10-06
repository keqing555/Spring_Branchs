package com.mvc.controller;

import com.mvc.bean.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 处理请求的控制层代码
 */
@Controller
@RequestMapping("example")
public class ControllerExample {
    @RequestMapping("test_1")
    public String test_1() {
        System.out.println("test_1:处理请求成功！");
        return "success";
    }

    /**
     * SpringMVC参数绑定
     */
    //基本数据类型和String
    @RequestMapping("test_2")
    public String role(String rolename, int grade, int star) {
        //传入参数必须和方法接收参数名称一致
        System.out.println("一键突破：角色[" + rolename + "]-等级[" + grade + "]-星级[" + star + "]");
        return "success";
    }

    //对象类型参数绑定
    @RequestMapping("role")
    public String role1(Role role) {
        //传入参数名称必须和对象属性名称一致
        System.out.println(role);
        return "success";
    }

    //复杂参数类型绑定
    @RequestMapping("weapon")
    public String weapon(Role role) {
        System.out.println(role);
        return "success";
    }

    //默认类型参数绑定：servletAPI,model,ModelAndView,ModelMap,Map
    //可将任意对象绑定到请求域
    @RequestMapping("defaultParam_1")
    public void defaultParam_1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用request转发，所以返回值类型为void
        //请求转发
        req.getRequestDispatcher("forward").forward(req, resp);
    }

    @RequestMapping("defaultParam_2")
    public void defaultParam_2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用request转发，所以返回值类型为void
        //重定向
        resp.sendRedirect("forward");
    }

    @RequestMapping("forward")
    public String forward() {
        System.out.println("我是请求转发和重定向");
        return "success";
    }

    //自定义类型参数绑定:日期转换
    @RequestMapping("define")
    public String define(Date date) {
        System.out.println(date);
        return "success";
    }
}
