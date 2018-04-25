package com.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cheyue.key.service.Key;


/**
 * @author MingJun_Guo
 * @Mail:guomingjun1990@126.com
 * @创建日期：2014年2月26日 上午10:10:34
 * 
 * @类说明：全局常量类
 */
public class CommonConstant {


	/**
	 * 系统DES密钥相关常量
	 */
	public static final String DES_KEY_DEFAULT = Key.getKey();

	/**
	 * 系统参数字典前缀
	 */
	public static final String SYS_DICTIONARY_PREFIX = "SYS_";

	/**
	 * 业务参数字典前缀
	 */
	public static final String BUS_DICTIONARY_PREFIX = "BUS_";

	public static final String SYS_BASE_DICTIONARY_KEY = "SYS_BASE_DICTIONARY_KEY";

	/**
	 * 系统标志位
	 */
	// 表示不可编辑
	public static final Character FLAG_IMMUTABLE = '0';
	// 表示可编辑
	public static final Character FLAG_VARIABLE = '1';

	public static final String SESSION_USER_TIMEOUT = "1800";

	/**
	 * Session中保存的用户信息
	 */
	public static final String SESSION_USER = "loginUser";

	/**
	 * Session中保存的用户手机号
	 */
	public static final String SESSION_PHONENUM = "SESSION_PHONENUM";

	// 修改手机号码的缓存
	public static final String USERINFOMATION_UPDATEPHONE = "USERINFOMATION_UPDATEPHONE";

	// 修改邮箱的x缓存
	public static final String USERINFOMATION_UPDATEEMAIL = "USERINFOMATION_UPDATEEMAIL";

	// 忘记交易密码缓存
	public static final String SESSION_USERFINDPAY = "SESSION_USERFINDPAY";

	// 忘记登录密码缓存
	public static final String SESSION_USERFINDPWD = "SESSION_USERFINDPWD";

	// 发送手机验证码
	public static final String SEND_PHONECODE = "SESSION_PHONECODE";

	// 发送原手机验证码
	public static final String SEND_OLD_PHONECODE = "SEND_OLD_PHONECODE";

	// 发送邮箱验证码
	public static final String SEND_EMAILCODE = "SEND_EMAILCODE";

	/**
	 * 用户登录session验证码(前端存储缓存)
	 */
	public static final String SESSION_USER_VERIFYCODE = "loginVerifyCode";

	/**
	 * servletcontext中存储的在线用户列表
	 */
	public static final String SERVLETCONTEXT_ONLINE_USER = "onlineUserList";

	/**
	 * 字符编码
	 */
	public static final String UTF8 = "UTF-8";

	/*
	 * 日志常量
	 */
	// 系统日志文件中Dao层发生异常时描述信息
	public static final String SYSTEM_LOG_DAO_MESSAGE = "Dao错误";
	// 系统日志文件中Service层发生异常时描述信息
	public static final String SYSTEM_LOG_SERVICE_MESSAGE = "Service错误";
	// 系统日志文件中Controller层发生异常时描述信息
	public static final String SYSTEM_LOG_CONTROLLER_MESSAGE = "Controller错误";
	// 系统日志文件中其他地方发生异常时描述信息
	public static final String SYSTEM_LOG_OTHER_MESSAGE = "其他错误";
	// 系统日志文件定位类文件描述符
	public static final String SYSTEM_LOG_CLASS_POSITION = "className:";
	// 系统日志文件定位类方法描述符
	public static final String SYSTEM_LOG_METHOD_POSITION = "methodName:";
	// 系统日志文件定位类行号描述符
	public static final String SYSTEM_LOG_LINENUMBER_POSITION = "lineNumber:";
	// 系统日志文件定位具体异常信息描述符
	public static final String SYSTEM_LOG_ERRORTYPE_POSITION = "errorDescription:";
	// 显示给用户的解决应用错误的方式描述信息
	public static final String SYSTEM_LOG_CONTACT_DESCRIPTION = "应用程序内部错误,请与技术人员联系!";
	// 系统日志文件前缀名称
	public static final String SYSTEM_LOG_PREFIX = "cheyue<xntz>";
	// 系统日志文件只记录拦截包发生的异常信息
	public static final String SYSTEM_LOG_INTERCEPTOR_PACKAGE = "com.xntz";
	// 定位Dao层发生异常常量
	public static final String SYSTEM_LOG_USER_DAO = "Dao";
	// 定位Service层发生异常常量
	public static final String SYSTEM_LOG_USER_SERVICE = "Service";
	// 定位Controller层发生异常常量
	public static final String SYSTEM_LOG_USER_CONTROLLER = "Controller";
	// 定位其他地方发生异常常量
	public static final String SYSTEM_LOG_USER_OTHER = "Other";

