package com.hsm.api.model;

import com.framework.common.domain.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * app token表实体<br>
 */
@Entity
@Table(name = "T_APP_TOKEN")
public class AppToken {
    //token
    @Column(name = "TOKEN")
    @Id
    private String token;
    //用户ID
    @Column(name = "USER_ID")
    private String userId;
    //刷新时间
    @Column(name = "REFRESH_TIME", columnDefinition = "TIMESTAMP")
    private Date refreshTime;
    //创建时间
    @Column(name = "CREATE_TIME", columnDefinition = "TIMESTAMP")
    private Date createTime;
    //columns END

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setRefreshTime(Date refreshTime) {
        this.refreshTime = refreshTime;
    }

    public Date getRefreshTime() {
        return this.refreshTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
}
