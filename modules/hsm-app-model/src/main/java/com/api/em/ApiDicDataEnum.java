package com.api.em;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类数据
 * @author xk
 *
 */
public enum ApiDicDataEnum {
	 //玩法类型ID（1、胜负；2、单关让球胜负；3、串关让球胜负；4、胜分差；5、大小分；6、混合过关；）
	 MNL("1","胜负",ApiDicTypeEnum.BASKETBALL_TYPE),
	 SINGLE_HDC("2","单关让球胜负",ApiDicTypeEnum.BASKETBALL_TYPE),
	 MUTIL_HDC("3","串关让球胜负",ApiDicTypeEnum.BASKETBALL_TYPE),
	 WNM("4","胜分差",ApiDicTypeEnum.BASKETBALL_TYPE),
	 HILO("5","大小分",ApiDicTypeEnum.BASKETBALL_TYPE),
	 BASKETBALL_HHGG("6","混合过关",ApiDicTypeEnum.BASKETBALL_TYPE),
     //玩法类型ID（1、胜平负；2、让球胜平负；3、比分；4、总进球数；5、半全称；6、混合过关；7、热门单关）
     HAD("1","胜平负",ApiDicTypeEnum.FOOTBALL_TYPE),
     HHAD("2","让球胜平负",ApiDicTypeEnum.FOOTBALL_TYPE),
     CRS("3","比分",ApiDicTypeEnum.FOOTBALL_TYPE),
     TTG("4","总进球数",ApiDicTypeEnum.FOOTBALL_TYPE),
     HAFU("5","半全场胜平负",ApiDicTypeEnum.FOOTBALL_TYPE),
     FOOTBALL_HHGG("6","混合过关",ApiDicTypeEnum.FOOTBALL_TYPE),
     SINGLE("7","热门单关",ApiDicTypeEnum.FOOTBALL_TYPE),
     //彩种类型（1、竞彩足球;2、竞彩篮球;3、大乐透;4、任选9; 5、胜负彩;）
     FOOTBALL("1","竞彩足球",ApiDicTypeEnum.GAME_TYPE),
     BASKETBALL("2","竞彩篮球",ApiDicTypeEnum.GAME_TYPE),
     LOTTO("3","大乐透",ApiDicTypeEnum.GAME_TYPE),
     WILO_9("4","任选9",ApiDicTypeEnum.GAME_TYPE),
     WILO_14("5","胜负彩",ApiDicTypeEnum.GAME_TYPE),
     //比赛类型（1、已结束;2、全部;3、我投注;）
     RESULtType("1","已结束",ApiDicTypeEnum.PLAY_TYPE),
     ALLType("2","全部",ApiDicTypeEnum.PLAY_TYPE),
     MYType("3","我投注",ApiDicTypeEnum.PLAY_TYPE),
     //出票状态
     DRAWERS_STATUS_WAIT("0","未出票",ApiDicTypeEnum.DRAWERS_STATUS),
     DRAWERS_STATUS_ING("1","出票中",ApiDicTypeEnum.DRAWERS_STATUS),
     DRAWERS_STATUS_FINISH("2","已出票",ApiDicTypeEnum.DRAWERS_STATUS),
     //用户状态
 	 VERI_DODING("1","验证中",ApiDicTypeEnum.USER_STATUS),
 	 VERI_SUCCESS("2","验证成功",ApiDicTypeEnum.USER_STATUS),
 	 VERI_FAIL("3","验证失败",ApiDicTypeEnum.USER_STATUS),
 	 REG_SUCCESS("4","注册成功",ApiDicTypeEnum.USER_STATUS),
 	 REG_FAIL("5","注册失败",ApiDicTypeEnum.USER_STATUS),
 	 //钱的方向（+：收入；-：支出）
 	 MONEY_ASPECT_IN("+","收入",ApiDicTypeEnum.MONEY_ASPECT),
 	 MONEY_ASPECT_OUT("-","支出",ApiDicTypeEnum.MONEY_ASPECT),
 	 //钱的类型（0、现金；1、红包）
 	 MONEY_TYPE_CASH("0","现金",ApiDicTypeEnum.MONEY_TYPE),
 	 MONEY_TYPE_RED("1","红包",ApiDicTypeEnum.MONEY_TYPE),
 	 //操作的类型（0：充值；1：投注支出；2：奖金发放；）
 	 OPT_TYPE_RECHARGE("0","充值",ApiDicTypeEnum.CAPITAL_OPT_TYPE),
 	 OPT_TYPE_GAMBLING("1","投注支出",ApiDicTypeEnum.CAPITAL_OPT_TYPE),
 	 OPT_TYPE_GRANT("2","奖金发放",ApiDicTypeEnum.CAPITAL_OPT_TYPE),
 	 //充值的渠道（0：支付宝；1：微信；2：银联；）
 	 RECHARGE_WAY_ALIPAY("0","支付宝",ApiDicTypeEnum.RECHARGE_WAY),
	 RECHARGE_WAY_WECHAT("1","微信",ApiDicTypeEnum.RECHARGE_WAY),
	 RECHARGE_WAY_UNIONPAY("2","银联",ApiDicTypeEnum.RECHARGE_WAY),
	 //银行（1、中国银行;2、农业银行；3、工商银行；4、建设银行；5、交通银行；6、广发银行；7、杭州银行；8、浦东发展银行；9、光大银行；10、民生银行；11、平安银行；12、中信银行；13、邮政银行;)
	 CHINABANK("1","中国银行","/static/bank/bank_1.png",ApiDicTypeEnum.BANK),
	 AGRICULTURAL("2","农业银行","/static/bank/bank_2.png",ApiDicTypeEnum.BANK),
	 ICBCBANK("3","工商银行","/static/bank/bank_3.png",ApiDicTypeEnum.BANK),
	 CONSTRUCTION("4","建设银行","/static/bank/bank_4.png",ApiDicTypeEnum.BANK),
	 CONMMUNICATI("5","交通银行","/static/bank/bank_5.png",ApiDicTypeEnum.BANK),
	 CUANGFA("6","广发银行","/static/image/bank_6.png",ApiDicTypeEnum.BANK),
	 HANGZHOU("7","杭州银行","/static/bank/bank_7.png",ApiDicTypeEnum.BANK),
	 PUDONG("8","浦东发展银行","/static/bank/bank_8.png",ApiDicTypeEnum.BANK),
	 EVERBRIGHT("9","光大银行","/static/bank/bank_9.png",ApiDicTypeEnum.BANK),
	 MINSHENG("10","民生银行","/static/bank/bank_10.png",ApiDicTypeEnum.BANK),
	 PINGAN("11","平安银行","/static/bank/bank_11.png",ApiDicTypeEnum.BANK),
	 CITIC("12","中信银行","/static/bank/bank_12.png",ApiDicTypeEnum.BANK),
	 POSTAL("13","邮政银行","/static/bank/bank_13.png",ApiDicTypeEnum.BANK),
	 STRAIT("14","海峡银行","/static/bank/bank_14.jpg",ApiDicTypeEnum.BANK),
	 CMB("15","招商银行","/static/bank/bank_15.jpg",ApiDicTypeEnum.BANK),
	 RCC("16","农村信用社","/static/bank/bank_16.jpg",ApiDicTypeEnum.BANK),
	 
