package com.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 球员字段说明
 */
public class FootballMatchLineup implements Serializable {
    //球员id
    private String id;
    //球员名称
    private String name;
    //球员logo,地址前缀:https://cdn.leisu.com/avatar/
    private String logo;
    //球衣号
    @JsonProperty("shirt_number")
    private String shirtNumber;
    //球员位置,F前锋 M中锋 D后卫 G守门员 SUB替补,其他为未知
    private String position;
    //阵容x坐标 总共100
    private String x;
    //阵容y坐标 总共100
    private String y;
    //评分
    private String rating;
    //球员事件
    private FootballLineupIncident incidents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(String shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public FootballLineupIncident getIncidents() {
        return incidents;
    }

    public void setIncidents(FootballLineupIncident incidents) {
        this.incidents = incidents;
    }
}
