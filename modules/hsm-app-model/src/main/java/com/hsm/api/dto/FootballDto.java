package com.hsm.api.dto;

import com.framework.common.util.MD5Utils;

import java.io.Serializable;
import java.util.Arrays;

public class FootballDto implements Serializable {
	//赛事ID
	private String[] matchIds;
	//玩法类型ID（1、胜平负；2、让球胜平负；3、比分；4、总进球数；5、半全称；6、混合过关）
	private Integer typeId;
	//选择的足球玩法的itemIds
	private String itemIds;

	public String[] getMatchIds() {
		return matchIds;
	}
	public void setMatchIds(String[] matchIds) {
		this.matchIds = matchIds;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getItemIds() {
		return itemIds;
	}
	public void setItemIds(String itemIds) {
		this.itemIds = itemIds;
	}
	
	public String getCacheKey() {
		StringBuffer str=new StringBuffer("queryFootballGroupVo");
		if(matchIds!=null&&matchIds.length>0) {
			Arrays.sort(matchIds);
			str.append("#").append(Arrays.toString(matchIds));
		}
		str.append("#").append(typeId.toString());
		return MD5Utils.encrypt(str.toString());
	}
}