	/**
	 * 日期常量
	 */
	// 简单年月日日期格式
	public static final String DATE_SHORT_SIMPLE_FORMAT = "yyyyMMdd";
	// 年月日日期格式
	public static final String DATE_SHORT_FORMAT = "yyyy-MM-dd";
	// 中文年月日日期格式
	public static final String DATE_SHORT_CHN_FORMAT = "yyyy年MM月dd日";
	// 年月日时日期格式
	public static final String DATE_WITHHOUR_FORMAT = "yyyy-MM-dd HH";
	// 中文年月日时日期格式
	public static final String DATE_WITHHOUR_CHN_FORMAT = "yyyy年MM月dd日 HH";
	// 年月日时分日期格式
	public static final String DATE_WITHMINUTE_FORMAT = "yyyy-MM-dd HH:mm";
	// 中文年月日时分日期格式
	public static final String DATE_WITHMINUTE_CHN_FORMAT = "yyyy年MM月dd日 HH:mm";
	// 年月日时分秒日期格式
	public static final String DATE_WITHSECOND_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// 中文年月日时分秒日期格式
	public static final String DATE_WITHSECOND_CHN_FORMAT = "yyyy年MM月dd日 HH:mm:ss";
	// 年月日时分秒毫秒日期格式
	public static final String DATE_WITHMILLISECOND_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	// 中文年月日时分秒毫秒日期格式
	public static final String DATE_WITHMILLISECOND_CHN_FORMAT = "yyyy年MM月dd日 HH:mm:ss.S";
	// 中文年月日时分日期格式
	public static final String DATE_TMDHMS_CHN_FORMAT = "yyyy年MM月dd日 HH时mm分ss秒";
	// 年月日时分秒日期格式a
	public static final String DATE_WITHMILLISECOND_CZD_FORMAT = "yyyy/MM/dd HH:mm:ss";

	/** 标的状态：已发布 */
	public static final int BORROW_STATUS_PUBLISHED = 0;
	/** 标的状态：已初审 */
	public static final int BORROW_STATUS_WAITING = 1;
	/** 标的状态：投标中 */
	public static final int BORROW_STATUS_TENDERING = 2;
	/** 标的状态：已满标 */
	public static final int BORROW_STATUS_FULL = 3;
	/** 标的状态：还款中 */
	public static final int BORROW_STATUS_REPAYING = 4;
	/** 标的状态：已还款 */
	public static final int BORROW_STATUS_REPAYED = 5;
	/** 标的状态：已流标 */
	public static final int BORROW_STATUS_FLOWED = 6;

