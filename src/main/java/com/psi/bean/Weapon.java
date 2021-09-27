package com.psi.bean;

import java.io.Serializable;

public class Weapon implements Serializable {
    private int wid;
    private String wname;
    private String type;
    private String star;
    private String mainAttribute;
    private String secondAttribute;
    private String buffDesc;
    private int rid;

    public Weapon() {
    }

    public Weapon(int wid, String wname, String type, String star, String mainAttribute, String secondAttribute, String buffDesc, int rid) {
        this.wid = wid;
        this.wname = wname;
        this.type = type;
        this.star = star;
        this.mainAttribute = mainAttribute;
        this.secondAttribute = secondAttribute;
        this.buffDesc = buffDesc;
        this.rid = rid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getMainAttribute() {
        return mainAttribute;
    }

    public void setMainAttribute(String mainAttribute) {
        this.mainAttribute = mainAttribute;
    }

    public String getSecondAttribute() {
        return secondAttribute;
    }

    public void setSecondAttribute(String secondAttribute) {
        this.secondAttribute = secondAttribute;
    }

    public String getBuffDesc() {
        return buffDesc;
    }

    public void setBuffDesc(String buffDesc) {
        this.buffDesc = buffDesc;
    }

    @Override
    public String toString() {
        return "\nWeapon{" +
                "wid=" + wid +
                ", wname='" + wname + '\'' +
                ", type='" + type + '\'' +
                ", star='" + star + '\'' +
                ", mainAttribute='" + mainAttribute + '\'' +
                ", secondAttribute='" + secondAttribute + '\'' +
                ", buffDesc='" + buffDesc + '\'' +
                ", rid=" + rid +
                '}'+"\n";
    }
}
