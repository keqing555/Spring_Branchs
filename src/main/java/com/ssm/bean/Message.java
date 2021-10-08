package com.ssm.bean;

import java.util.Date;

public class Message {
    private Long id;

    private String title;

    private String content;

    private String attachmenturl;

    private Date sendtime;

    private String sendstate;

    private Long sendeid;

    private Long receipteid;

    private String messagetype;

    private String remark1;

    private String remark2;

    private String remark3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAttachmenturl() {
        return attachmenturl;
    }

    public void setAttachmenturl(String attachmenturl) {
        this.attachmenturl = attachmenturl == null ? null : attachmenturl.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getSendstate() {
        return sendstate;
    }

    public void setSendstate(String sendstate) {
        this.sendstate = sendstate == null ? null : sendstate.trim();
    }

    public Long getSendeid() {
        return sendeid;
    }

    public void setSendeid(Long sendeid) {
        this.sendeid = sendeid;
    }

    public Long getReceipteid() {
        return receipteid;
    }

    public void setReceipteid(Long receipteid) {
        this.receipteid = receipteid;
    }

    public String getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype == null ? null : messagetype.trim();
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

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }
}