	/** 标的方式:担保借款 */
	public static final int BORROW_WAY_GUARANTEE = 1;
	/** 标的方式:信用借款 */
	public static final int BORROW_WAY_CREDIT = 2;
	/** 标的方式:押付借款 */
	public static final int BORROW_WAY_OSHITSUKE = 3;
	/** 标的方式:净宝借款 */
	public static final int BORROW_WAY_NET_TREASURE = 4;
	/** 标的方式:安居宝借款 */
	public static final int BORROW_WAY_AN_JU_BAO = 5;
	/** 标的方式:收益权转让 */
	public static final int BORROW_WAY_USUFRUCT_TRANSFER = 6;
	/** 标的方式:秒标活动 */
	public static final int BORROW_WAY_SECOND_BORROW = 7;
	/** 标的方式:活期宝 */
	public static final int BORROW_WAY_DUE_ON_DEMAND = 8;
	/** 标类型：0-普通标 1-个人专用标 2-秒标 */
	public static final int BORRWO_TYPE_NORMAL = 0;
	public static final int BORRWO_TYPE_EXCLUSIVE = 1;
	public static final int BORRWO_TYPE_SECONDS = 2;
	/** excitationType,奖励利率类型 ;0-无奖励,1-新手标奖励,2-满标奖励,3-加息宝 */
	public static final int BORROW_EXCITATION_TYPE_NORMAL = 0;
	public static final int BORROW_EXCITATION_TYPE_NEW_USER = 1;
	public static final int BORROW_EXCITATION_TYPE_FULL = 2;
	public static final int BORROW_EXCITATION_TYPE_INTEREST = 3;
	/** enable 红包状态：0、不可用 1、可用 2、已使用 3、已过期 */
	public static final int RED_PACKET_ENABLE_FREEZE = 0;
	public static final int RED_PACKET_ENABLE_NORMAL = 1;
	public static final int RED_PACKET_ENABLE_USER = 2;
	public static final int RED_PACKET_ENABLE_OVERDUE = 3;

	/**
	 * 渠道用户接入标识：QQ
	 */
	public static final String CHANNEL_USER_MARK_QQ = "";
	/**
	 * 渠道用户接入标识：财经道
	 */
	public static final String CHANNEL_USER_MARK_CJD = "";

	/**
	 * 短信内容签名
	 */
	public static final String SMSSIGN = "【汇理财】";
	public static final String RETURNSTATUS = "returnstatus";
	public static final String RESULT = "Result";
	public static final String SUCCESS = "Success";
	public static final String FAILD = "Faild";
	public static final String WELCOME = "欢迎注册汇理财";

	/**
	 * 网站注册地址
	 */
	public static final String LOCALHOST = "http://www.huilc.cn";

	public static final String BUILDINGADDRESS = "buildingAddress";

	public static final String APPSHAREINFO = "appShareInfo";
	/**
	 * 发送邮箱的标题
	 */
	public static final String UPDATE_PASSWORD_NOTICE = "密码修改成功的通知";
	public static final String EMAIL_CODE = "请查收你的验证码";
	public static final String UPDATE_LOGIN_PASSWORD = "您正在找回登录密码，请查收你的验证码";
	public static final String MAKE_SURE_EMAIL_CODE = "您正在绑定邮箱,请查收你的验证码";
	public static final String UPDATE_TIXIAN_PASSWORD = "您正在找回支付密码，请查收你的验证码";
	public static final String INVEST = "投标成功的通知";
	public static final String RECHARGE = "您已充值成功";
	public static final String CASE = "提现审核的通知";

	/**
	 * 3分钟
	 */
	public static final int THREE_MINUTES = 60 * 3;

	/**
	 * 周年庆活动开始时间
	 */
	public static final String ANNIVERSARY_BEGINDATE = "2015-12-07";

	/**
	 * 微信token
	 */
	// public static AccessToken accessToken;

	/**
	 * 微信jsticket
	 */
	// public static String WECHAT_JSTICKET = "";

	/**
	 * 周年庆活动开始时间
	 */
	public static final String SEP_BEGIN = "2015-12-01";

	/* 佣金表相关常量 */
	/** 投资 */
	public static final int BROKERAGE_TYPE_BORROW = 1;
	/** 贷款 */
	public static final int BROKERAGE_TYPE_LOAN = 2;
	/** 工资 */
	public static final int BROKERAGE_TYPE_WAGE = 3;

