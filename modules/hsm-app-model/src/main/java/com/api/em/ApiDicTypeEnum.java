package com.api.em;


/**
 * 数据字典分类
 * 对应到 分类数据类，或者分类数据表中的数据
 * {@link ApiDicDataEnum.java}
 * @author shenhs
 *
 */
public enum ApiDicTypeEnum {
	
	BASKETBALL_TYPE, //篮球玩法类型
	FOOTBALL_TYPE, //足球玩法类型
	GAME_TYPE,//游戏类型
	PLAY_TYPE,//比赛类型
	DRAWERS_STATUS,//出票状态
	USER_STATUS,//用户状态
	MONEY_ASPECT,//钱的方向（+：收入；-：支出）
	MONEY_TYPE,//钱的类型（0、现金；1、红包）
	CAPITAL_OPT_TYPE,//操作的类型（0：充值；1：投注支出；2：奖金发放；）
	RECHARGE_WAY, //充值的渠道（0：支付宝；1：微信；3：银联；）
	BANK, //银行（1、中国银行;2、农业银行；3、工商银行；4、建设银行；5、交通银行；6、广发银行；7、杭州银行；8、浦东发展银行；9、光大银行；10、民生银行；11、平安银行；12、中信银行；13、邮政银行;)
	DISTILL_TYPE,//提现状态(1.系统已收到请求 2.正在处理 3.已完成 4.系统转账失败)
	ORDER_STATUS,//订单状态(1、出票中；2：已出票；3：出票失败；4：待开奖；5：已中奖；6：未中奖；7:出票委托失败；)

}
