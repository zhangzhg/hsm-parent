package com.hsm.api.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hsm")
@PropertySource(value = "classpath:rest-api.properties")
public class HsmProperties {
    private String upLoad;
    private String img;
    private String qrcodeUrl;
    private String picHref;
    private String headPicHref;
    private String picUrls;
    private String ArticleUrl;
    private String ArticleUrlApi;
    private String bankUrl;

    public String getUpLoad() {
        return upLoad;
    }

    public void setUpLoad(String upLoad) {
        this.upLoad = upLoad;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public String getPicHref() {
        return picHref;
    }

    public void setPicHref(String picHref) {
        this.picHref = picHref;
    }

    public String getHeadPicHref() {
        return headPicHref;
    }

    public void setHeadPicHref(String headPicHref) {
        this.headPicHref = headPicHref;
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    public String getArticleUrl() {
        return ArticleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        ArticleUrl = articleUrl;
    }

    public String getArticleUrlApi() {
        return ArticleUrlApi;
    }

    public void setArticleUrlApi(String articleUrlApi) {
        ArticleUrlApi = articleUrlApi;
    }

    public String getBankUrl() {
        return bankUrl;
    }

    public void setBankUrl(String bankUrl) {
        this.bankUrl = bankUrl;
    }
}