	/** 未结 */
	public static final int BROKERAGE_STATUS_UNSETTLE = 0;
	/** 已结 */
	public static final int BROKERAGE_STATUS_SETTLE = 1;
	/** 已结 */
	public static final String ACTIVITY_START_TIME = "2015-11-16 23:59:59";
	public static final String ACTIVITY_END_TIME = "2016-03-27 23:59:59";

	/** 【理财师推首投活动】注册的用户首次投资五千元及以上，其理财师可获得一定金额的投资红包 */
	public static final String FIRSTTOCFP_STARTDATE = "2015-11-18 00:00:00";
	public static final String FIRSTTOCFP_ENDDATE = "2015-12-31 23:59:59";

	/** 注册送千元 */
	public static final String GIFTPACKRREGISTER_STARTDATE = "2015-12-01 00:00:00";

	/**
	 * 注册送红包
	 */
	public static final Integer RED_RULE_TYPE1 = 1;

	/**
	 * 邀请好友注册并投资送红包
	 */
	public static final Integer RED_RULE_TYPE2 = 2;

	/**
	 * 理财师赠送粉丝的红包
	 */
	public static final Integer RED_RULE_TYPE3 = 3;

	/**
	 * 申请贷款上传资料送红包
	 */
	public static final Integer RED_RULE_TYPE4 = 4;
	/** 绑卡奖励红包 */
	public static final Integer RED_RULE_TYPE5 = 5;
	/** 首充奖励红包 */
	public static final Integer RED_RULE_TYPE6 = 6;
	/** 首投奖励送红包 */
	public static final Integer RED_RULE_TYPE7 = 7;
	/** 银牌升级红包 */
	public static final Integer RED_RULE_TYPE8 = 8;
	/** 金牌升级红包 */
	public static final Integer RED_RULE_TYPE9 = 9;
	/** 钻石升级红包 */
	public static final Integer RED_RULE_TYPE10 = 10;
	/** 铜牌会员生日红包 */
	public static final Integer RED_RULE_TYPE11 = 11;
	/** 银牌会员生日红包 */
	public static final Integer RED_RULE_TYPE12 = 12;
	/** 金牌会员生日红包 */
	public static final Integer RED_RULE_TYPE13 = 13;
	/** 钻石会员生日红包 */
	public static final Integer RED_RULE_TYPE14 = 14;
	/** 10元红包豪礼 */
	public static final Integer RED_RULE_TYPE15 = 15;
	/** 20元红包豪礼 */
	public static final Integer RED_RULE_TYPE16 = 16;
	/** 50元红包豪礼 */
	public static final Integer RED_RULE_TYPE17 = 17;
	/** 100元红包豪礼 */
	public static final Integer RED_RULE_TYPE18 = 18;
	/** 500元红包豪礼 */
	public static final Integer RED_RULE_TYPE19 = 19;

	/** 银行卡合作商类别(快钱) */
	public static String CONSTATYPE_QUICKPAY = "99bill";
	/** 银行卡合作商类别_融宝 */
	public static String CONSTATYPE_REAPAL = "reapal";

	/** 证件类型 */
	public static final String IDTYPE = "0";

	/** 卡信息验证（需要发送动态码） */
	public static final String IND_AUTH_TOKEN = "indAuthToken";

	public static final String EXTERNALREF_NUMBER_SESSION = "externalrefNumber";

//	/**
//	 * 快钱支付根据应答码返回应答码错误信息
//	 * 
//	 * @param responseCode
//	 * @return
//	 */
//	public static String getQuickPayErrorCode(String responseCode) {
//		String returnMsg = "";
//		if (!StringUtil.isEmpty(responseCode)) {
//			if ("00".equals(responseCode)) {
//				returnMsg = "交易成功";
//			} else {
//				String msg = PropertyUtil.getProperty(responseCode, "messageInfo.properties");
//				try {
//					if (!StringUtil.isEmpty(msg)) {
//						msg = new String(msg.getBytes("ISO8859-1"), "UTF-8");
//						returnMsg = msg + "(错误代码：" + responseCode + ")";
//					}
//				} catch (Exception e) {
//					log.info("getQuickPayErrorCode responseCode:" + responseCode + ", " + e.getMessage());
//					return "系统异常，如有其他疑问请联系客服4009660198（错误代码：" + responseCode + ")";
//				}
//			}
//		}
//		return returnMsg;
//	}
//	// 快钱支付 END

