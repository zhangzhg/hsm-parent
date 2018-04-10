package com.hsm.api.util;

import org.apache.commons.lang3.StringUtils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description: 日期时间工具类
 * getCurDate - 获取当前时间指定格式的字符串<br>
 * limitDay - 格式化到天（2014-09-15）<br>
 * limitMinute - 格式化到分钟<br>
 * getCurDateTime - 获取当前时间指定格式的字符串(到分钟秒)<br>
 * getCurDate - 获取当前时间的“yyyy-MM-dd”格式字符串<br>
 * DateUtil2SQL - 转换java.util.date至SQL date<br>
 * getFirstDayOfMonth - 获取每月第一天的“yyyy-MM-dd”格式字符串<br>
 * getFirstDayOfYear - 获取每年第一天的“yyyy-MM-dd”格式字符串<br>
 * getFirstDayOfWeek - 获取每周第一天的“yyyy-MM-dd”格式字符串（以星期一作为一周的开始<br>
 * get1stDayOfWeek - 获取本周第一天<br>
 * get1stDayOfMonth - 获取本月第一天<br>
 * getLastDayOfLastWeek - 获取每周最后一天的“yyyy-MM-dd”格式字符串（以星期天作为一周的结束<br>
 * getFirstDayOfLastMonth - 获取上个月第一天的“yyyy-MM-dd”格式字符串<br>
 * getLastDayOfLastMonth - 获取上个月最后一天的“yyyy-MM-dd”格式字符串<br>
 * getFirstDayOfLastYear - 获取去年第一天的“yyyy-MM-dd”格式字符串<br>
 * getLastDayOfLastYear - 获取去年最后一天的“yyyy-MM-dd”格式字符串<br>
 * getFirstDayOfPastYear - 取得前n年第一天的“yyyy-MM-dd”格式字符串。<br>
 * getLastDayOfPastYear - 取得前n年最后一天的“yyyy-MM-dd”格式字符串。<br>
 * formatDate - 以指定格式格式化时间: <br>
 * formatDate - 以指定时区格式格式化时间: <br>
 * addMonth - 根据传入的日期以及月份数计算并返回日期<br>
 * addDate - 根据传入的日期以及天数计算并返回日期<br>
 * addMinute - 根据传入的日期以及分钟数计算并返回日期<br>
 * addHour - 根据传入的日期以及小时数计算并返回日期<br>
 * addYear - 根据传入的日期以及年数计算并返回日期<br>
 * addWeek - 根据传入的日期以及星期数计算并返回日期<br>
 * parseDateByStr - 将String类型日期转换为Date类型的日期<br>
 * strToDate - 将短时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss<br>
 * parseDateByStr - 根据传入的日期时间字符串生成日期对象 传入的日期字符串格式为 YYYY-MM-DD hh:mm:ss<br>
 * get - 取得指定日期时间的指定field（比如，年、月、日）的值<br>
 * getListDate - 得到两个日期的时间差-包含开始日期和结束日期<br>
 * getDateWeek - 根据开始日期、结束日期、班期（145:表示周一、周四、周五） 得到满足条件的日期集合<br>
 * getCurYear - 取得当前年份 : <br>
 * getIntervalDays - 取得两个时间相隔的天数<br>
 * getBetweenDayNum - 取得两个时间总的天数，包含头尾<br>
 * getIntervalNights - 取得两个时间相隔的间夜数 如：2010-01-01到2010-01-03,相隔2晚<br>
 * getWeekDay - 取得指定日期是星期几<br>
 * getWeekDayNumber - 取得指定日期是星期几的数字表示，星期天为0<br>
 * getWeekIndex - 取得一周某一天，星期天返回7<br>
 * countdown - 倒计时 : <br>
 * dateInterval - 计算时间间隔<br>
 * getWeekDayDesc - 获取某一天是星期几<br>
 * timeInterval - 计算时间间隔 如几点几分之前<br>
 * computeWeeks - 计算两个日期间相隔的周数<br>
 * getChrMonthDate - 得到如"29OCT10"的字母月的日期格式<br>
 * getHotelCheckDate - 酒店日历 构建日历选择框<br>
 */
public class DateUtil {

