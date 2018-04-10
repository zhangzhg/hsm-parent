package com.hsm.api.model;

import com.framework.common.domain.BaseModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_USER")
public class User extends BaseModel implements Serializable {
    //手机号码
    @Column(name = "PHONE")
    private String phone;
    //姓名
    @Column(name = "NAME")
    private String name;
    //密码
    @Column(name = "PWD")
    private String pwd;
    //头像
    @Column(name = "HEAD_PIC")
    private String headPic;
    //真实名称
    @Column(name = "REAL_NAME")
    private String realName;
    //昵称
    @Column(name = "NICK_NAME")
    private String nickName;
    //销售人员ID
    @Column(name = "SALER_ID")
    private String salerId;
    //属于销售人员的哪个组
    @Column(name = "SALER_GROUP_ID")
    private String salerGroupId;
    //店铺ID
    @Column(name = "SHIP_ID")
    private String shipId;
    //店铺名称
    @Column(name = "SHOP_NAME")
    private String shopName;
    //身份证号码
    @Column(name = "IDENTITY_CARD")
    private String identityCard;
    //银行卡
    @Column(name = "BANK_CARD")
    private String bankCard;
    //银行
    @Column(name = "BANK_ACCOUNT")
    private String bankAccount;
    //银行卡属于哪个省
    @Column(name = "BANK_PROVINCE")
    private String bankProvince;
    //开户银行
    @Column(name = "BANK_ID")
    private String bankId;
    //微信的OPEN
    @Column(name = "WEIXIN_OPEN_ID")
    private String weixinOpenId;
    //银行卡属于哪个市
    @Column(name = "BANK_CITY_ID")
    private String bankCityId;
    //银行卡属于哪个省
    @Column(name = "BANK_PROVINCE_ID")
    private String bankProvinceId;
    //状态（1、验证中；2、验证成功；3、验证未成功；4、注册成功；5、注册失败）
    @Column(name = "STATUS")
    private Integer status;
    //微信
    @Column(name = "WEIXIN")
    private String weixin;
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
    private Boolean deleted;
    //昵称ID
    @Column(name = "NICK_NAME_ID")
    private String nickNameId;
    //系统用户id
    @Column(name = "SYSUSER_ID")
    private String sysuserId;
    //银行支行
    @Column(name = "BANK_BRANCH")
    private String bankBranch;
    //是否绑定银行卡
    @Column(name = "IS_BIND_BANK_CARD")
    private Boolean isBindBankCard;
    //备注
    @Column(name = "REMARK")
    private String remark;
    //isBlack
    @Column(name = "IS_BLACK")
    private Boolean isBlack;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSalerId() {
        return salerId;
    }

    public void setSalerId(String salerId) {
        this.salerId = salerId;
    }

    public String getSalerGroupId() {
        return salerGroupId;
    }

    public void setSalerGroupId(String salerGroupId) {
        this.salerGroupId = salerGroupId;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    public String getBankCityId() {
        return bankCityId;
    }

    public void setBankCityId(String bankCityId) {
        this.bankCityId = bankCityId;
    }

    public String getBankProvinceId() {
        return bankProvinceId;
    }

    public void setBankProvinceId(String bankProvinceId) {
        this.bankProvinceId = bankProvinceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getNickNameId() {
        return nickNameId;
    }

    public void setNickNameId(String nickNameId) {
        this.nickNameId = nickNameId;
    }

    public String getSysuserId() {
        return sysuserId;
    }

    public void setSysuserId(String sysuserId) {
        this.sysuserId = sysuserId;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Boolean getBindBankCard() {
        return isBindBankCard;
    }

    public void setBindBankCard(Boolean bindBankCard) {
        isBindBankCard = bindBankCard;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getBlack() {
        return isBlack;
    }

    public void setBlack(Boolean black) {
        isBlack = black;
    }
}
