package com.hsm.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class FootballDetailTeam implements Serializable {
    private String id;
    private String logo;
    private String score;
    @JsonProperty("half_score")
    private String halfScore;
    @JsonProperty("name_zh")
    private String nameZh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHalfScore() {
        return halfScore;
    }

    public void setHalfScore(String halfScore) {
        this.halfScore = halfScore;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
