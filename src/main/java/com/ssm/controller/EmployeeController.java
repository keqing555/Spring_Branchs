package com.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.ssm.bean.Employee;
import com.ssm.bean.Erole;
import com.ssm.service.EmployeeService;
import com.ssm.service.RoleService;
import com.ssm.util.BaseResult;
import com.ssm.util.EmployeeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;

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
     * 根据条件分页查询员工信息
     */
    @RequestMapping("findEmployeesByCondition")
    @ResponseBody
    public JSONObject findEmployeesByCondition(Employee employee) {
        JSONObject jsonObject = new JSONObject();
        List<Employee> employeeList = employeeService.findEmployeesByCondition(employee);
        int total = employeeService.countByCondition(employee);
        jsonObject.put("rows", employeeList);
        jsonObject.put("total", total);
        return jsonObject;
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
/**
 * 查看员工详情
 */


    /**
     * 获取要修改的员工，并存放到session域
     */
    @RequestMapping("toUpdateView")
    @ResponseBody
    public BaseResult toUpdateView(long eid, HttpSession session) {
        BaseResult baseResult = new BaseResult();
        try {
            Employee employee = employeeService.findEmployeeByEid(eid);
            session.setAttribute("updateEmployee", employee);
            baseResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setSuccess(false);
        }
        return baseResult;
    }

    /**
     * 获取要修改的员工信息
     */
    @RequestMapping("getUpdateEmployee")
    @ResponseBody
    public Employee getUpdateEmployee(HttpSession session) {
        Employee employee = null;
        try {
            employee = (Employee) session.getAttribute("updateEmployee");
            List<Erole> roleList = roleService.getRoleByEid(employee.getEid());
            employee.setEroleList(roleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    /**
     * 开始修改员工信息
     */
    @RequestMapping("updateEmployee")
    @ResponseBody
    public BaseResult updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    /**
     * 删除员工
     */
    @RequestMapping("deleteEmployee")
    @ResponseBody
    public BaseResult deleteEmployee(long eid) {
        return employeeService.deleteEmployee(eid);
    }

    /**
     * 批量删除
     */
    @RequestMapping("batchDelete")
    @ResponseBody
    public BaseResult batchDelete(String eids) {
        return employeeService.deleteAll(eids);
    }

}
