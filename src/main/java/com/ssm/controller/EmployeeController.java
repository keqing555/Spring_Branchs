package com.ssm.controller;

import com.ssm.bean.Employee;
import com.ssm.service.EmployeeService;
import com.ssm.util.BaseResult;
import com.ssm.util.EmployeeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 登录校验
     */
    @RequestMapping("loginCheck")
    @ResponseBody
    public EmployeeResult loginCheck(String jobnumber, String password, HttpSession session) {
        EmployeeResult result = employeeService.loginCheck(jobnumber, password);
        if (result.isLoginSuccess()) {
            //登录成功，储存用户
            session.setAttribute("employee", result.getEmployee());
        }
        return result;
    }

    /**
     * 获取当前登录用户
     */
    @RequestMapping("getCurrentEmployee")
    @ResponseBody
    public Employee getCurrentEmployee(HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        return employee;
    }

    /**
     * 退出登录
     */
    @RequestMapping("loginOut")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "/index.html";
    }


    /**
     * 新增员工
     */
    @RequestMapping("addEmployee")
    @ResponseBody
    public BaseResult addEmployee(Employee employee) {
        BaseResult baseResult = employeeService.addEmployee(employee);
        return baseResult;
    }
}
