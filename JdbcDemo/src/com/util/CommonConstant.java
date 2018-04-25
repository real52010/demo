package com.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cheyue.key.service.Key;


/**
 * @author MingJun_Guo
 * @Mail:guomingjun1990@126.com
 * @�������ڣ�2014��2��26�� ����10:10:34
 * 
 * @��˵����ȫ�ֳ�����
 */
public class CommonConstant {


	/**
	 * ϵͳDES��Կ��س���
	 */
	public static final String DES_KEY_DEFAULT = Key.getKey();

	/**
	 * ϵͳ�����ֵ�ǰ׺
	 */
	public static final String SYS_DICTIONARY_PREFIX = "SYS_";

	/**
	 * ҵ������ֵ�ǰ׺
	 */
	public static final String BUS_DICTIONARY_PREFIX = "BUS_";

	public static final String SYS_BASE_DICTIONARY_KEY = "SYS_BASE_DICTIONARY_KEY";

	/**
	 * ϵͳ��־λ
	 */
	// ��ʾ���ɱ༭
	public static final Character FLAG_IMMUTABLE = '0';
	// ��ʾ�ɱ༭
	public static final Character FLAG_VARIABLE = '1';

	public static final String SESSION_USER_TIMEOUT = "1800";

	/**
	 * Session�б�����û���Ϣ
	 */
	public static final String SESSION_USER = "loginUser";

	/**
	 * Session�б�����û��ֻ���
	 */
	public static final String SESSION_PHONENUM = "SESSION_PHONENUM";

	// �޸��ֻ�����Ļ���
	public static final String USERINFOMATION_UPDATEPHONE = "USERINFOMATION_UPDATEPHONE";

	// �޸������x����
	public static final String USERINFOMATION_UPDATEEMAIL = "USERINFOMATION_UPDATEEMAIL";

	// ���ǽ������뻺��
	public static final String SESSION_USERFINDPAY = "SESSION_USERFINDPAY";

	// ���ǵ�¼���뻺��
	public static final String SESSION_USERFINDPWD = "SESSION_USERFINDPWD";

	// �����ֻ���֤��
	public static final String SEND_PHONECODE = "SESSION_PHONECODE";

	// ����ԭ�ֻ���֤��
	public static final String SEND_OLD_PHONECODE = "SEND_OLD_PHONECODE";

	// ����������֤��
	public static final String SEND_EMAILCODE = "SEND_EMAILCODE";

	/**
	 * �û���¼session��֤��(ǰ�˴洢����)
	 */
	public static final String SESSION_USER_VERIFYCODE = "loginVerifyCode";

	/**
	 * servletcontext�д洢�������û��б�
	 */
	public static final String SERVLETCONTEXT_ONLINE_USER = "onlineUserList";

	/**
	 * �ַ�����
	 */
	public static final String UTF8 = "UTF-8";

	/*
	 * ��־����
	 */
	// ϵͳ��־�ļ���Dao�㷢���쳣ʱ������Ϣ
	public static final String SYSTEM_LOG_DAO_MESSAGE = "Dao����";
	// ϵͳ��־�ļ���Service�㷢���쳣ʱ������Ϣ
	public static final String SYSTEM_LOG_SERVICE_MESSAGE = "Service����";
	// ϵͳ��־�ļ���Controller�㷢���쳣ʱ������Ϣ
	public static final String SYSTEM_LOG_CONTROLLER_MESSAGE = "Controller����";
	// ϵͳ��־�ļ��������ط������쳣ʱ������Ϣ
	public static final String SYSTEM_LOG_OTHER_MESSAGE = "��������";
	// ϵͳ��־�ļ���λ���ļ�������
	public static final String SYSTEM_LOG_CLASS_POSITION = "className:";
	// ϵͳ��־�ļ���λ�෽��������
	public static final String SYSTEM_LOG_METHOD_POSITION = "methodName:";
	// ϵͳ��־�ļ���λ���к�������
	public static final String SYSTEM_LOG_LINENUMBER_POSITION = "lineNumber:";
	// ϵͳ��־�ļ���λ�����쳣��Ϣ������
	public static final String SYSTEM_LOG_ERRORTYPE_POSITION = "errorDescription:";
	// ��ʾ���û��Ľ��Ӧ�ô���ķ�ʽ������Ϣ
	public static final String SYSTEM_LOG_CONTACT_DESCRIPTION = "Ӧ�ó����ڲ�����,���뼼����Ա��ϵ!";
	// ϵͳ��־�ļ�ǰ׺����
	public static final String SYSTEM_LOG_PREFIX = "cheyue<xntz>";
	// ϵͳ��־�ļ�ֻ��¼���ذ��������쳣��Ϣ
	public static final String SYSTEM_LOG_INTERCEPTOR_PACKAGE = "com.xntz";
	// ��λDao�㷢���쳣����
	public static final String SYSTEM_LOG_USER_DAO = "Dao";
	// ��λService�㷢���쳣����
	public static final String SYSTEM_LOG_USER_SERVICE = "Service";
	// ��λController�㷢���쳣����
	public static final String SYSTEM_LOG_USER_CONTROLLER = "Controller";
	// ��λ�����ط������쳣����
	public static final String SYSTEM_LOG_USER_OTHER = "Other";

