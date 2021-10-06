package com.mvc.bean;

import java.util.*;

public class Role {
    private int rid;
    private String rname;
    private String area;
    private int age;
    private String sex;
    private String star;
    private String elementalForce;
    private String[] hobbies;
    private Weapon weapon;
    private List<Weapon> weaponList;
    private Set<Weapon> weaponSet;
    private Map<String, Weapon> weaponMap;

    public Role() {
        //初始化Set集合
        weaponSet = new HashSet<>();
        Weapon weapon1 = new Weapon();
        Weapon weapon2 = new Weapon();
        weaponSet.add(weapon1);
        weaponSet.add(weapon2);
    }

    public Role(int rid, String rname, String area, int age, String sex, String star, String elementalForce) {
        this.rid = rid;
        this.rname = rname;
        this.area = area;
        this.age = age;
        this.sex = sex;
        this.star = star;
        this.elementalForce = elementalForce;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    public Set<Weapon> getWeaponSet() {
        return weaponSet;
    }

    public void setWeaponSet(Set<Weapon> weaponSet) {
        this.weaponSet = weaponSet;
    }

    public Map<String, Weapon> getWeaponMap() {
        return weaponMap;
    }

    public void setWeaponMap(Map<String, Weapon> weaponMap) {
        this.weaponMap = weaponMap;
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

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
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
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", star='" + star + '\'' +
                ", elementalForce='" + elementalForce + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", \n weapon=" + weapon +
                ",\n weaponList=" + weaponList +
                ",\n weaponSet=" + weaponSet +
                ",\n weaponMap=" + weaponMap +
                '}' + "\n";
    }
}