	/**
	 * 格式化到天（2014-09-15）
	 */
	public static final String FORMAT_DAY = "yyyy-MM-dd";
	/**
	 * 格式化到分钟（2014-09-15 13:35）
	 */
	public static final String FORMAT_MINUTE = "yyyy-MM-dd HH:mm";
	
	private static final String ZERO_PREFIX = "0";

	private static final String COLON = ":";
	// 月份
	public static final String[] strMonths = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

	/**
	 * 禁止外部实例化
	 * 
	 */
	private DateUtil() {

	}

	/**
	 * 
	 * 获取当前时间指定格式的字符串 <br>
	 * @param format 时间格式
	 * @return 当前时间：
	 * eg:入参：yyyy-MM-dd 出参：2015-10-22
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getCurDate(String format) {
		return formatDate(new Date(), format);
	}

	/**
	 * 
	 * 格式化到天 <br>
	 * @param date
	 * @return 2014-09-15
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String limitDay(Date date) {
		return formatDate(date, FORMAT_DAY);
	}

	/**
	 * 
	 * 格式化到分钟 <br>
	 * @param date
	 * @return 2014-09-15 13:35
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String limitMinute(Date date) {
		return formatDate(date, FORMAT_MINUTE);
	}
	
	/**
	 * 
	 * 获取当前时间指定格式的字符串("YYYY-MM-DD HH:mm:ss") <br>
	 * @return 当前时间 2015-10-22 13:59:19
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getCurDateTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时:分:秒:毫秒
		return sdf.format(d);
	}

	/**
	 * 
	 * 获取当前时间指定格式的字符串("YYYY-MM-dd") <br>
	 * @return 当前时间 2015-10-22
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getCurDate() {
		return getCurDate("yyyy-MM-dd");
	}

	/**
	 * 
	 * 转换java.util.date至SQL date <br>
	 * @param date
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static java.sql.Date DateUtil2SQL(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 
	 * 获取每月第一天的“yyyy-MM-dd”格式字符串 <br>
	 * @return 2015-10-01
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getFirstDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return formatDate(cal.getTime());
	}

	/**
	 * 
	 * 获取每年第一天的“yyyy-MM-dd”格式字符串 <br>
	 * @return 2015-01-01
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getFirstDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_YEAR, 1);
		return formatDate(cal.getTime());
	}

	/**
	 * 
	 * 获取每周第一天的“yyyy-MM-dd”格式字符串（以星期一作为一周的开始） <br>
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getFirstDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 以星期一作为一周的开始
		return formatDate(cal.getTime());
	}

	/**
	 * 
	 * 获取上一周最后一天的“yyyy-MM-dd”格式字符串（以星期天作为一周的结束） <br>
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getLastDayOfLastWeek() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return formatDate(cal.getTime());
	}

	/**
	 * 
	 * 获取上个月第一天的“yyyy-MM-dd”格式字符串 <br>
	 * @return yyyy-MM-dd
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getFirstDayOfLastMonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return formatDate(cal.getTime());
	}

	/**
	 * 
	 * 获取上个月最后一天的“yyyy-MM-dd”格式字符串 <br>
	 * @return yyyy-MM-dd
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getLastDayOfLastMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return formatDate(cal.getTime());
	}

	/**
	 * 
	 * 获取去年第一天的“yyyy-MM-dd”格式字符串 <br>
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getFirstDayOfLastYear() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		return formatDate(cal.getTime());
	}

	/**
	 * 
	 * 获取去年最后一天的“yyyy-MM-dd”格式字符串 <br>
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getLastDayOfLastYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_YEAR, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return formatDate(cal.getTime());
	}

	/**
	 * 
	 * 取得前n年第一天的“yyyy-MM-dd”格式字符串 <br>
	 * 如果n值过大，导致取得的时间在公元1年以前，那么会导致结果不准确，所以会抛出 IllegalArgumentException异常<br>
	 * @param n
	 * @return 
	 * eg:以2015年为例，n=1；输出 2014-01-01
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getFirstDayOfPastYear(int n) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		if (year - n <= 0)
			throw new IllegalArgumentException("parameter is too large");
		cal.add(Calendar.YEAR, (0 - n));
		cal.set(Calendar.DAY_OF_YEAR, 1);
		return formatDate(cal.getTime());
	}

	/**
	 * 
	 * 取得前n年最后一天的“yyyy-MM-dd”格式字符串 <br>
	 * 如果n值过大，导致取得的时间在公元1年以前，那么会导致结果不准确，所以会抛出 IllegalArgumentException异常<br>
	 * @param n
	 * @return 
	 * eg:以2015年为例，n=1；输出 2014-12-31
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getLastDayOfPastYear(int n) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		if (year - n <= 0)
			throw new IllegalArgumentException("parameter is too large");
		cal.add(Calendar.YEAR, (1 - n));
		cal.set(Calendar.DAY_OF_YEAR, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return formatDate(cal.getTime());
	}

	/**
	 * 
	 * 以指定格式格式化时间 <br>
	 * @param date 时间
	 * @param format 格式
	 * @return 格式化的时间字符串
	 * eg:入参：当前时间，yyyy-MM-dd；输出：YYYY-MM-DD
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String formatDate(Date date, String format) {
		if (date == null)
			return StringUtils.EMPTY;
		if (format == null || format.trim().equals(""))
			format = "yyyy-MM-dd";
		SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
		return dateFormatter.format(date);
	}

	/**
	 * 
	 * 以美国时区格式化时间 <br>
	 * @param date
	 * @param format
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String formatDateforUS(Date date, String format) {
		SimpleDateFormat dateFormatter;
		if (date == null)
			return StringUtils.EMPTY;
		if (format == null || format.trim().equals(""))
			format = "yyyy-MM-dd";
			dateFormatter = new SimpleDateFormat(format, Locale.US);
		return dateFormatter.format(date);
	}

	/**
	 * 
	 * 以中国时区格式化时间 <br>
	 * @param date
	 * @param format
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String formatDateforCHINA(Date date, String format) {
		SimpleDateFormat dateFormatter;
		if (date == null)
			return StringUtils.EMPTY;
		if (format == null || format.trim().equals(""))
			format = "yyyy-MM-dd";
			dateFormatter = new SimpleDateFormat(format, Locale.CHINA);
		return dateFormatter.format(date);
	}	
	
	/**
	 * 
	 * 以“yyyy-MM-dd”格式化时间  <br>
	 * @param date
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String formatDate(Date date) {
		return formatDate(date, null);
	}

	/**
	 * 
	 * 根据传入的日期以及月份数计算（相应月份前/后）并返回日期<br>
	 * @param date
	 * @param months
	 * @return 计算后的日期
	 * eg: 入参：Thu Oct 22 14:55:30 CST 2015 , -1 出参：Tue Sep 22 14:55:30 CST 2015
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static Date addMonth(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}

	/**
	 * 
	 * 根据传入的日期以及天数计算（相应天数前/后）并返回日期<br>
	 * @param date
	 * @return 计算后的日期
	 * eg: 入参：Thu Oct 22 14:57:34 CST 2015 , -1 出参：Wed Oct 21 14:57:34 CST 2015
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static Date addDate(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	/**
	 * 
	 * 根据传入的日期以及分钟数计算（相应分钟数前/后）并返回日期<br>
	 * @param date
	 * @return 计算后的日期
	 * eg: 入参：Thu Oct 22 14:57:34 CST 2015 , -1 出参：Wed Oct 21 14:56:34 CST 2015
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static Date addMinute(Date date, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	/**
	 * 
	 * 根据传入的日期以及小时数计算（相应小时数前/后）并返回日期<br>
	 * @param date
	 * @return 计算后的日期
	 * eg: 入参：Thu Oct 22 14:57:34 CST 2015 , -1 出参：Wed Oct 21 13:57:34 CST 2015
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static Date addHour(Date date, int hours) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hours);

		return cal.getTime();
	}

	/**
	 * 
	 * 根据传入的日期以及年数计算（相应年数前/后）并返回日期<br>
	 * @param date
	 * @return 计算后的日期
	 * eg: 入参：Thu Oct 22 14:57:34 CST 2015 , -1 出参：Wed Oct 21 14:57:34 CST 2014
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static Date addYear(Date date, int years) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, years);

		return cal.getTime();
	}

	/**
	 * 
	 * 根据传入的日期以及周数计算（相应周数前/后）并返回日期<br>
	 * @param date
	 * @param weeks
	 * @return 计算后日期 <br>
	 * eg：入参：Thu Oct 22 15:22:51 CST 2015  出参： Thu Oct 15 15:22:51 CST 2015
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static Date addWeek(Date date, int weeks) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_MONTH, weeks);

		return cal.getTime();
	}

	/**
	 * 
	 * 将String类型日期转换为Date类型的日期 <br>
	 * @param strDate
	 * @param formatter
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static Date parseDateByStr(String strDate, String formatter) {
		if (formatter == null || formatter.trim().equals("")) {
			formatter = "yyyy-MM-dd";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatter);
		// 必须捕获异常
		try {
			Date date = simpleDateFormat.parse(strDate);
			return date;
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 根据传入的日期时间字符串生成日期对象 传入的日期字符串格式为 YYYY-MM-DD hh:mm:ss<br>
	 * 如果hh:mm:ss没有设置，默认为00:00:00 <br>
	 * @param str
	 * @return 日期对象
	 * eg:入参：2010-12-28 12:23:09  出参：（时间对象）Tue Dec 28 12:23:09 CST 2010
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static Date parseDateByStr(String str) {
		Calendar cal = Calendar.getInstance();
		if (str == null) {
			return null;
		}
		String dateArray[] = str.split("-");
		if (dateArray.length != 3) {
			return null;
		}
		int year = Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1]);
		int date = 1;
		int hour = 0;
		int minute = 0;
		int second = 0;
		if (dateArray[2].indexOf(":") > 0) {
			int i = dateArray[2].indexOf(" ");
			date = Integer.parseInt(dateArray[2].substring(0, i));
			if (i > 0) {
				String hmStr = dateArray[2].substring(i + 1);
				String[] hmArray = hmStr.split(":");
				if (hmArray.length >= 2) {
					hour = Integer.parseInt(hmArray[0]);
					minute = Integer.parseInt(hmArray[1]);
					if (hmArray.length == 3) {
						second = Integer.parseInt(hmArray[2]);
					}
				}
			}
		} else {
			date = Integer.parseInt(dateArray[2]);
		}
		cal.set(year, month - 1, date, hour, minute, second);
		return cal.getTime();
	}

	/**
	 * 
	 * 取得指定日期时间的指定field（比如，年、月、日）的值 <br>
	 * @param cal
	 * @param field  Calendar.YEAR;等
	 * @return 指定field 的值<br>
	 * eg:入参：cal,Calendar.YEAR  返回：当前年份
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月23日]
	 */
	private static int get(Calendar cal, int field) {
		return cal.get(field);
	}

