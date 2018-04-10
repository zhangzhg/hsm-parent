package com.hsm.api.common;

public interface ICodeMessage {
    
	/**
	 * 获取错误码
	 * @return 错误码 
	 */
	String getCode();
	
	/**
	 * 获取错误描述
	 * @return 错误描述
	 */
	String getMsg();
	
}
