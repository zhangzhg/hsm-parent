package com.api.em;

public enum RestUrlEnum {
    FOOTBALL_MATCH_EVENT("足球赛事资料", "/api/sports/football/matchevent/list"),
    FOOTBALL_TEAM("足球球员资料", "/api/sports/football/team/list");

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