	/**
	 * 
	 * 取得指定日期时间的指定field（比如，年、月、日）的值 <br>
	 * @param field  Calendar.YEAR;等
	 * @return 指定field 的值<br>
	 * eg:入参：cal,Calendar.YEAR  返回：当前年份
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月23日]
	 */
	public static int get(int field) {
		return get(Calendar.getInstance(), field);
	}

	/**
	 * 获取当前日期的年份 <br>
	 * @return 年份
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static int getCurYear() {
		return get(Calendar.YEAR);
	}

	/**
	 * 
	 * 取得两个时间相隔的天数 <br>
	 * @param startDate
	 * @param endDate
	 * @return 相差的天数
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static int getIntervalDays(Date startDate, Date endDate) {
		long start = startDate.getTime();
		long end = endDate.getTime();
		int residue = (int) (Math.abs(end - start) % (24 * 60 * 60 * 1000));
		if (residue > 0) {
			return ((int) (Math.abs(end - start) / (24 * 60 * 60 * 1000))) + 1;
		} else {
			return ((int) (Math.abs(end - start) / (24 * 60 * 60 * 1000)));
		}
	}

	/**
	 * 
	 * 取得两个时间总的天数，包含头尾 <br>
	 * @param startDate 只支持yyyy-MM-dd格式的日期
	 * @param endDate 只支持yyyy-MM-dd格式的日期
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static int getBetweenDayNum(Date startDate, Date endDate) {
		long start = startDate.getTime();
		long end = endDate.getTime();
		return (int) (Math.abs(end - start) / (24 * 60 * 60 * 1000)) + 1;
	}

	/**
	 * 
	 * 取得两个时间相隔的间夜数 <br>
	 * @param startDate 只支持yyyy-MM-dd格式的日期
	 * @param endDate 只支持yyyy-MM-dd格式的日期
	 * @return 相隔夜数<br>
	 * eg：2010-01-01到2010-01-03,相隔2晚
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static int getIntervalNights(Date startDate, Date endDate) {
		long start = startDate.getTime();
		long end = endDate.getTime();

		return (int) (Math.abs(end - start) / (24 * 60 * 60 * 1000));
	}

	/**
	 * 
	 * 取得指定日期是星期几 <br>
	 * @param date
	 * @return 星期一，星期二，...
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getWeekDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return getWeekDayDesc(cal.get(Calendar.DAY_OF_WEEK));
	}

	/**
	 * 
	 * 取得指定日期是星期几的数字表示，星期天为0 <br>
	 * @param date 输入的日期
	 * @return 0,1,2,3,...
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static int getWeekDayNumber(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 
	 * 取得指定日期是星期几的数字表示，星期天为7 <br>
	 * @param date 输入的日期
	 * @return 7,1,2,3,...
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static int getWeekIndex(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (index == 0) { // 周日
			return 7;
		}

		return index;
	}

	/**
	 * 
	 * 将秒数转换成时：分：秒 <br>
	 * @param seconds
	 * @return 时：分：秒 <br>
	 * eg: 入参：60  出参：00:01:00 
	 * @author Hunter 
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getPeriodString(long seconds) {
		long hour = seconds / (60 * 60);
		seconds = seconds % (60 * 60);
		return addZeroPrefix(hour) + COLON + addZeroPrefix((seconds / 60)) + COLON + addZeroPrefix((seconds % 60));
	}

	/**
	 * 
	 * 倒计时 : 天时 <br>
	 * @param date
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String countdownDH(Date date, String format) {
		if (date == null)
			return null;
		StringBuilder sb = new StringBuilder();
			// 过期时间
			long validTime = date.getTime();
			long now = System.currentTimeMillis();
			long dur = validTime - now;
			if (dur < 0) {
				return " 00天 00时";
			}
			// 天
			int day = (int) (dur / (60 * 60 * 24 * 1000));
			if (day < 10)
				sb.append(0);
			sb.append(day);
			sb.append(" 天");
			// 小时
			int hours = (int) ((dur - (long) day * (60 * 60 * 24 * 1000)) / (60 * 60 * 1000));
			if (hours < 10)
				sb.append(0);
			sb.append(hours);
			sb.append(" 时");
		return sb.toString();
	}

	/**
	 * 
	 * 倒计时 : 天时分秒 <br>
	 * @param date
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String countdownDHMS(Date date) {
		if (date == null)
			return null;
		StringBuilder sb = new StringBuilder();
			// 过期时间
			long validTime = date.getTime();
			long now = System.currentTimeMillis();
			long dur = validTime - now;
			if (dur < 0) {
				return " 00天 00时 00分 00秒";
			}
			// 天
			int day = (int) (dur / (60 * 60 * 24 * 1000));
			if (day < 10)
				sb.append(0);
			sb.append(day);
			sb.append(" 天");
			// 小时
			int hours = (int) ((dur - (long) day * (60 * 60 * 24 * 1000)) / (60 * 60 * 1000));
			if (hours < 10)
				sb.append(0);
			sb.append(hours);
			sb.append(" 时");
			// 分钟
			int min = (int) ((dur - (long) day * (60 * 60 * 24 * 1000) - (long) hours * (60 * 60 * 1000)) / (60 * 1000));
			if (min < 10)
				sb.append(0);
			sb.append(min);
			sb.append(" 分");
			// 秒
			int seconds = (int) ((dur - (long) day * (60 * 60 * 24 * 1000) - (long) hours * (60 * 60 * 1000) - min * (60 * 1000)) / 1000);
			if (seconds < 10)
				sb.append(0);
			sb.append(seconds);
			sb.append(" 秒");
		return sb.toString();
	}
	
	/**
	 * 
	 * 计算时间间隔 <br>
	 * @param beginDate
	 * @param endDate
	 * @return 两个时间之间相差的 月日时分秒
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String dateInterval(Date beginDate, Date endDate) {
		long d1 = beginDate.getTime();
		long d2 = endDate.getTime();
		long millisecond = d2 - d1;
		;
		// 判断是否超过一个小时
		float interv = Math.abs((float) millisecond / (1000 * 60 * 60));
		if (interv >= 1.0) { // 大于一个小时
			SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日  HH:mm");
			return sdf.format(beginDate);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("mm分");
			return sdf.format(new Date(millisecond));
		}
	}

	/**
	 * 
	 * 数字转换成星期 1对应周日 <br>
	 * @param weekDay
	 * @return 星期X 
	 * eg:入参：1 出参：星期日 ；如果参数不在 (0,8)输出 ：输入的值超过范围！
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	private static String getWeekDayDesc(int weekDay) {
		if(weekDay > 0 && weekDay < 8) {
		switch (weekDay) {
		case Calendar.SUNDAY:
			return "星期日";
		case Calendar.MONDAY:
			return "星期一";
		case Calendar.TUESDAY:
			return "星期二";
		case Calendar.WEDNESDAY:
			return "星期三";
		case Calendar.THURSDAY:
			return "星期四";
		case Calendar.FRIDAY:
			return "星期五";
		case Calendar.SATURDAY:
			return "星期六";
		default:
			return "";
		} }else{
			return "输入的值超过范围！";
		}
	}

	/**
	 * 
	 * 输入值小于10时 在前面补0多用于格式化月份和几号 <br>
	 * @param num
	 * @return 例如：输入：9 返回：09
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	private static String addZeroPrefix(long num) {
		if (num < 0) {
			throw new IllegalArgumentException("parameter must not be negative");
		}
		if (num < 10) {
			return ZERO_PREFIX + num;
		}
		return num + "";
	}

	/**
	 * 
	 * 计算时间间隔 如几点几分之前 <br>
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String timeInterval(Date beginDate, Date endDate) {
		long d1 = beginDate.getTime();
		long d2 = endDate.getTime();
		long millisecond = d2 - d1;
		;
		// 判断是否超过一个小时
		float interv = Math.abs((float) millisecond / (1000 * 60 * 60));
		if (interv >= 1.0) { // 大于一个小时
			SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日  HH:mm");
			return sdf.format(beginDate);

		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("m分钟前");
			String ret = sdf.format(new Date(millisecond));
			if (ret.equals("0分钟前")) {
				ret = "1分钟前";
			}
			return ret;
		}
	}

	/**
	 * 
	 * 计算两个日期间相隔的周数<br>
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return 0:表示两个日期在一周之内
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static int computeWeeks(Date startDate, Date endDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		int s = cal.get(Calendar.WEEK_OF_YEAR);
		cal.setTime(endDate);
		int e = cal.get(Calendar.WEEK_OF_YEAR);
		return (e - s);
	}

	/**
	 * 
	 * 得到如"22 OCT 15"的字母月的日期格式 <br>
	 * @param date
	 * @return 22 OCT 15
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getChrMonthDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		cal.setTime(date);
		String year = String.valueOf(cal.get(Calendar.YEAR));
		year = year.substring(year.length() - 2, year.length());
		int month = cal.get(Calendar.MONTH);
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		if (Integer.parseInt(day) < 10) {
			day = ZERO_PREFIX + day;
		}
		return day + " " + strMonths[month] + " " + year;
	}

	/**
	 * 
	 * 酒店日历 构建日历选择框 <br>
	 * @return [08:00, 08:30, 09:00, 09:30, 10:00, 10:30, 11:00, 11:30, 12:00, 12:30, 13:00, 13:30, 14:00, 14:30, 15:00,<br>
	 *  15:30, 16:00, 16:30, 17:00, 17:30, 18:00, 18:30, 19:00, 19:30, 20:00, 20:30, 21:00, 21:30, 22:00, 22:30, 23:00, 23:30, 23.59]
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static List<String> getHotelCheckDate() {
		List<String> list = new ArrayList<String>();
		for (int i = 8; i < 24; i++) {
			if (i < 10) {
				StringBuffer hour = new StringBuffer();
				hour.append("0" + i + ":00");
				list.add(hour.toString());
				StringBuffer halfHour = new StringBuffer();
				halfHour.append("0" + i + ":30");
				list.add(halfHour.toString());
			} else {
				StringBuffer hour = new StringBuffer();
				hour.append(i + ":00");
				list.add(hour.toString());
				StringBuffer halfHour = new StringBuffer();
				halfHour.append(i + ":30");
				list.add(halfHour.toString());
			}
		}
		list.add("23.59");
		return list;
	}

	protected static Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * 获取系统时间在各个时区的当地时间 <br>
	 * @param timeZoneOffset 表示时区 ，如中国一般使用东八区，因此timeZoneOffset就是8
	 * @return  输入时区的当前时间
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getFormatedDateString(int timeZoneOffset) {
		if (timeZoneOffset > 13 || timeZoneOffset < -12) {
			timeZoneOffset = 0;
		}
		TimeZone timeZone;
		String[] ids = TimeZone
				.getAvailableIDs(timeZoneOffset * 60 * 60 * 1000);
		if (ids.length == 0) {
			// if no ids were returned, something is wrong. use default TimeZone
			timeZone = TimeZone.getDefault();
		} else {
			timeZone = new SimpleTimeZone(timeZoneOffset * 60 * 60 * 1000,
					ids[0]);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(timeZone);
		return sdf.format(new Date());
	}

	/**
	 * 
	 * 获取系统时间在各个时区的当地时间 格式如：22/10/2015 05:49 EDT <br>
	 * @param _timeZone (时区)
	 * @return 指定格式的时间
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getFormatedDateString(String _timeZone) {
		return getFormatedDateString(null,"US/Eastern");
	}
	/**
	 * 
	 * 获取输入时间在各个时区的当地时间 格式如：22/10/2015 05:49 EDT <br>
	 * @param _timeZone (时区)
	 * @return 指定格式的时间
	 * @author Hunter
	 * @since [1.0.0]
	 * @version [1.0.0,2015年10月22日]
	 */
	public static String getFormatedDateString(Date date, String _timeZone) {
		TimeZone timeZone = null;
		if (StringUtils.isEmpty(_timeZone)) {
			timeZone = TimeZone.getDefault();
		} else {
			timeZone = TimeZone.getTimeZone(_timeZone);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm z");
		sdf.setTimeZone(timeZone);
		if(date==null)
		{
		return sdf.format(new Date());
		}else
		{
			return sdf.format(date);
		}
	}

	
	public static void printSysProperties() {
		Properties props = System.getProperties();
		Iterator iter = props.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			System.out.println(key + " = " + props.get(key));
		}
	}
	public static void main(String[] args) {
//		System.out.println(getFormatedDateString("US/Eastern"));
//		System.out.println(getFormatedDateString("Asia/Shanghai"));
//		System.out.println(getFormatedDateString("Japan"));
//		System.out.println(getFormatedDateString("Europe/Madrid"));
//		System.out.println(getFormatedDateString("GMT+8:00"));
//		printSysProperties();
		System.out.println(new Date());
		System.out.println(getHotelCheckDate());
		//printSysProperties();
		/*
		 * Date date = DatetimeUtils.parseDateByStr("2010-12-28 10:10:10",
		 * "yyyy-MM-dd HH:mm:ss"); Date date2 =
		 * DatetimeUtils.parseDateByStr("2010-12-29 10:10:10",
		 * "yyyy-MM-dd HH:mm:ss");
		 */
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start_date=new Date();
		start_date.setYear(2017-1900);
		start_date.setMonth(10);
		start_date.setDate(5);
//		Date end_date=new Date();
//		end_date.setYear(2018);
//		end_date.setMonth(0);
//		end_date.setDate(4);
//		System.out.println(DateUtil.getIntervalDays(start_date,end_date));
		Date end_date=DateUtil.addDate(start_date,60);
		System.out.println(format.format(end_date));

	}
}
