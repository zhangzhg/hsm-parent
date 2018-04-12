package com.hsm.api.model;

import com.framework.common.domain.BaseModel;
import com.hsm.api.util.DateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 钱包表实体<br>
 */
@Entity
@Table(name = "T_PURSE")
public class Purse extends BaseModel {
    //用户ID
    @Column(name = "USER_ID")
    private String userId;
    //奖金的钱（精确到分）
    @Column(name = "BONUS")
    private Double bonus;
    //充值的钱(精确到分)
    @Column(name = "PURSE")
    private Double purse;
    //创建人
    @Column(name = "CREATER_ID")
    private String createrId;
    //创建人姓名
    @Column(name = "CREATER_NAME")
    private String createrName;
    //创建时间
    @Column(name = "CREATE_TIME", columnDefinition = "TIMESTAMP")
    private Date createTime;
    //更新人
    @Column(name = "UPDATER_ID")
    private String updaterId;
    //更新人姓名
    @Column(name = "UPDATER_NAME")
    private String updaterName;
    //更新时间
    @Column(name = "UPDATE_TIME", columnDefinition = "TIMESTAMP")
    private Date updateTime;
    //是否删除（0、未删除；1、删除）
    @Column(name = "DELETED")
    private Integer deleted;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getBonus() {
        return this.bonus;
    }

    public void setPurse(Double purse) {
        this.purse = purse;
    }

    public Double getPurse() {
        return this.purse;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getCreaterId() {
        return this.createrId;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getCreaterName() {
        return this.createrName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        return DateUtil.limitDay(this.createTime);
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    public String getUpdaterId() {
        return this.updaterId;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public String getUpdaterName() {
        return this.updaterName;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTimeStr() {
        return DateUtil.limitDay(this.updateTime);
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public Boolean getDeleted() {
        return deleted==1;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted?1:0;
    }

}
