package com.hsm.api.vo;

import java.io.Serializable;

public class Country implements Serializable {
    private String id;
    private String areaId;
    private String nameZh;
    private String nameZht;
    private String nameEn;
    private String logo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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
}
