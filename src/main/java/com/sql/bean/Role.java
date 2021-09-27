package com.sql.bean;

public class Role {
    private int rid;
    private String rname;
    private String area;
    private String star;
    private String sex;
    private int age;
    private String elementalForce;

    public Role() {
    }

    public Role(int rid, String rname, String area, String star, String sex, int age, String elementalForce) {
        this.rid = rid;
        this.rname = rname;
        this.area = area;
        this.star = star;
        this.sex = sex;
        this.age = age;
        this.elementalForce = elementalForce;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getElementalForce() {
        return elementalForce;
    }

    public void setElementalForce(String elementalForce) {
        this.elementalForce = elementalForce;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", area='" + area + '\'' +
                ", star='" + star + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", elementalForce='" + elementalForce + '\'' +
                '}';
    }
}
