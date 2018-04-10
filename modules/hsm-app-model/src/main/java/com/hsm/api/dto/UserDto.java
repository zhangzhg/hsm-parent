 /**
 * Description: APP用户名表实体
 * Copyright:Copyright 2017 nfky.com. All rights reserved
 * @author:shenhs
 * @since:1.0.1
 * Create at:2017-10-30 下午 15:23:35
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2017-10-30   shenhs       1.0.1     Initial
 */
package com.hsm.api.dto;

import java.io.Serializable;

 /**
 * APP用户名表实体<br>
 *
 * @author shenhs
 * @since [1.0.1]
 * @version [1.0.1, 2017-10-30]
 */
public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	//columns START
	//手机号码
	private String phone;
	//姓名
	private String name;
	//密码
	private String pwd;
	//是否以默认角色登录
	private Boolean isDefault;
	//columns END
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
	public Boolean getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	
}