	/* 微信活动相关常量 */
	/** 微信活动状态-开始 */
	public static final int WECHAT_ACTVITY_STATUS_STAR = 1;
	/** 微信活动状态-停止 */
	public static final int WECHAT_ACTVITY_STATUS_STOP = 2;
	/** 微信订单状态-新订单/未支付 */
	public static final int WECHAT_ORDER_STATUS_NEW = 0;
	/** 微信订单状态-已支付 */
	public static final int WECHAT_ORDER_STATUS_PAY_SUCCESS = 1;
	/** 微信订单状态-已使用 */
	public static final int WECHAT_ORDER_STATUS_USER = 3;
	/** 微信订单状态-部分使用 */
	public static final int WECHAT_ORDER_STATUS_PORTION_USER = 4;
	/** 微信订单状态-超时 */
	public static final int WECHAT_ORDER_STATUS_OUTTIME = 5;
	/** 微信订单状态-取消 */
	public static final int WECHAT_ORDER_STATUS_CANCEL = 6;
	/** 微信订单状态-失败 */
	public static final int WECHAT_ORDER_STATUS_PAY_FAIULRE = 7;

	// 盒子支付结果状态,1 处理成功；-1处理失败
	/** 盒子支付结果状态, 处理成功 */
	public static final int CASH_BOX_RESULT_SUCCESS = 1;
	/** 盒子支付结果状态, 处理失败 */
	public static final int CASH_BOX_RESULT_FAILURE = -1;

	// 盒子支付订单类型 ，磁条卡 31：消费，32：冲正，33：撤销，;34：撤销冲正；
	// IC 卡： 51：消费，52：冲正，53：撤销，54：撤销冲正
	/** 盒子支付订单类型 ，磁条卡 消费 */
	public static final int CASH_BOX_ORDER_TYPE_TRAD = 31;
	/** 盒子支付订单类型 ，磁条卡 冲正； */
	public static final int CASH_BOX_ORDER_TYPE_CORRECT = 32;
	/** 盒子支付订单类型 ，磁条卡 撤销； */
	public static final int CASH_BOX_ORDER_TYPE_UNDO = 33;
	/** 盒子支付订单类型 ，磁条卡 撤销冲正； */
	public static final int CASH_BOX_ORDER_TYPE_CORRECT_UNDO = 34;
	/** 盒子支付订单类型 ，IC卡 消费 */
	public static final int CASH_BOX_ORDER_TYPE_IC_TRAD = 51;
	/** 盒子支付订单类型 ，IC卡 冲正； */
	public static final int CASH_BOX_ORDER_TYPE_IC_CORRECT = 52;
	/** 盒子支付订单类型 ，IC卡 撤销； */
	public static final int CASH_BOX_ORDER_TYPE_IC_UNDO = 53;
	/** 盒子支付订单类型 ，IC卡 撤销冲正； */
	public static final int CASH_BOX_ORDER_TYPE_IC_CORRECT_UNDO = 54;
	// 盒子支付订单状态 ，0 未支付；1 交易成功；2 交易失败 3 购买成功 4 购买失败 5未知结果；
	/** 盒子支付订单状态 ，0 未支付； */
	public static final int CASH_BOX_ORDER_STATUS_NEW = 0;
	/** 盒子支付订单状态 ，1 交易成功 */
	public static final int CASH_BOX_ORDER_STATUS_SUCCESS = 1;
	/** 盒子支付订单状态 ，2 交易失败 */
	public static final int CASH_BOX_ORDER_STATUS_FAILURE = 2;
	/** 盒子支付订单状态 ，3 购买成功 */
	public static final int CASH_BOX_ORDER_STATUS_PRODUCT_BOUGHT = 3;
	/** 盒子支付订单状态 ，4 购买失败-系统异常导致的，需要定位异常的，确定充值成功不确定是否购买成功，例如：投资死锁 */
	public static final int CASH_BOX_ORDER_STATUS_PRODUCT_PAY_FAILURE = 4;
	/** 盒子支付订单状态 ，5 未知结果 */
	public static final int CASH_BOX_ORDER_STATUS_UNKNOWN = 5;
	/** 盒子支付订单状态 ，6 购买失败-购买不成功，需要重新购买的，确定充值成功确定没有购买，例如：标的已满、投标金额不在标的允许投资范围内等 */
	public static final int CASH_BOX_ORDER_STATUS_REPAY = 6;

