package com.real.utils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 时间工具类
 * 
 * @author ruoyi
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	public static String YYYY = "yyyy";
	public static String HH_MM = "HH:mm";
	public static String YYYY_MM = "yyyy-MM";
	public static String YYYYMMDD = "yyyyMMdd";
	public static String YYYY_MM_DD = "yyyy-MM-dd";
	public static String YYYY_MM_DD2 = "yyyy/MM/dd";
	public static String MM_DD_HH_MM = "MM-dd HH:mm";
	public static String MMDDHHMMSS = "MMddHHmmss";
	public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static String YYYYMMDDHHMM = "yyyyMMddHHmm";
	public static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	
	public static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
			"yyyy.MM.dd HH:mm", "yyyy.MM","yyMMddHHmm" };
	private static final String JUST_NOW = "刚刚";
	private static final String ONE_SECOND_AGO = "秒前";
	private static final String ONE_MINUTE_AGO = "分钟前";
	private static final String ONE_HOUR_AGO = "小时前";
	private static final String ONE_DAY_AGO = "天前";
	private static final String ONE_MONTH_AGO = "个月前";
	private static final String ONE_YEAR_AGO = "年前";

	private static final long TEN_SECNOD = 10000L;
	private static final long ONE_MINUTE = 60000L;
	private static final long ONE_HOUR = 3600000L;
	private static final long ONE_DAY = 86400000L;
	private static final long ONE_WEEK = 604800000L;

	/**
	 * 计算相对于dateToCompare的年龄，长用于计算指定生日在某年的年龄
	 * 
	 * @param birthDay
	 *            生日
	 * @param dateToCompare
	 *            需要对比的日期
	 * @return 年龄
	 * @throws Exception
	 */
	public static int age(Date birthDay, Date dateToCompare) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateToCompare);

		if (cal.before(birthDay)) {
			return 0;
		}

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthDay);
		int age = year - cal.get(Calendar.YEAR);

		int monthBirth = cal.get(Calendar.MONTH);
		if (month == monthBirth) {
			int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
			if (dayOfMonth < dayOfMonthBirth) {
				// 如果生日在当月，但是未达到生日当天的日期，年龄减一
				age--;
			}
		} else if (month < monthBirth) {
			// 如果当前月份未达到生日的月份，年龄计算减一
			age--;
		}

		return age;
	}

	/**
	 * 生日转为年龄，计算法定年龄
	 * 
	 * @param birthDay
	 *            生日
	 * @return 年龄
	 * @throws Exception
	 */
	public static int ageOfNow(Date birthDay) {
		return age(birthDay, new Date());
	}

	/**
	 * 生日转为年龄，计算法定年龄
	 * 
	 * @param birthDay
	 *            生日，标准日期字符串
	 * @return 年龄
	 * @throws Exception
	 */
	public static int ageOfNow(String birthDay) {
		return ageOfNow(parseDate(birthDay));
	}

	/**
	 * 获取YYYY-MM-DD格式
	 */
	public static String getDate() {
		return formatDate(new Date(), "yyyy-MM-dd");
	}

	/**
	 * 获取指定格式获取当前时间
	 */
	public static String getDate(String pattern) {
		return formatDate(new Date(), pattern);
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 */
	public static String getTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 */
	public static String getTime(String pattern) {
		return formatDate(new Date(), pattern);
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 */
	public static String getTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss.SSS格式
	 */
	public static String getMsTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * 获取YYYY格式
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 获取YYYY格式
	 */
	public static String getYear(Date date) {
		return formatDate(date, "yyyy");
	}

	/**
	 * 获取当前日期, 默认格式为YYYYMMDD
	 * 
	 * @return String
	 */
	public static String getYMDDate() {
		return formatDate(new Date(), YYYYMMDD);
	}

	public static String formatDate(Date date, String pattern) {
		if(date==null){
			return null;
		}
		String formatDate = null;
		if (pattern!=null&&!"".equals(pattern)) {
			formatDate = DateFormatUtils.format(date, pattern);
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 日期型字符串转化为日期 格式
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 将特定格式的日期转换为Date对象
	 *
	 * @param dateString
	 *            特定格式的日期
	 * @param format
	 *            格式，例如yyyy-MM-dd
	 * @return 日期对象
	 */
	public static Date parseDate(String dateString, String format) {
		return parseDate(dateString, new SimpleDateFormat(format));
	}

	
	/**
	 * 构建DateTime对象
	 *
	 * @param dateStr
	 *            Date字符串
	 * @param simpleDateFormat
	 *            格式化器
	 * @return DateTime对象
	 */
	public static Date parseDate(String dateStr, SimpleDateFormat simpleDateFormat) {
		try {
			return simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}

	}
	 public static Date getNowDate()
	    {
	        return new Date();
	    }

	/**
	 * 获取服务器启动时间
	 */
	public static Date getServerStartDate() {
		long time = ManagementFactory.getRuntimeMXBean().getStartTime();
		return new Date(time);
	}

	/**
	 * 判断两个日期相差的时长<br/>
	 * 返回 minuend - subtrahend 的差
	 * 
	 * @param subtrahend
	 *            减数日期
	 * @param minuend
	 *            被减数日期
	 * @param diffField
	 *            相差的选项：相差的天、小时
	 * @return 日期差
	 */
	public static long diff(Date subtrahend, Date minuend, long diffField) {
		long diff = minuend.getTime() - subtrahend.getTime();
		return diff / diffField;
	}
	
	/**
	 * 判断两个日期相差天数<br/>
	 * 返回 minuend - subtrahend 的差
	 * 
	 * @param subtrahend
	 *            减数日期
	 * @param minuend
	 *            被减数日期
	 * @param diffField
	 *            相差的选项：相差的天、小时
	 * @return 日期差
	 */
	public static long diffDay(Date subtrahend, Date minuend) {
		if(subtrahend == null || minuend == null) {
			return 0L;
		}
		long diff = minuend.getTime() - subtrahend.getTime();
		return diff /(1000*60*60*24);
	}

	public static String formationTime(Date date) {
		if(date==null){
			return null;
		}
		long delta = new Date().getTime() - date.getTime();
		if (delta < 1L * TEN_SECNOD) {
			return JUST_NOW;
		}
		if (delta < 1L * ONE_MINUTE) {
			long seconds = toSeconds(delta);
			return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
		}
		if (delta < 45L * ONE_MINUTE) {
			long minutes = toMinutes(delta);
			return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
		}
		if (delta < 24L * ONE_HOUR) {
			long hours = toHours(delta);
			return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
		}
		Calendar calendar = Calendar.getInstance();
		if (delta < 48L * ONE_HOUR) {
			if (delta < 24 * ONE_HOUR + calendar.get(Calendar.MINUTE) * ONE_MINUTE) {
				return "昨天";
			} else {
				return "前天";
			}

		}

		if (delta < 30L * ONE_DAY) {
			long days = toDays(delta);
			return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
		}
		if (delta < 12L * 4L * ONE_WEEK) {
			long months = toMonths(delta);
			return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
		} else {
			long years = toYears(delta);
			return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
		}
	}

	/**
	 * 获取某天的开始时间
	 *
	 * @param date
	 *            日期
	 * @return 某天的开始时间
	 */
	public static Date getBeginTimeOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取某天的结束时间
	 *
	 * @param date
	 *            日期
	 * @return 某天的结束时间
	 */
	public static Date getEndTimeOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 计算两个时间差
	 */
	public static String getDatePoor(Date endDate, Date nowDate) {
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		// long ns = 1000;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - nowDate.getTime();
		// 计算差多少天
		long day = diff / nd;
		// 计算差多少小时
		long hour = diff % nd / nh;
		// 计算差多少分钟
		long min = diff % nd % nh / nm;
		// 计算差多少秒//输出结果
		// long sec = diff % nd % nh % nm / ns;
		return day + "天" + hour + "小时" + min + "分钟";
	}

	/**
	 * 获取指定日期偏移指定时间后的时间
	 *
	 * @param date
	 *            基准日期
	 * @param calendarField
	 *            偏移的粒度大小（小时、天、月等）使用Calendar中的常数
	 * @param offsite
	 *            偏移量，正数为向后偏移，负数为向前偏移
	 * @return 偏移后的日期
	 */
	public static Date offsiteDate(Date date, int calendarField, int offsite) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(calendarField, offsite);
		return cal.getTime();
	}
	// ------------------------------------ Offset end
	// ----------------------------------------------

	/**
	 * 偏移天
	 *
	 * @param date
	 *            日期
	 * @param offsite
	 *            偏移天数，正数向未来偏移，负数向历史偏移
	 * @return 偏移后的日期
	 */
	public static Date offsiteDay(Date date, int offsite) {
		return offsiteDate(date, Calendar.DAY_OF_YEAR, offsite);
	}

	/**
	 * 偏移月
	 *
	 * @param date
	 *            日期
	 * @param offsite
	 *            偏移月数，正数向未来偏移，负数向历史偏移
	 * @return 偏移后的日期
	 */
	public static Date offsiteMonth(Date date, int offsite) {
		return offsiteDate(date, Calendar.MONTH, offsite);
	}

	/**
	 * 偏移周
	 *
	 * @param date
	 *            日期
	 * @param offsite
	 *            偏移周数，正数向未来偏移，负数向历史偏移
	 * @return 偏移后的日期
	 */
	public static Date offsiteWeek(Date date, int offsite) {
		return offsiteDate(date, Calendar.WEEK_OF_YEAR, offsite);
	}

	/**
	 * 将当前时间缩写。如果是当天 即去掉年，否则则保留年
	 * 
	 * @param date
	 * @return
	 */
	public static String shortTime(Date date) {
		if(date==null){
			return null;
		}
		Date now = new Date();
		Date todayStart = getBeginTimeOfDay(now);
		Date todayEnd = getEndTimeOfDay(now);
		if (date.after(todayStart) && date.before(todayEnd)) {
			return formatDate(date, HH_MM);
		} else if (getYear().equals(getYear(date))) {
			return formatDate(date, MM_DD_HH_MM);
		} else {
			return formatDate(date, YYYY_MM_DD_HH_MM);
		}

	}

	/**
	 * 计时，常用于记录某段代码的执行时间，单位：毫秒
	 * 
	 * @param preTime
	 *            之前记录的时间
	 * @return 时间差，毫秒
	 */
	public static long spendMs(long preTime) {
		return System.currentTimeMillis() - preTime;
	}

	/**
	 * 计时，常用于记录某段代码的执行时间，单位：纳秒
	 * 
	 * @param preTime
	 *            之前记录的时间
	 * @return 时间差，纳秒
	 */
	private static long spendNt(long preTime) {
		return System.nanoTime() - preTime;
	}

	private static long toDays(long date) {
		return toHours(date) / 24L;
	}

	private static long toHours(long date) {
		return toMinutes(date) / 60L;
	}

	private static long toMinutes(long date) {
		return toSeconds(date) / 60L;
	}

	private static long toMonths(long date) {
		return toDays(date) / 30L;
	}

	private static long toSeconds(long date) {
		return date / 1000L;
	}

	private static long toYears(long date) {
		return toMonths(date) / 12L;
	}

	/**
	 * 计算指定指定时间区间内的周数
	 * 
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return 周数
	 */
	public static int weekCount(Date start, Date end) {
		final Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(start);
		final Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);

		final int startWeekofYear = startCalendar.get(Calendar.WEEK_OF_YEAR);
		final int endWeekofYear = endCalendar.get(Calendar.WEEK_OF_YEAR);

		int count = endWeekofYear - startWeekofYear + 1;

		if (Calendar.SUNDAY != startCalendar.get(Calendar.DAY_OF_WEEK)) {
			count--;
		}

		return count;
	}

	/**
	 * 昨天
	 *
	 * @return 昨天
	 */
	public static Date yesterday() {
		return offsiteDay(new Date(), -1);
	}

	/**
	 * 上个月
	 *
	 * @return 上个月
	 */
	public static Date lastMouth() {
		return offsiteMonth(new Date(), -1);
	}

	/**
	 * 上周
	 *
	 * @return 上周
	 */
	public static Date lastWeek() {
		return offsiteWeek(new Date(), -1);
	}

	public static void main(String[] args) {
		System.out.println(diffDay(parseDate("2019-06-26"),parseDate("2019-06-27")));
	}
}
