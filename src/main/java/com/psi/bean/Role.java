package com.psi.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Role {
    private int rid;
    private String rname;
    private String area;
    private String star;
    private int age;
    private String sex;
    private String elementalForce;
    private Weapon weapon;
    private String[] arr;
    private List<Weapon> list;
    private Set<Weapon> set;
    private Map<Integer, Weapon> map;

    public Role() {
    }

    public Role(int rid, String rname, String area, String star, int age, String sex, String elementalForce, Weapon weapon, String[] arr, List<Weapon> list, Set<Weapon> set, Map<Integer, Weapon> map) {
        this.rid = rid;
        this.rname = rname;
        this.area = area;
        this.star = star;
        this.age = age;
        this.sex = sex;
        this.elementalForce = elementalForce;
        this.weapon = weapon;
        this.arr = arr;
        this.list = list;
        this.set = set;
        this.map = map;
    }

    public Role(String rname, Weapon weapon, String[] arr, List<Weapon> list, Set<Weapon> set, Map<Integer, Weapon> map) {
        this.rname=rname;
        this.weapon=weapon;
        this.arr=arr;
        this.list=list;
        this.set=set;
        this.map=map;
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public List<Weapon> getList() {
        return list;
    }

    public void setList(List<Weapon> list) {
        this.list = list;
    }

    public Set<Weapon> getSet() {
        return set;
    }

    public void setSet(Set<Weapon> set) {
        this.set = set;
    }

    public Map<Integer, Weapon> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Weapon> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", area='" + area + '\'' +
                ", star='" + star + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", elementalForce='" + elementalForce + '\'' +
                ", weapon=" + weapon +
                ", arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                '}';
    }
}
