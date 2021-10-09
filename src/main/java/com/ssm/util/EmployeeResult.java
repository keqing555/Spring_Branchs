package com.ssm.util;

import com.ssm.bean.Employee;

public class EmployeeResult extends BaseResult{
    //用户是否登录成功
    private boolean loginSuccess;
    private Employee employee;

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
