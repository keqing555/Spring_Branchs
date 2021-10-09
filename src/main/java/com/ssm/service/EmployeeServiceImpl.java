package com.ssm.service;

import com.ssm.bean.Employee;
import com.ssm.bean.EmployeeExample;
import com.ssm.bean.EmployeeRole;
import com.ssm.dao.EmployeeMapper;
import com.ssm.dao.EmployeeRoleMapper;
import com.ssm.util.BaseResult;
import com.ssm.util.EmployeeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;

    //登录校验
    @Override
    public EmployeeResult loginCheck(String jobnumber, String password) {
        EmployeeResult result = new EmployeeResult();
        try {
            //检验账号密码唯一
            EmployeeExample example = new EmployeeExample();
            EmployeeExample.Criteria criteria = example.createCriteria();
            criteria.andJobnumberEqualTo(jobnumber);
            criteria.andPasswordEqualTo(password);
            List<Employee> employees = employeeMapper.selectByExample(example);
            if (employees != null && employees.size() > 0) {
                result.setLoginSuccess(true);
                result.setMessage("登录成功");
                //设置登录用户
                result.setEmployee(employees.get(0));
            } else {
                result.setLoginSuccess(false);
                result.setMessage("登录失败");
            }
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("登录出错了！");
        }
        return result;
    }

    /**
     * 获取当前登录用户
     */

    //新增员工
    @Override
    @Transactional
    public BaseResult addEmployee(Employee employee) {
        BaseResult baseResult = new BaseResult();
        System.out.println("要新增的员工：" + employee);
        try {
            //检验工号唯一
            EmployeeExample example = new EmployeeExample();
            EmployeeExample.Criteria criteria = example.createCriteria();
            criteria.andJobnumberEqualTo(employee.getJobnumber());
            List<Employee> employees = employeeMapper.selectByExample(example);
            if (employees != null && employees.size() > 0) {
                baseResult.setSuccess(false);
                baseResult.setMessage("工号重复！");
                return baseResult;
            }
            //开始新增员工
            employeeMapper.insert(employee);
            //为员工设置角色
            for (String rid : employee.getRids()) {
                EmployeeRole role = new EmployeeRole();
                role.setEid(employee.getEid());
                role.setRid(Long.parseLong(rid));//转为long类型
                employeeRoleMapper.insert(role);
            }
            baseResult.setSuccess(true);
            baseResult.setMessage("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setSuccess(false);
            baseResult.setMessage("新增失败！");
            //手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return baseResult;
    }
}
