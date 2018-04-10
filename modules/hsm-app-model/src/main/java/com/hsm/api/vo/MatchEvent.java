package com.hsm.api.vo;

import java.io.Serializable;

public class MatchEvent implements Serializable {
    private String id;
    private String type;
    private String areaId;
    private String areaNameZh;
    private String countryId;
    private String countryNameZh;
    private String nameZh;
    private String shortNameZh;
    private String nameZht;
    private String shortNameZht;
    private String nameEn;
    private String shortNameEn;
    private String logo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaNameZh() {
        return areaNameZh;
    }

    public void setAreaNameZh(String areaNameZh) {
        this.areaNameZh = areaNameZh;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryNameZh() {
        return countryNameZh;
    }

    public void setCountryNameZh(String countryNameZh) {
        this.countryNameZh = countryNameZh;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getShortNameZh() {
        return shortNameZh;
    }

    public void setShortNameZh(String shortNameZh) {
        this.shortNameZh = shortNameZh;
    }

    public String getNameZht() {
        return nameZht;
    }

    public void setNameZht(String nameZht) {
        this.nameZht = nameZht;
    }

    public String getShortNameZht() {
        return shortNameZht;
    }

    public void setShortNameZht(String shortNameZht) {
        this.shortNameZht = shortNameZht;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getShortNameEn() {
        return shortNameEn;
    }

    public void setShortNameEn(String shortNameEn) {
        this.shortNameEn = shortNameEn;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
