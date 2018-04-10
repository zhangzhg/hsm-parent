package com.hsm.api.vo;


import java.io.Serializable;

public class FoolballTeam implements Serializable {
    private String id;
    private String matcheventId;
    private String nameZh;
    private String nameZht;
    private String nameEn;
    private String logo;
    private String found;
    private String website;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatcheventId() {
        return matcheventId;
    }

    public void setMatcheventId(String matcheventId) {
        this.matcheventId = matcheventId;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getNameZht() {
        return nameZht;
    }

    public void setNameZht(String nameZht) {
        this.nameZht = nameZht;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFound() {
        return found;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
