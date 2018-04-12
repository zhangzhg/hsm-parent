package com.hsm.api.model;

import com.framework.common.domain.BaseModel;
import com.hsm.api.util.DateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

 /**
 * 角色名称表实体<br>
 */
 @Entity
 @Table(name = "T_NICK_NAME")
public class NickName extends BaseModel{
	//所属用户ID
	@Column(name = "USER_ID")
	private String userId;
	//昵称名称
	@Column(name = "NAME")
	private String name;
	//头像URL
	@Column(name = "HEAD_PIC")
	private String headPic;
	//店铺ID
	@Column(name = "SHOP_ID")
	private String shopId;
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
	//是否是默认
	@Column(name = "IS_DEFAULT", columnDefinition = "NUMBER")
	private Integer isDefault;
	//被关注人数（默认为0）
	@Column(name = "BE_FOLLOW", columnDefinition = "NUMBER")
	private Integer beFollow;
	//昵称修改次数
	@Column(name = "UPDATE_NICK_COUNT", columnDefinition = "NUMBER")
	private Integer updateNickCount;
	//几连红
	@Column(name = "CONTINUITY_WIN_NUM", columnDefinition = "NUMBER")
	private Integer continuityWinNum;
	//是否是特邀
	@Column(name = "IS_SPECIALLY_INVITE", columnDefinition = "NUMBER")
	private Integer isSpeciallyInvite;
	//是否保密（0、不保密；1、保密；）
	@Column(name = "IS_SECRECY", columnDefinition = "NUMBER")
	private Integer isSecrecy;

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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public String getHeadPic() {
		return this.headPic;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopId() {
		return this.shopId;
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

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted?1:0;
	}

	public Boolean getDeleted() {
		return this.deleted==1;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault?1:0;;
	}

	public Boolean getIsDefault() {
		return this.isDefault==1;
	}

	public void setBeFollow(Integer beFollow) {
		this.beFollow = beFollow;
	}

	public Integer getBeFollow() {
		return this.beFollow;
	}

	public void setUpdateNickCount(Integer updateNickCount) {
		this.updateNickCount = updateNickCount;
	}

	public Integer getUpdateNickCount() {
		return this.updateNickCount;
	}

	public void setContinuityWinNum(Integer continuityWinNum) {
		this.continuityWinNum = continuityWinNum;
	}

	public Integer getContinuityWinNum() {
		return this.continuityWinNum;
	}

	public void setIsSpeciallyInvite(Boolean isSpeciallyInvite) {
		this.isSpeciallyInvite = isSpeciallyInvite?1:0;;
	}

	public Boolean getIsSpeciallyInvite() {
		return this.isSpeciallyInvite==1;
	}

	public void setIsSecrecy(Boolean isSecrecy) {
		this.isSecrecy = isSecrecy?1:0;;
	}

	public Boolean getIsSecrecy() {
		return this.isSecrecy==1;
	}

}
