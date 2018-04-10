package com.hsm.api.vo;

public class ApiCurrUserInfo {
	private String userId;
	private String phone;
	private String name;
	private String nickNameId;
	private String token;
	private String shopId;
	private Boolean isBlack;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getNickNameId() {
		return nickNameId;
	}
	public void setNickNameId(String nickNameId) {
		this.nickNameId = nickNameId;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public Boolean getIsBlack() {
		return isBlack;
	}
	public void setIsBlack(Boolean isBlack) {
		this.isBlack = isBlack;
	}
	
	
}
