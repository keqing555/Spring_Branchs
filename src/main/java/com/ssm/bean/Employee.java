package com.ssm.bean;

import java.util.Date;

public class Employee {
    private Long eid;

    private String ename;

    private Long esex;

    private Long eage;

    private String etelephone;

    private Date hiredate;

    private String jobnumber;

    private String password;

    private String remark;

    private String remark1;

    private String remark2;

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public Long getEsex() {
        return esex;
    }

    public void setEsex(Long esex) {
        this.esex = esex;
    }

    public Long getEage() {
        return eage;
    }

    public void setEage(Long eage) {
        this.eage = eage;
    }

    public String getEtelephone() {
        return etelephone;
    }

    public void setEtelephone(String etelephone) {
        this.etelephone = etelephone == null ? null : etelephone.trim();
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber == null ? null : jobnumber.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }
}