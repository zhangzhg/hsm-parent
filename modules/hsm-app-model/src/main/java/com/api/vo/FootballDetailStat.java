package com.api.vo;

import java.io.Serializable;

public class FootballDetailStat implements Serializable {
    private String home;
    private String away;
    private String type;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
