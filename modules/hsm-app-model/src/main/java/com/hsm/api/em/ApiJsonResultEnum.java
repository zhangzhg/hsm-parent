package com.hsm.api.em;

import com.hsm.api.common.ICodeMessage;

public enum ApiJsonResultEnum implements ICodeMessage {
	    FAIL("-1","操作失败"),
		SUCCESS("1000","操作成功"),
		ACC_PWD_ERROR("1001","账号密码错误"),
		AUTH_EXPI("1002","授权过期"),
		LACK_PARAM("1003","缺少参数"),
		PARAM_ERROR("1004","参数错误"),
		VERI_CODE_ERROR("1005","验证码错误"),
		INVI_CODE_ERROR("1006","邀请码错误"),
	    NO_LOGIN("1007","未登录"),
	    NO_VERI_CODE("1008","未获取验证码或验证码已经过期"),
	    EXIST_USER("1009","该手机号码已经注册过"),
	    SERVICE_NOT_OPEN("1010","无法开通此服务，请先联系您的店主开通权限"),
	    VERI_CODE_FREQ("1011","获取注册验证码太频繁，获取间隔时间是120秒"),
        NO_REGISTER("1012","该用户未注册"),
        EXCEPTION("1013","系统错误，请稍后再试或联系店主"),
        EXCEPTION_BANK("1014","未查询到银行"),
        NO_FOUND("1015","未找到该订单信息,请稍后再试或联系店主"),
        EXCEPTION_IDCARD("1016","身份证号码有误"),
        EXCEPTION_BANDNO("1017","银行卡号码有误"),
        NOt_SUFFICIENT_FUNDS("1018","余额不足，下单失败"),
        SYSTEMERROR("1019","接口返回（系统）错误"),
        ORDERPAID("1021","订单已支付"),
        NOAUTH("1022","商户无权限"),
        AUTHCODEEXPIRE("1023","二维码已过期，请用户在微信上刷新后再试"),
        NOTENOUGH("1024","余额不足"),
        NOTSUPORTCARD("1025","不支持卡类型"),
        ORDERCLOSED("1026","订单已关闭"),
        ORDERREVERSED("1027","订单已撤销"),
        BANKERROR("1028","银行系统异常"),
        USERPAYING("1029","用户支付中，需要输入密码"),
        AUTH_CODE_ERROR("1030","授权码参数错误"),
        AUTH_CODE_INVALID("1031","授权码检验错误"),
        XML_FORMAT_ERROR("1032","XML 格式错误"),
        REQUIRE_POST_METHOD("1033","请使用 post 方法"),
        SIGNATURE_ERROR("1034","签名错误"),
        LACK_PARAMS("1035","缺少参数"),
        NOT_UTF8("1036","编码格式错误"),
        BUYER_MISMATCH("1037","支付帐号错误"),
        APPID_NOT_EXIST("1038","APPID 不存在"),
        MCHID_NOT_EXIST("1039","MCHID不存在"),
        OUT_TRADE_NO_USED("1040","商户订单号重复"),
        APPID_MCHID_NOT_MATCH("1041","appid 和 mch_id 不匹配"),
        ORDERNOTEXIST("1042","此交易订单号不存在"),
        COMB_ERROR("1043","参数串数有错误"),
        TICKET_ERROR("1044","参数注数有错误"),
        TICKET_INFO_ERROR("1045","参数每注详情有错误"),
        SIGN_ERROR("1046","签名错误"),
        WILO_14_NUM_ERROR("1047","胜负彩需要14场"),
        OLD_PASSWORD_ERROR ("1048","旧密码不正确"),
        NO_PARAMS_TICKETS_ERROR ("1049","奖金优化,参数tickets必填"),
        ROLE_EXISTENCE("1050","角色已存在"),
        ROLE_NOEXISTE("1051","该用户未查询到该角色"),
        ROLE_ISFOLLOW("1052","已关注该用户，请勿重复关注"),
        INVALID_USER("1053","该用户已被删"),
        BALANCE_LESS("1054","余额不足，请充值"),
        MONEY_DIFF("1055","总金额不对，请确认"),
        USER_NOEXIST("1056","用户不存在"),
        ACTUAL_MONEY_ERROR("1057","参数实际金额有错误"),
        PARAM_ALLOWFOLLOW_REQUIRE("1058","参数allowFollow是必填"),
        PARAM_COMB_ID_REQUIRE("1059","参数combId是必填"),
        PARAM_COMB_NAME_REQUIRE("1060","参数combName是必填"),
        PARAM_IS_OPTIMIZE_REQUIRE("1061","参数isOptimize是必填"),
        PARAM_MULTIPLE_REQUIRE("1062","参数multiple是必填"),
        PARAM_TICKET_REQUIRE("1063","参数ticket是必填"),
        PARAM_GAME_WAY_REQUIRE("1064","参数gameWay是必填"),
        PARAM_GAME_TYPE_REQUIRE("1065","参数gameType是必填"),
        PARAM_ACTUAL_MONEY_REQUIRE("1066","参数actualMoney是必填"),
        PARAM_FINAL_MONEY_REQUIRE("1067","参数finalMoney是必填"),
        PARAM_WIN_MONEY_REQUIRE("1068","参数winMoney是必填"),
        PARAM_TIME_STAMP_REQUIRE("1069","参数timeStamp是必填"),
        PARAM_NONCE_STR_REQUIRE("1070","参数nonceStr是必填"),
        PARAM_SIGN_REQUIRE("1071","参数sign是必填"),
        PARAM_ITEMIDS_REQUIRE("1072","参数itemIds是必填"),
        PARAM_TICKETS_REQUIRE("1073","参数tickets是必填"),
        PARAM_PERIOD_REQUIRE("1074","参数period是必填"),
        PARAM_GAME_ID_REQUIRE("1075","参数gameId是必填"),
        PARAM_IS_COURAGE_REQUIRE("1076","参数isCourage是必填"),
        PARAM_IS_APPEND_REQUIRE("1077","参数isAppend是必填"),
        PARAM_NO_COURAGE_ITEM_ID_REQUIRE("1078","参数noCourageItemId是必填"),
        NOT_SUPPORT_GAME_TYPE("1079","该接口不支持该彩种"),
        NOT_SUPPORT_NOTICE_TYPE("1080","该接口不支持该通知类型"),
        NOT_EQUAL_NAME("1081","银行卡身份证名字与注册身份证名字不一致"),
        NOT_SUPPORT_PAY_TYPE("1082","该接口不支持该支付方式"),
        ABNORMAL_BALANCE("1084","可提现余额不足"),
        UNBOUND_BANK("1085","未绑定银行卡"),
        NOT_IN_TIME("1086","未在规定时间内不能下单"),
        NOT_BDING_IDCARD("1087","请先绑定身份证"),
        RESPONSE_SIGN_VERI_ERROR("1088","响应签名验证错误"),
        REQUEST_FAIL("1089","请求失败"),
        EXIST_UNBOUND_BANK("1090","已经绑定过该银行卡"),
        EXIST_APPLY("1091","该订单已经申请过，不能重复申请"),
        STAKE_NUM_LIMIT("1092","注数超过上限5000"),
        FINISH_MONEY_ERROR("1093","参数最终金额有错误"),
        INTERFACE_REPAIR_ING("1094","接口正在维护"),
        RSA_FAIL("1095","RSA加密失败"),
        ABNORMAL_ERROR("1096","提现金额必须大于等于10元"),
        HG_MONEY_ERROR("1097","充值金额必须大于等于2元"),
        ROLENAME_DIFF("1098","该昵称已存在"),
        FHT_MONEY_ERROR("1099","充值金额必须大于等于10元"),
        FHT_NOT_OPEN_SERVICE("1100","银行卡未开通认证支付[6100060]"),
        EXP_DATE_ERROR("1101","信用卡有效期位数是四位"),
        NO_SHOP("1102","没有找到店铺，请联系客服添加店铺"),
        COMMISSION_MIN_MONEY("1103","想抽佣金下单金额不能小于100元"),
        NOT_IN_TIME_Football("1104","未在规定时间内不能下单"+"\n"+"☞温馨提示:下单时间为"+"\n"+"周一至周五09:00-23:50"+"\n"+"周六周日09:00-00:50"),
        NOT_IN_TIME_Basketball("1105","未在规定时间内不能下单"+"\n"+"☞温馨提示:下单时间为"+"\n"+"周一二五09:00-23:50"+"\n"+"周三周四07:30-23:50"+"\n"+"周六周日09:00-00:50"),
        PRIZEING("1106","开奖处理中"),
        SUBMIT_ORDER_MATCH_NUM_REQUIRE("1107","至少选择一场比赛"),
        MATCH_NUM_LIMIT("1108","选择比赛不能超过14场")
	    ;
	    //状态
		private String code;
		// 错误描述
		private String msg;
			
		private ApiJsonResultEnum(String code, String msg) {
			this.code=code;
			this.msg = msg;
		}

		public static ApiJsonResultEnum queryByName(String name) {
			ApiJsonResultEnum[] apiJsonResultEnums = ApiJsonResultEnum.values();
		    for (ApiJsonResultEnum apiJsonResultEnum : apiJsonResultEnums) {
				if(apiJsonResultEnum.name().equals(name)){
					return apiJsonResultEnum;
				}
			}
			return null;
		}
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		
}
