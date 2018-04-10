package com.hsm.api.properties;

import com.hsm.api.em.RestUrlEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "api")
@PropertySource(value = "classpath:rest-api.properties")
public class RestApiProperties {
    private String url;
    private String user;
    private String secret;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String build(RestUrlEnum em, Map<String, ?> uriVariables) {
        StringBuilder builder = new StringBuilder();
        builder.append(url)
                .append(em.getUrl())
                .append("?user=")
                .append(this.user)
                .append("&secret=")
                .append(this.secret);
        if (!ObjectUtils.isEmpty(uriVariables)) {
            uriVariables.forEach((k,v) -> {
                builder.append("&")
                .append(k)
                .append("=")
                .append(v);
            });
        }
        return builder.toString();
    }

    public String getRootUrl(RestUrlEnum em) {
        StringBuilder builder = new StringBuilder();
        builder.append(url).append(em.getUrl());
        return builder.toString();
    }

    public String buildPostUrl(RestUrlEnum em) {
        StringBuilder builder = new StringBuilder();
        builder.append(url)
                .append(em.getUrl());

        return builder.toString();
    }

}
