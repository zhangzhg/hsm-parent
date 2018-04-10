package com.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 足球比赛详情
 */
public class FootballMatchDetail implements Serializable {
    //基本信息
    FootballDetailInfo info;
    //场次： 包含时间和比赛名称
    FootballDetailMatchEvent matchevent;
    //主队信息
    @JsonProperty("home_team")
    FootballDetailTeam homeTeam;
    //客队信息
    @JsonProperty("away_team")
    FootballDetailTeam awayTeam;
    //实时直播比赛信息
    List<FootballDetailLive> tlive;
    //状态
    List<FootballDetailStat> stats;

    public FootballDetailInfo getInfo() {
        return info;
    }

    public void setInfo(FootballDetailInfo info) {
        this.info = info;
    }

    public FootballDetailMatchEvent getMatchevent() {
        return matchevent;
    }

    public void setMatchevent(FootballDetailMatchEvent matchevent) {
        this.matchevent = matchevent;
    }

    public FootballDetailTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(FootballDetailTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public FootballDetailTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(FootballDetailTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public List<FootballDetailLive> getTlive() {
        return tlive;
    }

    public void setTlive(List<FootballDetailLive> tlive) {
        this.tlive = tlive;
    }

    public List<FootballDetailStat> getStats() {
        return stats;
    }

    public void setStats(List<FootballDetailStat> stats) {
        this.stats = stats;
    }
}
