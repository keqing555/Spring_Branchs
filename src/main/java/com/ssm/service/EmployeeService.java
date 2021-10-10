package com.ssm.service;

import com.ssm.bean.Employee;
import com.ssm.util.BaseResult;
import com.ssm.util.EmployeeResult;

import java.util.List;

public interface EmployeeService {
    /**
     * 登录校验
     */
    EmployeeResult loginCheck(String jobnumber, String password);

    /**
     * 根据条件分页查询员工信息
     */
    List<Employee> findEmployeesByCondition(Employee employee);

    /**
     * 根据分页条件查询总条数
     */
    int countByCondition(Employee employee);

    /**
     * 新增员工
     */
    BaseResult addEmployee(Employee employee);

    /**
     * 获取要修改的员工信息
     */
    //BaseResult toUpdateView(Employee employee);

    /**
     * 修改员工信息
     */
    BaseResult updateEmployee(Employee employee);

    /**
     * 删除员工
     */
    BaseResult deleteEmployee(long eid);

    /**
     * 批量删除
     */
    BaseResult deleteAll(String eids);

    /**
     * 根据eid查找员工
     */
    Employee findEmployeeByEid(long eid);
}