	public static final String CASH_BOX_FLAG = "cashBox";

	// 产品分组类别，10 推荐位 ，20产品位1，21产品位2，22产品位3，23产品位4，24产品位5
	public static final int BORROW_GROUP_RECOMMEND = 10;
	public static final int BORROW_GROUP_PRODUCT_ONE = 20;
	public static final int BORROW_GROUP_PRODUCT_TWO = 21;
	public static final int BORROW_GROUP_PRODUCT_THREE = 22;
	public static final int BORROW_GROUP_PRODUCT_FOUR = 23;
	public static final int BORROW_GROUP_PRODUCT_FIVE = 24;
	// 产品分组集合
	public static final List<Integer> BORROW_GROUP_LIST = Arrays
			.asList(new Integer[] { BORROW_GROUP_RECOMMEND, BORROW_GROUP_PRODUCT_ONE, BORROW_GROUP_PRODUCT_TWO,
					BORROW_GROUP_PRODUCT_THREE, BORROW_GROUP_PRODUCT_FOUR, BORROW_GROUP_PRODUCT_FIVE });

	/** 搜房网 */
	public static final String SOFANG = "soFang";

	/** 海城创投 */
	public static final String HAICHENG = "haiCheng";

	/** 用户任务状态，0 未获取 1已获取 2已过期 3已完成 */
	public static final int USER_TASK_STATUS_NOT_GET = 0;
	public static final int USER_TASK_STATUS_GET = 1;
	public static final int USER_TASK_STATUS_TIME_OUT = 2;
	public static final int USER_TASK_STATUS_FINISHED = 3;

	/** 森林城市1元抽奖活动注册 */
	public static final String FORESTSTART = "2016-06-06 00:00:00";

	/* 会员等级 */
	/** 会员等级-白铁 */
	public static final int USER_LEVEL_IRON = 0;
	/** 会员等级-青铜 */
	public static final int USER_LEVEL_BRONZE = 1;
	/** 会员等级-白银 */
	public static final int USER_LEVEL_SILVER = 2;
	/** 会员等级-黄金 */
	public static final int USER_LEVEL_GOLD = 3;
	/** 会员等级-钻石 */
	public static final int USER_LEVEL_DIAMOND = 4;

	public static Map<Integer, String> userLevelMap = new HashMap<Integer, String>();

	static {
		userLevelMap.put(USER_LEVEL_IRON, "新用户");
		userLevelMap.put(USER_LEVEL_BRONZE, "铜牌会员");
		userLevelMap.put(USER_LEVEL_SILVER, "银牌会员");
		userLevelMap.put(USER_LEVEL_GOLD, "金牌会员");
		userLevelMap.put(USER_LEVEL_DIAMOND, "钻石会员");
	}

	/**
	 * 体验金
	 */
	public static final double TESTSUM = 10000;

	/* 加息券常量 */
	/** 加息券状态：未使用 */
	public static final int INTEREST_COUPON_STATUS_NEW = 0;
	/** 加息券状态：已使用 */
	public static final int INTEREST_COUPON_STATUS_USE = 1;
	/** 加息券状态：已奖励 */
	public static final int INTEREST_COUPON_STATUS_REWARD = 2;
	/** 加息券状态：已过期 */
	public static final int INTEREST_COUPON_STATUS_TIMEOUT = 3;
	/* 加息券常量 end */