	/**
	 * ���ڳ���
	 */
	// �����������ڸ�ʽ
	public static final String DATE_SHORT_SIMPLE_FORMAT = "yyyyMMdd";
	// ���������ڸ�ʽ
	public static final String DATE_SHORT_FORMAT = "yyyy-MM-dd";
	// �������������ڸ�ʽ
	public static final String DATE_SHORT_CHN_FORMAT = "yyyy��MM��dd��";
	// ������ʱ���ڸ�ʽ
	public static final String DATE_WITHHOUR_FORMAT = "yyyy-MM-dd HH";
	// ����������ʱ���ڸ�ʽ
	public static final String DATE_WITHHOUR_CHN_FORMAT = "yyyy��MM��dd�� HH";
	// ������ʱ�����ڸ�ʽ
	public static final String DATE_WITHMINUTE_FORMAT = "yyyy-MM-dd HH:mm";
	// ����������ʱ�����ڸ�ʽ
	public static final String DATE_WITHMINUTE_CHN_FORMAT = "yyyy��MM��dd�� HH:mm";
	// ������ʱ�������ڸ�ʽ
	public static final String DATE_WITHSECOND_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// ����������ʱ�������ڸ�ʽ
	public static final String DATE_WITHSECOND_CHN_FORMAT = "yyyy��MM��dd�� HH:mm:ss";
	// ������ʱ����������ڸ�ʽ
	public static final String DATE_WITHMILLISECOND_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	// ����������ʱ����������ڸ�ʽ
	public static final String DATE_WITHMILLISECOND_CHN_FORMAT = "yyyy��MM��dd�� HH:mm:ss.S";
	// ����������ʱ�����ڸ�ʽ
	public static final String DATE_TMDHMS_CHN_FORMAT = "yyyy��MM��dd�� HHʱmm��ss��";
	// ������ʱ�������ڸ�ʽa
	public static final String DATE_WITHMILLISECOND_CZD_FORMAT = "yyyy/MM/dd HH:mm:ss";

	/** ���״̬���ѷ��� */
	public static final int BORROW_STATUS_PUBLISHED = 0;
	/** ���״̬���ѳ��� */
	public static final int BORROW_STATUS_WAITING = 1;
	/** ���״̬��Ͷ���� */
	public static final int BORROW_STATUS_TENDERING = 2;
	/** ���״̬�������� */
	public static final int BORROW_STATUS_FULL = 3;
	/** ���״̬�������� */
	public static final int BORROW_STATUS_REPAYING = 4;
	/** ���״̬���ѻ��� */
	public static final int BORROW_STATUS_REPAYED = 5;
	/** ���״̬�������� */
	public static final int BORROW_STATUS_FLOWED = 6;

