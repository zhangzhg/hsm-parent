package com.api.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 足球比赛情报
 */
public class FootballMatchIntelligence implements Serializable {
    //情报
    private IntelligenceInfo info;
    //比赛预测
    private IntelligenceChance chance;

    public IntelligenceInfo getInfo() {
        return info;
    }

    public void setInfo(IntelligenceInfo info) {
        this.info = info;
    }

    public IntelligenceChance getChance() {
        return chance;
    }

    public void setChance(IntelligenceChance chance) {
        this.chance = chance;
    }

    private class IntelligenceInfo implements Serializable {
        //有利情报
        private InfoMessage good;
        //不利情报
        private InfoMessage bad;
        //中立情报
        private InfoMessage neutral;

        public InfoMessage getGood() {
            return good;
        }

        public void setGood(InfoMessage good) {
            this.good = good;
        }

        public InfoMessage getBad() {
            return bad;
        }

        public void setBad(InfoMessage bad) {
            this.bad = bad;
        }

        public InfoMessage getNeutral() {
            return neutral;
        }

        public void setNeutral(InfoMessage neutral) {
            this.neutral = neutral;
        }
    }

    private class IntelligenceChance implements Serializable {
        private Result result;
        private Odd odds;

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

        public Odd getOdds() {
            return odds;
        }

        public void setOdds(Odd odds) {
            this.odds = odds;
        }
    }

    private class InfoMessage implements Serializable {
        //{情报重要程度(1-5),数值越大越重要, 情报内容}
        private String[] home;
        //{情报重要程度(1-5),数值越大越重要, 情报内容}
        private String[] away;

        public String[] getHome() {
            return home;
        }

        public void setHome(String[] home) {
            this.home = home;
        }

        public String[] getAway() {
            return away;
        }

        public void setAway(String[] away) {
            this.away = away;
        }
    }

    private class Result implements Serializable {
        //历史交锋
        private ResultInfo history;
        //近期战绩
        private ResultInfo recent;
        //近三年相似赔率
        private ResultInfo similar;

        public ResultInfo getHistory() {
            return history;
        }

        public void setHistory(ResultInfo history) {
            this.history = history;
        }

        public ResultInfo getRecent() {
            return recent;
        }

        public void setRecent(ResultInfo recent) {
            this.recent = recent;
        }

        public ResultInfo getSimilar() {
            return similar;
        }

        public void setSimilar(ResultInfo similar) {
            this.similar = similar;
        }
    }

    private class Odd implements Serializable {
        private String[] asian;
        private String[] europe;
        private String[] bigsmall;

        public String[] getAsian() {
            return asian;
        }

        public void setAsian(String[] asian) {
            this.asian = asian;
        }

        public String[] getEurope() {
            return europe;
        }

        public void setEurope(String[] europe) {
            this.europe = europe;
        }

        public String[] getBigsmall() {
            return bigsmall;
        }

        public void setBigsmall(String[] bigsmall) {
            this.bigsmall = bigsmall;
        }
    }

    private class ResultInfo implements Serializable {
        //主队
        private ResultInfoHome home;
        //客队
        private ResultInfoHome away;

        public ResultInfoHome getHome() {
            return home;
        }

        public void setHome(ResultInfoHome home) {
            this.home = home;
        }

        public ResultInfoHome getAway() {
            return away;
        }

        public void setAway(ResultInfoHome away) {
            this.away = away;
        }
    }

    private class ResultInfoHome {
        //胜场数
        @JsonProperty("won_count")
        private String wonCount;
        //负场数
        @JsonProperty("lost_count")
        private String lostCount;
        //概率
        private String rate;
        //平场数
        @JsonProperty("drawn_count")
        private String drawnCount;

        public String getWonCount() {
            return wonCount;
        }

        public void setWonCount(String wonCount) {
            this.wonCount = wonCount;
        }

        public String getLostCount() {
            return lostCount;
        }

        public void setLostCount(String lostCount) {
            this.lostCount = lostCount;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getDrawnCount() {
            return drawnCount;
        }

        public void setDrawnCount(String drawnCount) {
            this.drawnCount = drawnCount;
        }
    }
}
