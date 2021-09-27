package com.psi.bean;

import java.io.Serializable;

public class HolyRelic implements Serializable {
    private int hid;
    private String hname;
    private String position;
    private String star;
    private String twoPiece;
    private String fourPiece;
    private int rid;

    public HolyRelic() {
    }

    public HolyRelic(int hid, String hname, String position, String star, String twoPiece, String fourPiece, int rid) {
        this.hid = hid;
        this.hname = hname;
        this.position = position;
        this.star = star;
        this.twoPiece = twoPiece;
        this.fourPiece = fourPiece;
        this.rid = rid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getTwoPiece() {
        return twoPiece;
    }

    public void setTwoPiece(String twoPiece) {
        this.twoPiece = twoPiece;
    }

    public String getFourPiece() {
        return fourPiece;
    }

    public void setFourPiece(String fourPiece) {
        this.fourPiece = fourPiece;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "\nHolyRelic{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", position='" + position + '\'' +
                ", star='" + star + '\'' +
                ", twoPiece='" + twoPiece + '\'' +
                ", fourPiece='" + fourPiece + '\'' +
                ", rid=" + rid +
                '}'+"\n";
    }
}
