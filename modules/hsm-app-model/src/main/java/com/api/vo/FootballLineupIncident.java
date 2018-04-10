package com.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 球员事件
 */
public class FootballLineupIncident implements Serializable {
    //事件类型
    private String type;
    //事件时间
    private String time;
    //分钟数
    private String minute;
    //加时时间
    private String addtime;
    //发生方 0-中立,1-主队,2-客队
    private String belong;
    //文本描述
    private String text;
    //主队比分
    @JsonProperty("home_score")
    private String homeScore;
    //客队比分
    @JsonProperty("home_score")
    private String awayScore;
    //球员信息 player-相关球员 assist1-助攻球员1 assist2-助攻球员2 in_player 换上球员 out_player-换下球员
    private Player player;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private class Player implements Serializable {
        //球员id
        private String id;
        //球员名称
        private String name;

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
    }
}
