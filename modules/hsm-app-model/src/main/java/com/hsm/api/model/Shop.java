package com.hsm.api.model;

 import com.framework.common.domain.BaseModel;
 import com.hsm.api.util.DateUtil;
 import org.apache.commons.lang3.builder.ToStringBuilder;
 import org.apache.commons.lang3.builder.ToStringStyle;

 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.Table;
 import java.util.Date;

 /**
 * 店铺实体<br>
 *
 */
 @Entity
 @Table(name = "T_SHOP")
public class Shop extends BaseModel{
	//店铺名称
	@Column(name = "NAME")
	private String name;
	//图标
	@Column(name = "HEAD_PIC")
	private String headPic;
	//销售人员ID
	@Column(name = "SALER_ID")
	private String salerId;
	//排序
	@Column(name = "SORT")
	private Integer sort;
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

	public void setSalerId(String salerId) {
		this.salerId = salerId;
	}

	public String getSalerId() {
		return this.salerId;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
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

}
