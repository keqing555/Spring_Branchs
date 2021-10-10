package com.ssm.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssm.util.PageUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Employee extends PageUtil {
    private Long eid;

    private String ename;

    private Long esex;
    private String esexStr;//新增性别对应字段

    private Long eage;

    private String etelephone;
    //接收时间格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //响应时间格式
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date hiredate;

    private String jobnumber;

    private String password;

    private String remark;

    private String remark1;

    private String remark2;
    private String[] rids;
    private List<Erole> eroleList;
    public String getEsexStr() {
        return esexStr;
    }

    public List<Erole> getEroleList() {
        return eroleList;
    }

    public void setEroleList(List<Erole> eroleList) {
        this.eroleList = eroleList;
    }

    public void setEsexStr(String esexStr) {
        this.esexStr = esexStr;
    }

    public String[] getRids() {
        return rids;
    }

    public void setRids(String[] rids) {
        this.rids = rids;
    }

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