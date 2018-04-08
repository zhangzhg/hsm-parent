package com.api.vo;

import java.io.Serializable;

public class Area implements Serializable {
    private String id;
    private String nameZh;
    private String nameZht;
    private String nameEn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
