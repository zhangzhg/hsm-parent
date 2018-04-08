package com.api.model;

import java.io.Serializable;

public class Football implements Serializable {
    private String id;
    //编号
    private String no;
    //开赛时间
    private String startTime;
    //开赛星期几
    private String week;
    //开赛日期
    private String startDate;
    //所属赛事ID
    private String matchId;
    //主队简称
    private String acnAbbr;
    //主队ID
    private String aidId;
    //排版日期
    private String arrangeDate;
    //客队简称
    private String hcnAbbr;
    //客队ID
    private String hid;
    //赛事简称
    private String matchNameAbbr;
    //是否支持单关
    private String isSingle;
    //是否可销售
    private String cellStatus;
    //让球
    private String giveUp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getAcnAbbr() {
        return acnAbbr;
    }

    public void setAcnAbbr(String acnAbbr) {
        this.acnAbbr = acnAbbr;
    }

    public String getAidId() {
        return aidId;
    }

    public void setAidId(String aidId) {
        this.aidId = aidId;
    }

    public String getArrangeDate() {
        return arrangeDate;
    }

    public void setArrangeDate(String arrangeDate) {
        this.arrangeDate = arrangeDate;
    }

    public String getHcnAbbr() {
        return hcnAbbr;
    }

    public void setHcnAbbr(String hcnAbbr) {
        this.hcnAbbr = hcnAbbr;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getMatchNameAbbr() {
        return matchNameAbbr;
    }

    public void setMatchNameAbbr(String matchNameAbbr) {
        this.matchNameAbbr = matchNameAbbr;
    }

    public String getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(String isSingle) {
        this.isSingle = isSingle;
    }

    public String getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(String cellStatus) {
        this.cellStatus = cellStatus;
    }

    public String getGiveUp() {
        return giveUp;
    }

    public void setGiveUp(String giveUp) {
        this.giveUp = giveUp;
    }
}
