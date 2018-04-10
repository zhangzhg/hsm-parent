package com.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 足球历史数据
 */
public class FootballMatchHistory implements Serializable {
    //json格式的字符串 球队列表
    private String teams;
    //json格式的字符串 赛事列表
    private String matchevents;
    //json格式的字符串 当前比赛信息
    private String info;
    //json格式的字符串 历史交锋/近期战绩
    private String history;
    //json格式的字符串 伤停情况
    private String injury;
    //json格式的字符串 进球分布
    @JsonProperty("goal_distribution")
    private String goalDistribution;

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getMatchevents() {
        return matchevents;
    }

    public void setMatchevents(String matchevents) {
        this.matchevents = matchevents;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getInjury() {
        return injury;
    }

    public void setInjury(String injury) {
        this.injury = injury;
    }

    public String getGoalDistribution() {
        return goalDistribution;
    }

    public void setGoalDistribution(String goalDistribution) {
        this.goalDistribution = goalDistribution;
    }
}
