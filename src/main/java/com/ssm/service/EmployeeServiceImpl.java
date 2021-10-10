package com.ssm.service;

import com.ssm.bean.Employee;
import com.ssm.bean.EmployeeExample;
import com.ssm.bean.EmployeeRole;
import com.ssm.bean.EmployeeRoleExample;
import com.ssm.dao.EmployeeMapper;
import com.ssm.dao.EmployeeRoleMapper;
import com.ssm.util.BaseResult;
import com.ssm.util.EmployeeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.ResponseBody;

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
            Employee employee = employeeMapper.selectByPrimaryKey(74l);

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

    @Override
    public List<Employee> findEmployeesByCondition(Employee employee) {
        employee.setLimitStart((employee.getPage() - 1) * employee.getRows());
        List<Employee> employeeList = employeeMapper.findEmployeesByCondition(employee);
        for (Employee emp_sex : employeeList) {
            if (emp_sex.getEsex() == 1) {
                emp_sex.setEsexStr("女");
            } else {
                emp_sex.setEsexStr("男");
            }
        }
        return employeeList;
    }

    @Override
    public int countByCondition(Employee employee) {
        return employeeMapper.countByCondition(employee);

    }

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
            System.out.println("回滚事务。。。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return baseResult;
    }

    //修改员工信息
    @Override
    @Transactional
    public BaseResult updateEmployee(Employee employee) {
        BaseResult baseResult = new BaseResult();
        try {
            //校验员工工号唯一
            EmployeeExample example = new EmployeeExample();
            EmployeeExample.Criteria criteria = example.createCriteria();
            criteria.andEidNotEqualTo(employee.getEid());
            criteria.andJobnumberEqualTo(employee.getJobnumber());
            List<Employee> employees = employeeMapper.selectByExample(example);
            if (employees != null && employees.size() > 0) {
                baseResult.setSuccess(false);
                baseResult.setMessage("工号重复！");
                return baseResult;
            }
            //修改员工信息
            employeeMapper.updateByPrimaryKey(employee);
            //修改员工角色信息(-先删除，再添加-)
            //删除role
            EmployeeRoleExample employeeRoleExample = new EmployeeRoleExample();
            EmployeeRoleExample.Criteria criteria1 = employeeRoleExample.createCriteria();
            criteria1.andEidEqualTo(employee.getEid());
            employeeRoleMapper.deleteByExample(employeeRoleExample);
            //添加role
            for (String rid : employee.getRids()) {
                EmployeeRole employeeRole = new EmployeeRole();
                employeeRole.setEid(employee.getEid());
                employeeRole.setRid(Long.parseLong(rid));
                employeeRoleMapper.insert(employeeRole);
            }
            baseResult.setSuccess(true);
            baseResult.setMessage("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setSuccess(false);
            baseResult.setMessage("修改失败。。。");
            System.out.println("修改失败，回滚！");
            //回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return baseResult;
    }

    @Override
    @Transactional
    public BaseResult deleteEmployee(long eid) {
        BaseResult baseResult = new BaseResult();
        try {
            //删除员工角色
            EmployeeRoleExample example = new EmployeeRoleExample();
            EmployeeRoleExample.Criteria criteria = example.createCriteria();
            criteria.andEidEqualTo(eid);
            employeeRoleMapper.deleteByExample(example);
            //删除员工表
            employeeMapper.deleteByPrimaryKey(eid);
            baseResult.setSuccess(true);
            baseResult.setMessage("删除成功！");
            if (eid == 75) {
                int error = 1 / 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setSuccess(false);
            baseResult.setMessage("删除失败！");
            System.out.println("删除失败，混滚事务。。。");
            //回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return baseResult;
    }

    @Override
    //@Transactional
    public BaseResult deleteAll(String eids) {
        BaseResult baseResult = new BaseResult();
        try {
            String[] split = eids.split(",");
            for (String id : split) {
                long eid = Long.parseLong(id);
                deleteEmployee(eid);
            }
            baseResult.setSuccess(true);
            baseResult.setMessage("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setSuccess(false);
            baseResult.setMessage("删除失败！回滚。。。");
            // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return baseResult;
    }

    @Override
    public Employee findEmployeeByEid(long eid) {
        return employeeMapper.selectByPrimaryKey(eid);

    }
}