	/** ��ķ�ʽ:������� */
	public static final int BORROW_WAY_GUARANTEE = 1;
	/** ��ķ�ʽ:���ý�� */
	public static final int BORROW_WAY_CREDIT = 2;
	/** ��ķ�ʽ:Ѻ����� */
	public static final int BORROW_WAY_OSHITSUKE = 3;
	/** ��ķ�ʽ:������� */
	public static final int BORROW_WAY_NET_TREASURE = 4;
	/** ��ķ�ʽ:���ӱ���� */
	public static final int BORROW_WAY_AN_JU_BAO = 5;
	/** ��ķ�ʽ:����Ȩת�� */
	public static final int BORROW_WAY_USUFRUCT_TRANSFER = 6;
	/** ��ķ�ʽ:��� */
	public static final int BORROW_WAY_SECOND_BORROW = 7;
	/** ��ķ�ʽ:���ڱ� */
	public static final int BORROW_WAY_DUE_ON_DEMAND = 8;
	/** �����ͣ�0-��ͨ�� 1-����ר�ñ� 2-��� */
	public static final int BORRWO_TYPE_NORMAL = 0;
	public static final int BORRWO_TYPE_EXCLUSIVE = 1;
	public static final int BORRWO_TYPE_SECONDS = 2;
	/** excitationType,������������ ;0-�޽���,1-���ֱ꽱��,2-���꽱��,3-��Ϣ�� */
	public static final int BORROW_EXCITATION_TYPE_NORMAL = 0;
	public static final int BORROW_EXCITATION_TYPE_NEW_USER = 1;
	public static final int BORROW_EXCITATION_TYPE_FULL = 2;
	public static final int BORROW_EXCITATION_TYPE_INTEREST = 3;
	/** enable ���״̬��0�������� 1������ 2����ʹ�� 3���ѹ��� */
	public static final int RED_PACKET_ENABLE_FREEZE = 0;
	public static final int RED_PACKET_ENABLE_NORMAL = 1;
	public static final int RED_PACKET_ENABLE_USER = 2;
	public static final int RED_PACKET_ENABLE_OVERDUE = 3;

	/**
	 * �����û������ʶ��QQ
	 */
	public static final String CHANNEL_USER_MARK_QQ = "";
	/**
	 * �����û������ʶ���ƾ���
	 */
	public static final String CHANNEL_USER_MARK_CJD = "";

	/**
	 * ��������ǩ��
	 */
	public static final String SMSSIGN = "������ơ�";
	public static final String RETURNSTATUS = "returnstatus";
	public static final String RESULT = "Result";
	public static final String SUCCESS = "Success";
	public static final String FAILD = "Faild";
	public static final String WELCOME = "��ӭע������";

	/**
	 * ��վע���ַ
	 */
	public static final String LOCALHOST = "http://www.huilc.cn";

	public static final String BUILDINGADDRESS = "buildingAddress";

	public static final String APPSHAREINFO = "appShareInfo";
	/**
	 * ��������ı���
	 */
	public static final String UPDATE_PASSWORD_NOTICE = "�����޸ĳɹ���֪ͨ";
	public static final String EMAIL_CODE = "����������֤��";
	public static final String UPDATE_LOGIN_PASSWORD = "�������һص�¼���룬����������֤��";
	public static final String MAKE_SURE_EMAIL_CODE = "�����ڰ�����,����������֤��";
	public static final String UPDATE_TIXIAN_PASSWORD = "�������һ�֧�����룬����������֤��";
	public static final String INVEST = "Ͷ��ɹ���֪ͨ";
	public static final String RECHARGE = "���ѳ�ֵ�ɹ�";
	public static final String CASE = "������˵�֪ͨ";

	/**
	 * 3����
	 */
	public static final int THREE_MINUTES = 60 * 3;

	/**
	 * ��������ʼʱ��
	 */
	public static final String ANNIVERSARY_BEGINDATE = "2015-12-07";

	/**
	 * ΢��token
	 */
	// public static AccessToken accessToken;

	/**
	 * ΢��jsticket
	 */
	// public static String WECHAT_JSTICKET = "";

	/**
	 * ��������ʼʱ��
	 */
	public static final String SEP_BEGIN = "2015-12-01";

	/* Ӷ�����س��� */
	/** Ͷ�� */
	public static final int BROKERAGE_TYPE_BORROW = 1;
	/** ���� */
	public static final int BROKERAGE_TYPE_LOAN = 2;
	/** ���� */
	public static final int BROKERAGE_TYPE_WAGE = 3;

