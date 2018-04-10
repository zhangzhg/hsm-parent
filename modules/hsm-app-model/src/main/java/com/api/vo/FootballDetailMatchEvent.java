package com.api.vo;

import java.io.Serializable;

public class FootballDetailMatchEvent implements Serializable {
    //季度：2017-2018
    private String season;
    //中文描述：英格兰超级联赛
    private String nameZh;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
