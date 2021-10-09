package com.ssm.service;

import com.ssm.bean.Employee;
import com.ssm.util.BaseResult;
import com.ssm.util.EmployeeResult;

public interface EmployeeService {
    /**
     * 登录校验
     */
     EmployeeResult loginCheck(String jobnumber,String password);
    /**
     * 新增员工
     */
    BaseResult addEmployee(Employee employee);
}
