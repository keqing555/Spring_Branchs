package com.aop.bean;

public class Role {
    private int rid;
    private String rname;
    private String area;
    private String star;
    private int age;
    private String sex;
    private String elementalForce;

    public Role() {
    }

    public Role(int rid, String rname, String area, String star, int age, String sex, String elementalForce) {
        this.rid = rid;
        this.rname = rname;
        this.area = area;
        this.star = star;
        this.age = age;
        this.sex = sex;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getElementalForce() {
        return elementalForce;
    }

    public void setElementalForce(String elementalForce) {
        this.elementalForce = elementalForce;
    }

    @Override
    public String toString() {
        return "\n Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", area='" + area + '\'' +
                ", star='" + star + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", elementalForce='" + elementalForce + '\'' +
                '}' + "\n";
    }
}