	//提现状态(1.系统已收到请求 2.正在处理 3.已完成 4.系统转账失败)
	 RECEIVED("1","系统已收到请求",ApiDicTypeEnum.DISTILL_TYPE),
	 PROCESSING("2","正在处理中",ApiDicTypeEnum.DISTILL_TYPE),
	 DISTILL_SUCCESS("3","已完成",ApiDicTypeEnum.DISTILL_TYPE),
	 DISTILL_FAIL("4","系统转账失败",ApiDicTypeEnum.DISTILL_TYPE),
	 //订单状态：1、出票中；2：已出票；3：出票失败；4：待开奖；5：已中奖；6：未中奖；7:出票委托失败；
	 ORDER_STATUS_ING("1","出票中",ApiDicTypeEnum.ORDER_STATUS),
	 ORDER_STATUS_ED("2","已出票",ApiDicTypeEnum.ORDER_STATUS),
	 ORDER_STATUS_FAIL("3","出票失败",ApiDicTypeEnum.ORDER_STATUS),
	 ORDER_STATUS_WAIT("4","待开奖",ApiDicTypeEnum.ORDER_STATUS),
	 ORDER_STATUS_WIN("5","已中奖",ApiDicTypeEnum.ORDER_STATUS),
	 ORDER_STATUS_NO_WIN("6","未中奖",ApiDicTypeEnum.ORDER_STATUS),

	 
     ;
    
	
	//编码
	private String id;
	//名称
	private String name;
	//图标
	private String icon;
	//所属字典分类
	private ApiDicTypeEnum dicType;
	
