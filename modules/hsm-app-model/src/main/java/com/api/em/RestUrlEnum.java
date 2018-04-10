package com.api.em;

public enum RestUrlEnum {
    FOOTBALL_MATCH_EVENT("足球赛事资料", "/api/sports/football/matchevent/list"),
    FOOTBALL_TEAM("足球球员资料", "/api/sports/football/team/list"),
    FOOTBALL_MATCH_SPORTTERY("足球竞彩关联", "/api/sports/football/match/sporttery"),
    FOOTBALL_MATCH_IDS_DELETE("24小时内删除的比赛id", "/api/sports/football/match/deleted_ids"),
    FOOTBALL_MATCH_DETAIL("足球比赛详情", "/api/sports/football/match/detail"),
    FOOTBALL_MATCH_LINEUP("足球比赛阵容", "/api/sports/football/match/lineup"),
    FOOTBALL_MATCH_HISTORY("足球历史数据", "/api/sports/football/match/analysis"),
    FOOTBALL_MATCH_INTELLIGENCE("足球比赛情报", "/api/sports/football/match/intelligence"),
    FOOTBALL_MATCH_SCORE("足球即时比分", "/api/sports/football/match/live"),
    FOOTBALL_MATCH_ODDS("足球赛程赛果", "/api/sports/football/odds/list"),
    FOOTBALL_ODDS("足球即时指数", "/api/sports/football/odds/live"),
    FOOTBALL_ODDS_HISTORY("足球指数历史", "/api/sports/football/odds/live_history"),;

    private String name;
    private String url;

    RestUrlEnum(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

}