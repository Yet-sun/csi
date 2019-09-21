package com.csi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @Author: sunyue
 * @Description:
 * @Date: Create in 21:39 2019/9/16
 * @Version: 1.0
 */
public class Notice {

    private Integer ID;
    //公告名称
    private String TITLE;
    //公告内容
    private String CONTENT;
    //创建时间
    @DateTimeFormat
    private Timestamp CREATE_DAT;
    //公告人
    private Integer USER_ID;
    private String USER_NAME;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public Timestamp getCREATE_DAT() {
        return CREATE_DAT;
    }

    public void setCREATE_DAT(Timestamp CREATE_DAT) {
        this.CREATE_DAT = CREATE_DAT;
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "ID=" + ID +
                ", TITLE='" + TITLE + '\'' +
                ", CONTENT='" + CONTENT + '\'' +
                ", CREATE_DAT=" + CREATE_DAT +
                ", USER_ID=" + USER_ID +
                ", USER_NAME='" + USER_NAME + '\'' +
                '}';
    }
}