	private ApiDicDataEnum(String id, String name, ApiDicTypeEnum dicType) {
		this.id = id;
		this.name = name;
		this.dicType = dicType;
	}
	private ApiDicDataEnum(String id, String name, String icon, ApiDicTypeEnum dicType) {
		this.id = id;
		this.name = name;
		this.icon=icon;
		this.dicType = dicType;
	}
	/**
	 * 获取上一个字典数据
	 * @param curr
	 * @return 如果存在同类型的字典数据则返回，否则返回null
	 * @author kai
	 * @since [1.1.0]
	 * @version [1.1.0, 2016年3月1日]
	 */
	public static ApiDicDataEnum getPreData(ApiDicDataEnum curr){
	    ApiDicDataEnum[] arr = ApiDicDataEnum.values();
	    int len = arr.length;
	    ApiDicDataEnum dicDataEnum = null;
	    for (int i = 0; i < len; i++) {
	        dicDataEnum = arr[i];
            if(dicDataEnum.equals(curr)){
                if(i > 0){
                    dicDataEnum = arr[i - 1];
                    if(dicDataEnum.getDicType().equals(curr.getDicType())){
                        return dicDataEnum;
                    }
                }
            }
        }
        return null;
	}
	
	/**
	 * 以键值对的形式返回同一类型的键值对
	 * @return
	 * @author shenhs
	 */
	public static List<ApiDicDataEnum> getDicDatasByDicType(ApiDicTypeEnum dicType) {
		List<ApiDicDataEnum> datas=new ArrayList<ApiDicDataEnum>();
		ApiDicDataEnum[] ApiDicDataEnums = ApiDicDataEnum.values();
		for (ApiDicDataEnum ApiDicDataEnum : ApiDicDataEnums) {
			if(ApiDicDataEnum.getDicType() != null && ApiDicDataEnum.getDicType().equals(dicType)){
				datas.add(ApiDicDataEnum);
			}
		}
		return datas;
	}
	
	/**
	 * 获取下一个字典数据
	 * @param curr
	 * @return 如果存在同类型的字典数据则返回，否则返回null
	 * @author kai
	 * @since [1.1.0]
	 * @version [1.1.0, 2016年3月1日]
	 */
	public static ApiDicDataEnum getNextData(ApiDicDataEnum curr){
	    ApiDicDataEnum[] arr = ApiDicDataEnum.values();
	    int len = arr.length;
	    ApiDicDataEnum dicDataEnum = null;
	    for (int i = 0; i < len; i++) {
	        dicDataEnum = arr[i];
	        if(dicDataEnum.equals(curr)){
	            if(i < len - 1){
	                dicDataEnum = arr[i + 1];
	                if(dicDataEnum.getDicType().equals(curr.getDicType())){
	                    return dicDataEnum;
	                }
	            }
	        }
	    }
	    return null;
	}
	
	public String getId() {
		return id;
	}
	
	public Integer getIntId() {
		return Integer.valueOf(id);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取某一类型下id所对应的enum对象
	 * @author xk
	 */
	public static ApiDicDataEnum getCommEnumById(ApiDicTypeEnum dicType, String id) {
		ApiDicDataEnum[] arr = ApiDicDataEnum.values();
		for (ApiDicDataEnum dicData : arr) {
			if(dicData.getDicType() != null && dicData.getDicType().equals(dicType) && dicData.getId().equals(id)){
				return dicData;
			}
		}
		return null;
	}

	public ApiDicTypeEnum getDicType() {
		return dicType;
	}

	public void setDicType(ApiDicTypeEnum dicType) {
		this.dicType = dicType;
	}
}
