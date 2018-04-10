package com.hsm.api.vo;

import com.framework.common.util.JSONUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FootballMatchEvent implements Serializable {
    private List<MatchEvent> matchEvents;
    private List<Area> areas;
    private List<Country> countries;

    public FootballMatchEvent() {
        matchEvents = new ArrayList<>();
        areas = new ArrayList<>();
        countries = new ArrayList<>();
    }

    public List<MatchEvent> getMatchEvents() {
        return matchEvents;
    }

    public void setMatchEvents(List<MatchEvent> matchEvents) {
        this.matchEvents = matchEvents;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void setData(HashMap data) {
        data.forEach((key, map) -> {
            if ("areas".equals(key)) {
                ((Map)map).forEach((k,v)->{
                    String json = JSONUtils.object2Json(v);
                    json = case2hump(json);
                    Area area = JSONUtils.json2Entity(json, Area.class);
                    this.areas.add(area);
                });
            }

            if ("countrys".equals(key)) {
                ((Map)map).forEach((k,v)-> {
                    String json = JSONUtils.object2Json(v);
                    json = case2hump(json);
                    Country country = JSONUtils.json2Entity(json, Country.class);
                    this.countries.add(country);
                });
            }

            if ("matchEvents".equals(key)) {
                ((Map)map).forEach((k,v)->{
                    String json = JSONUtils.object2Json(v);
                    json = case2hump(json);
                    MatchEvent matchEvent = JSONUtils.json2Entity(json, MatchEvent.class);
                    this.matchEvents.add(matchEvent);
                });
            }
        });
    }

    private String case2hump(String json) {
        String[] words = json.split("_");
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<words.length; i++) {
            if (i == 0) {
                builder.append(words[0]);
            } else {
                String word = words[i];
                word = word.substring(0, 1).toUpperCase().concat(word.substring(1, word.length()));
                builder.append(word);
            }
        }

        return builder.toString();
    }
}