	/** δ�� */
	public static final int BROKERAGE_STATUS_UNSETTLE = 0;
	/** �ѽ� */
	public static final int BROKERAGE_STATUS_SETTLE = 1;
	/** �ѽ� */
	public static final String ACTIVITY_START_TIME = "2015-11-16 23:59:59";
	public static final String ACTIVITY_END_TIME = "2016-03-27 23:59:59";

	/** �����ʦ����Ͷ���ע����û��״�Ͷ����ǧԪ�����ϣ������ʦ�ɻ��һ������Ͷ�ʺ�� */
	public static final String FIRSTTOCFP_STARTDATE = "2015-11-18 00:00:00";
	public static final String FIRSTTOCFP_ENDDATE = "2015-12-31 23:59:59";

	/** ע����ǧԪ */
	public static final String GIFTPACKRREGISTER_STARTDATE = "2015-12-01 00:00:00";

	/**
	 * ע���ͺ��
	 */
	public static final Integer RED_RULE_TYPE1 = 1;

	/**
	 * �������ע�ᲢͶ���ͺ��
	 */
	public static final Integer RED_RULE_TYPE2 = 2;

	/**
	 * ���ʦ���ͷ�˿�ĺ��
	 */
	public static final Integer RED_RULE_TYPE3 = 3;

	/**
	 * ��������ϴ������ͺ��
	 */
	public static final Integer RED_RULE_TYPE4 = 4;
	/** �󿨽������ */
	public static final Integer RED_RULE_TYPE5 = 5;
	/** �׳佱����� */
	public static final Integer RED_RULE_TYPE6 = 6;
	/** ��Ͷ�����ͺ�� */
	public static final Integer RED_RULE_TYPE7 = 7;
	/** ����������� */
	public static final Integer RED_RULE_TYPE8 = 8;
	/** ����������� */
	public static final Integer RED_RULE_TYPE9 = 9;
	/** ��ʯ������� */
	public static final Integer RED_RULE_TYPE10 = 10;
	/** ͭ�ƻ�Ա���պ�� */
	public static final Integer RED_RULE_TYPE11 = 11;
	/** ���ƻ�Ա���պ�� */
	public static final Integer RED_RULE_TYPE12 = 12;
	/** ���ƻ�Ա���պ�� */
	public static final Integer RED_RULE_TYPE13 = 13;
	/** ��ʯ��Ա���պ�� */
	public static final Integer RED_RULE_TYPE14 = 14;
	/** 10Ԫ������� */
	public static final Integer RED_RULE_TYPE15 = 15;
	/** 20Ԫ������� */
	public static final Integer RED_RULE_TYPE16 = 16;
	/** 50Ԫ������� */
	public static final Integer RED_RULE_TYPE17 = 17;
	/** 100Ԫ������� */
	public static final Integer RED_RULE_TYPE18 = 18;
	/** 500Ԫ������� */
	public static final Integer RED_RULE_TYPE19 = 19;

	/** ���п����������(��Ǯ) */
	public static String CONSTATYPE_QUICKPAY = "99bill";
	/** ���п����������_�ڱ� */
	public static String CONSTATYPE_REAPAL = "reapal";

	/** ֤������ */
	public static final String IDTYPE = "0";

	/** ����Ϣ��֤����Ҫ���Ͷ�̬�룩 */
	public static final String IND_AUTH_TOKEN = "indAuthToken";

	public static final String EXTERNALREF_NUMBER_SESSION = "externalrefNumber";

//	/**
//	 * ��Ǯ֧������Ӧ���뷵��Ӧ���������Ϣ
//	 * 
//	 * @param responseCode
//	 * @return
//	 */
//	public static String getQuickPayErrorCode(String responseCode) {
//		String returnMsg = "";
//		if (!StringUtil.isEmpty(responseCode)) {
//			if ("00".equals(responseCode)) {
//				returnMsg = "���׳ɹ�";
//			} else {
//				String msg = PropertyUtil.getProperty(responseCode, "messageInfo.properties");
//				try {
//					if (!StringUtil.isEmpty(msg)) {
//						msg = new String(msg.getBytes("ISO8859-1"), "UTF-8");
//						returnMsg = msg + "(������룺" + responseCode + ")";
//					}
//				} catch (Exception e) {
//					log.info("getQuickPayErrorCode responseCode:" + responseCode + ", " + e.getMessage());
//					return "ϵͳ�쳣������������������ϵ�ͷ�4009660198��������룺" + responseCode + ")";
//				}
//			}
//		}
//		return returnMsg;
//	}
//	// ��Ǯ֧�� END