	/** 8月理财师拉新奖励5元 */
	public static final String CFP_ACTIVITY_START_TIME = "2016-08-27 00:00:00";
	public static final String CFP_ACTIVITY_END_TIME = "2016-09-27 23:59:59";

	/** helj hlej_url.smsVerifyCodeHFive */
	/** 平台 （汇理财） */
	public static final String SMS_JLEJ_INTERFACE_SF = "hlc";
	/** 短信验证码类型 （注册） */
	public static final String SMS_JLEJ_INTERFACE_VERIFYTYPE = "register";
	public static final String SMS_JLEJ_INTERFACE_VERIFYTYPE_FIND_PWD = "findPWD";
	/** 短信验证码类型 （修改帐号） */
	public static final String SMS_JLEJ_INTERFACE_VERIFYTYPE_MODIFYPHONE = "modifyPhone";

	public static final String SMS_JLEJ_INTERFACE_DATASOURCE = "1";

	/** 元旦理财师红包活动邀请好友投资奖励金额 */
	public static final Double CFP_AWARD_AMOUNT = 10.0;
	/** 元旦理财师红包活动邀请好友投资获得红包类型 */
	public static final String CFP_AWARD_REDTYPE = "29";
	/** 元旦理财师红包活动活动编号 */
	public static final String CFP_AWARD_ACTIVITYNUM = "1478585790107";
	/** 元旦理财师红包活动开始时间 */
	public static final String CFP_AWARD_START_TIME = "2017-01-02 00:00:00";
	/** 元旦理财师红包活动结束时间 */
	public static final String CFP_AWARD_END_TIME = "2017-02-15 23:59:59";

	/** 楼盘活动用户扫码手机号码 */
	public static final String LPHD_USER_PHONENUM = "lphdUserPhonenum";

	/**
	 * 转入存钱罐
	 */
	public static final int SWITCH_TO_BOX = 1;

	/**
	 * 转出存钱罐
	 */
	public static final int ROLL_OUT_BOX = 2;

	public static final String SESSION_KEY = "uky";

	/** 充值类型—联迪pos支付 */
	public static final int RECHARGE_TYPE_ALLINPAYPOS = 8;
	/** 充值类型—融宝快捷支付-微信端 */
	public static final int RECHARGE_TYPE_REAPAL_WECHAT = 9;
	/** 充值类型—融宝快捷支付-web端 */
	public static final int RECHARGE_TYPE_REAPAL_WEB = 10;
	/** 充值类型—融宝快捷支付-app端 */
	public static final int RECHARGE_TYPE_REAPAL_APP = 11;
	/** 充值类型—融宝快捷支付-网银充值 */
	public static final int RECHARGE_TYPE_REAPAL_BANK = 12;

	/** 充值结果—未支付 */
	public static final int RECHARGE_RESULT_NOPAY = -1;
	/** 充值结果—处理中 */
	public static final int RECHARGE_RESULT_PAYING = 0;
	/** 充值结果—支付成功 */
	public static final int RECHARGE_RESULT_PAYSUC = 1;
	/** 充值结果—支付失败 */
	public static final int RECHARGE_RESULT_PAYFAI = 2;

	/** 资金记录-交易类型-充值 */
	public static final int FUND_TRADETYPE_RECHARGE = 1;
	/** 资金记录-交易类型-提现 */
	public static final int FUND_TRADETYPE_WITHDRAW = 2;

	/** 资金记录-状态-失败 */
	public static final int FUND_STATUS_FAILURE = -1;
	/** 资金记录-状态-等待 */
	public static final int FUND_STATUS_WAIT = 0;
	/** 资金记录-状态-成功 */
	public static final int FUND_STATUS_SUCCESS = 1;
}