	/* ΢�Ż��س��� */
	/** ΢�Ż״̬-��ʼ */
	public static final int WECHAT_ACTVITY_STATUS_STAR = 1;
	/** ΢�Ż״̬-ֹͣ */
	public static final int WECHAT_ACTVITY_STATUS_STOP = 2;
	/** ΢�Ŷ���״̬-�¶���/δ֧�� */
	public static final int WECHAT_ORDER_STATUS_NEW = 0;
	/** ΢�Ŷ���״̬-��֧�� */
	public static final int WECHAT_ORDER_STATUS_PAY_SUCCESS = 1;
	/** ΢�Ŷ���״̬-��ʹ�� */
	public static final int WECHAT_ORDER_STATUS_USER = 3;
	/** ΢�Ŷ���״̬-����ʹ�� */
	public static final int WECHAT_ORDER_STATUS_PORTION_USER = 4;
	/** ΢�Ŷ���״̬-��ʱ */
	public static final int WECHAT_ORDER_STATUS_OUTTIME = 5;
	/** ΢�Ŷ���״̬-ȡ�� */
	public static final int WECHAT_ORDER_STATUS_CANCEL = 6;
	/** ΢�Ŷ���״̬-ʧ�� */
	public static final int WECHAT_ORDER_STATUS_PAY_FAIULRE = 7;

	// ����֧�����״̬,1 ����ɹ���-1����ʧ��
	/** ����֧�����״̬, ����ɹ� */
	public static final int CASH_BOX_RESULT_SUCCESS = 1;
	/** ����֧�����״̬, ����ʧ�� */
	public static final int CASH_BOX_RESULT_FAILURE = -1;

	// ����֧���������� �������� 31�����ѣ�32��������33��������;34������������
	// IC ���� 51�����ѣ�52��������53��������54����������
	/** ����֧���������� �������� ���� */
	public static final int CASH_BOX_ORDER_TYPE_TRAD = 31;
	/** ����֧���������� �������� ������ */
	public static final int CASH_BOX_ORDER_TYPE_CORRECT = 32;
	/** ����֧���������� �������� ������ */
	public static final int CASH_BOX_ORDER_TYPE_UNDO = 33;
	/** ����֧���������� �������� ���������� */
	public static final int CASH_BOX_ORDER_TYPE_CORRECT_UNDO = 34;
	/** ����֧���������� ��IC�� ���� */
	public static final int CASH_BOX_ORDER_TYPE_IC_TRAD = 51;
	/** ����֧���������� ��IC�� ������ */
	public static final int CASH_BOX_ORDER_TYPE_IC_CORRECT = 52;
	/** ����֧���������� ��IC�� ������ */
	public static final int CASH_BOX_ORDER_TYPE_IC_UNDO = 53;
	/** ����֧���������� ��IC�� ���������� */
	public static final int CASH_BOX_ORDER_TYPE_IC_CORRECT_UNDO = 54;
	// ����֧������״̬ ��0 δ֧����1 ���׳ɹ���2 ����ʧ�� 3 ����ɹ� 4 ����ʧ�� 5δ֪�����
	/** ����֧������״̬ ��0 δ֧���� */
	public static final int CASH_BOX_ORDER_STATUS_NEW = 0;
	/** ����֧������״̬ ��1 ���׳ɹ� */
	public static final int CASH_BOX_ORDER_STATUS_SUCCESS = 1;
	/** ����֧������״̬ ��2 ����ʧ�� */
	public static final int CASH_BOX_ORDER_STATUS_FAILURE = 2;
	/** ����֧������״̬ ��3 ����ɹ� */
	public static final int CASH_BOX_ORDER_STATUS_PRODUCT_BOUGHT = 3;
	/** ����֧������״̬ ��4 ����ʧ��-ϵͳ�쳣���µģ���Ҫ��λ�쳣�ģ�ȷ����ֵ�ɹ���ȷ���Ƿ���ɹ������磺Ͷ������ */
	public static final int CASH_BOX_ORDER_STATUS_PRODUCT_PAY_FAILURE = 4;
	/** ����֧������״̬ ��5 δ֪��� */
	public static final int CASH_BOX_ORDER_STATUS_UNKNOWN = 5;
	/** ����֧������״̬ ��6 ����ʧ��-���򲻳ɹ�����Ҫ���¹���ģ�ȷ����ֵ�ɹ�ȷ��û�й������磺���������Ͷ����ڱ������Ͷ�ʷ�Χ�ڵ� */
	public static final int CASH_BOX_ORDER_STATUS_REPAY = 6;

	public static final String CASH_BOX_FLAG = "cashBox";

	// ��Ʒ�������10 �Ƽ�λ ��20��Ʒλ1��21��Ʒλ2��22��Ʒλ3��23��Ʒλ4��24��Ʒλ5
	public static final int BORROW_GROUP_RECOMMEND = 10;
	public static final int BORROW_GROUP_PRODUCT_ONE = 20;
	public static final int BORROW_GROUP_PRODUCT_TWO = 21;
	public static final int BORROW_GROUP_PRODUCT_THREE = 22;
	public static final int BORROW_GROUP_PRODUCT_FOUR = 23;
	public static final int BORROW_GROUP_PRODUCT_FIVE = 24;
	// ��Ʒ���鼯��
	public static final List<Integer> BORROW_GROUP_LIST = Arrays
			.asList(new Integer[] { BORROW_GROUP_RECOMMEND, BORROW_GROUP_PRODUCT_ONE, BORROW_GROUP_PRODUCT_TWO,
					BORROW_GROUP_PRODUCT_THREE, BORROW_GROUP_PRODUCT_FOUR, BORROW_GROUP_PRODUCT_FIVE });

	/** �ѷ��� */
	public static final String SOFANG = "soFang";

	/** ���Ǵ�Ͷ */
	public static final String HAICHENG = "haiCheng";

	/** �û�����״̬��0 δ��ȡ 1�ѻ�ȡ 2�ѹ��� 3����� */
	public static final int USER_TASK_STATUS_NOT_GET = 0;
	public static final int USER_TASK_STATUS_GET = 1;
	public static final int USER_TASK_STATUS_TIME_OUT = 2;
	public static final int USER_TASK_STATUS_FINISHED = 3;

	/** ɭ�ֳ���1Ԫ�齱�ע�� */
	public static final String FORESTSTART = "2016-06-06 00:00:00";

	/* ��Ա�ȼ� */
	/** ��Ա�ȼ�-���� */
	public static final int USER_LEVEL_IRON = 0;
	/** ��Ա�ȼ�-��ͭ */
	public static final int USER_LEVEL_BRONZE = 1;
	/** ��Ա�ȼ�-���� */
	public static final int USER_LEVEL_SILVER = 2;
	/** ��Ա�ȼ�-�ƽ� */
	public static final int USER_LEVEL_GOLD = 3;
	/** ��Ա�ȼ�-��ʯ */
	public static final int USER_LEVEL_DIAMOND = 4;

	public static Map<Integer, String> userLevelMap = new HashMap<Integer, String>();

	static {
		userLevelMap.put(USER_LEVEL_IRON, "���û�");
		userLevelMap.put(USER_LEVEL_BRONZE, "ͭ�ƻ�Ա");
		userLevelMap.put(USER_LEVEL_SILVER, "���ƻ�Ա");
		userLevelMap.put(USER_LEVEL_GOLD, "���ƻ�Ա");
		userLevelMap.put(USER_LEVEL_DIAMOND, "��ʯ��Ա");
	}

	/**
	 * �����
	 */
	public static final double TESTSUM = 10000;

	/* ��Ϣȯ���� */
	/** ��Ϣȯ״̬��δʹ�� */
	public static final int INTEREST_COUPON_STATUS_NEW = 0;
	/** ��Ϣȯ״̬����ʹ�� */
	public static final int INTEREST_COUPON_STATUS_USE = 1;
	/** ��Ϣȯ״̬���ѽ��� */
	public static final int INTEREST_COUPON_STATUS_REWARD = 2;
	/** ��Ϣȯ״̬���ѹ��� */
	public static final int INTEREST_COUPON_STATUS_TIMEOUT = 3;
	/* ��Ϣȯ���� end */

	/** 8�����ʦ���½���5Ԫ */
	public static final String CFP_ACTIVITY_START_TIME = "2016-08-27 00:00:00";
	public static final String CFP_ACTIVITY_END_TIME = "2016-09-27 23:59:59";

	/** helj hlej_url.smsVerifyCodeHFive */
	/** ƽ̨ ������ƣ� */
	public static final String SMS_JLEJ_INTERFACE_SF = "hlc";
	/** ������֤������ ��ע�ᣩ */
	public static final String SMS_JLEJ_INTERFACE_VERIFYTYPE = "register";
	public static final String SMS_JLEJ_INTERFACE_VERIFYTYPE_FIND_PWD = "findPWD";
	/** ������֤������ ���޸��ʺţ� */
	public static final String SMS_JLEJ_INTERFACE_VERIFYTYPE_MODIFYPHONE = "modifyPhone";

	public static final String SMS_JLEJ_INTERFACE_DATASOURCE = "1";

	/** Ԫ�����ʦ�����������Ͷ�ʽ������ */
	public static final Double CFP_AWARD_AMOUNT = 10.0;
	/** Ԫ�����ʦ�����������Ͷ�ʻ�ú������ */
	public static final String CFP_AWARD_REDTYPE = "29";
	/** Ԫ�����ʦ�������� */
	public static final String CFP_AWARD_ACTIVITYNUM = "1478585790107";
	/** Ԫ�����ʦ������ʼʱ�� */
	public static final String CFP_AWARD_START_TIME = "2017-01-02 00:00:00";
	/** Ԫ�����ʦ��������ʱ�� */
	public static final String CFP_AWARD_END_TIME = "2017-02-15 23:59:59";

	/** ¥�̻�û�ɨ���ֻ����� */
	public static final String LPHD_USER_PHONENUM = "lphdUserPhonenum";

	/**
	 * ת���Ǯ��
	 */
	public static final int SWITCH_TO_BOX = 1;

	/**
	 * ת����Ǯ��
	 */
	public static final int ROLL_OUT_BOX = 2;

	public static final String SESSION_KEY = "uky";

	/** ��ֵ���͡�����pos֧�� */
	public static final int RECHARGE_TYPE_ALLINPAYPOS = 8;
	/** ��ֵ���͡��ڱ����֧��-΢�Ŷ� */
	public static final int RECHARGE_TYPE_REAPAL_WECHAT = 9;
	/** ��ֵ���͡��ڱ����֧��-web�� */
	public static final int RECHARGE_TYPE_REAPAL_WEB = 10;
	/** ��ֵ���͡��ڱ����֧��-app�� */
	public static final int RECHARGE_TYPE_REAPAL_APP = 11;
	/** ��ֵ���͡��ڱ����֧��-������ֵ */
	public static final int RECHARGE_TYPE_REAPAL_BANK = 12;

	/** ��ֵ�����δ֧�� */
	public static final int RECHARGE_RESULT_NOPAY = -1;
	/** ��ֵ����������� */
	public static final int RECHARGE_RESULT_PAYING = 0;
	/** ��ֵ�����֧���ɹ� */
	public static final int RECHARGE_RESULT_PAYSUC = 1;
	/** ��ֵ�����֧��ʧ�� */
	public static final int RECHARGE_RESULT_PAYFAI = 2;

	/** �ʽ��¼-��������-��ֵ */
	public static final int FUND_TRADETYPE_RECHARGE = 1;
	/** �ʽ��¼-��������-���� */
	public static final int FUND_TRADETYPE_WITHDRAW = 2;

	/** �ʽ��¼-״̬-ʧ�� */
	public static final int FUND_STATUS_FAILURE = -1;
	/** �ʽ��¼-״̬-�ȴ� */
	public static final int FUND_STATUS_WAIT = 0;
	/** �ʽ��¼-״̬-�ɹ� */
	public static final int FUND_STATUS_SUCCESS = 1;
}
