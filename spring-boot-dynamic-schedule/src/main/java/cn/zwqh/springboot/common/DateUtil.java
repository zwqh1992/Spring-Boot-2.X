package cn.zwqh.springboot.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * 说明 :时间帮助类
 * 
 * @author 朝雾轻寒
 * @version 创建时间：2017-10-3 上午11:32:51
 * 
 */
public class DateUtil {
	private static SimpleDateFormat dateformat = new SimpleDateFormat();

	/**
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss格式
	 */
	public static String formatDateTime(Date date) {
		if (date == null)
			return "";
		dateformat.applyPattern("yyyy-MM-dd HH:mm:ss");
		return dateformat.format(date);
	}

	/**
	 * @param date
	 * @return yyyy-MM-dd格式
	 */
	public static String formatDate(Date date) {
		if (date == null)
			return "";
		dateformat.applyPattern("yyyy-MM-dd");
		return dateformat.format(date);
	}

	/**
	 * @param date
	 * @return HH:mm:ss格式
	 */
	public static String formatTime(Date date) {
		if (date == null)
			return "";
		dateformat.applyPattern("HH:mm:ss");
		return dateformat.format(date);
	}

	/**
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss.S格式
	 */
	public static String formatDateDetailTime(Date date) {
		if (date == null)
			return "";
		dateformat.applyPattern("yyyy-MM-dd HH:mm:ss.S");
		return dateformat.format(date);
	}

	/**
	 * @param date
	 * @return yyyy-MM格式
	 */
	public static String formatYearMonth(Date date) {
		if (date == null)
			return "";
		dateformat.applyPattern("yyyy-MM");
		return dateformat.format(date);
	}

	/**
	 * 根据用户提供的格式模式格式化日期
	 * 
	 * @param date
	 * @param pattern "yyyy.MM.dd G 'at' HH:mm:ss z" 2001.07.04 AD at 12:08:56 PDT
	 *                "EEE, MMM d, ''yy" Wed, Jul 4, '01 "h:mm a" 12:08 PM "hh
	 *                'o''clock' a, zzzz" 12 o'clock PM, Pacific Daylight Time "K:mm
	 *                a, z" 0:08 PM, PDT "yyyyy.MMMMM.dd GGG hh:mm aaa"
	 *                02001.July.04 AD 12:08 PM "EEE, d MMM yyyy HH:mm:ss Z" Wed, 4
	 *                Jul 2001 12:08:56 -0700 "yyMMddHHmmssZ" 010704120856-0700
	 *                "yyyy-MM-dd'T'HH:mm:ss.SSSZ" 2001-07-04T12:08:56.235-0700
	 * @return
	 */
	public static String formatUserDefineDate(Date date, String pattern) {
		if (date == null)
			return "";
		dateformat.applyPattern(pattern);
		return dateformat.format(date);
	}

	/**
	 * 根据用户提供的格式模式格式化日期
	 * 
	 * @param date
	 * @param pattern "yyyy.MM.dd G 'at' HH:mm:ss z" 2001.07.04 AD at 12:08:56 PDT
	 *                "EEE, MMM d, ''yy" Wed, Jul 4, '01 "h:mm a" 12:08 PM "hh
	 *                'o''clock' a, zzzz" 12 o'clock PM, Pacific Daylight Time "K:mm
	 *                a, z" 0:08 PM, PDT "yyyyy.MMMMM.dd GGG hh:mm aaa"
	 *                02001.July.04 AD 12:08 PM "EEE, d MMM yyyy HH:mm:ss Z" Wed, 4
	 *                Jul 2001 12:08:56 -0700 "yyMMddHHmmssZ" 010704120856-0700
	 *                "yyyy-MM-dd'T'HH:mm:ss.SSSZ" 2001-07-04T12:08:56.235-0700
	 * @return
	 */
	public static String formatUserDefineDate(String date, String pattern) {
		if (date == null)
			return "";
		dateformat.applyPattern(pattern);
		date = date.replaceAll("-", "/");
		Date date1 = new Date(date);
		return dateformat.format(date1);
	}

	/**
	 * 
	 * @param datestring ig: 2007-11-08
	 * @return date
	 */
	@SuppressWarnings("deprecation")
	public static Date convertStringToDate(String datestring) {
		Date date = null;
		try {
			datestring = datestring.replaceAll("-", "/");
			date = new Date(datestring);
		} catch (Exception e) {
			date = null;
		}
		return date;
	}

	/**
	 * 
	 * 说明 :设置日期中的日
	 */
	public static Date setDay(Date source, int num) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(source);
			c.set(c.DAY_OF_MONTH, num);
			return c.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * 说明 :设置日期中的月
	 */
	public static Date setMonth(Date source, int num) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(source);
			c.set(c.MONTH, num);
			return c.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 日期加减操作
	 * 
	 * @param source 源日期
	 * @param num    推迟天数 + 为往后 - 为往前
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Date dateRoler(Date source, int num) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(source);
			c.add(c.DAY_OF_MONTH, num);
			return c.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 月份加减操作
	 * 
	 * @param source 源日期
	 * @param num    推迟月份 + 为往后 - 为往前
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Date monthRoler(Date source, int num) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(source);
			c.add(c.MONTH, num);
			return c.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 计算两日期之间相差的天数 day1 -day2
	 * 
	 * @param day1
	 * @param day2
	 * @return
	 * @throws ParseException
	 */
	public static int countDays(String day1, String day2) {

		if (day1 != null && day2 != null && day1.length() > 0 && day2.length() > 0) {
			// 日期相减算出秒的算法
			Date date1 = convertStringToDate(day1);
			Date date2 = convertStringToDate(day2);
			// 日期相减得到相差的日期
			long day = (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);
			return (int) day;
		} else {
			return 0;
		}

	}

	/**
	 * 计算两日期之间相差的天数 day1-day2
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int countDays(Date date1, Date date2) {
		if (date1 == null || date2 == null)
			return 0;
		long day = (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);
		return (int) day;
	}

	/**
	 * 
	 * 说明 :比较date1是否在date2之前
	 */
	public static boolean before(String date1, Date date2) {
		if (date1 == null || date2 == null)
			return false;
		return before(DateUtil.convertStringToDate(date1), date2);
	}

	/**
	 * 
	 * 说明 :比较date1是否在date2之前
	 */
	public static boolean before(Date date1, String date2) {
		if (date1 == null || date2 == null)
			return false;
		return before(date1, DateUtil.convertStringToDate(date2));
	}

	/**
	 * 
	 * 说明 :比较date1是否在date2之前
	 */
	public static boolean before(String date1, String date2) {
		if (date1 == null || date2 == null)
			return false;
		return before(DateUtil.convertStringToDate(date1), DateUtil.convertStringToDate(date2));
	}

	/**
	 * 
	 * 说明 :比较date1是否在date2之前
	 */
	public static boolean before(Date date1, Date date2) {
		if (date1 == null || date2 == null)
			return false;
		Calendar _d1 = Calendar.getInstance();
		Calendar _d2 = Calendar.getInstance();
		_d1.setTime(date1);
		_d2.setTime(date2);
		return _d1.before(_d2);
	}

	public static String getDatePart(String dateTimeStr) {
		if (dateTimeStr == null)
			return "";
		else if (dateTimeStr.length() <= 10)
			return dateTimeStr;
		else
			return dateTimeStr.substring(0, 10);
	}

	public static String getNowDateTime() {
		return formatDateTime(new Date());
	}

	public static String getNowDate() {
		return formatDate(new Date());
	}

	public static String getNowDate(String fmt) {
		return formatUserDefineDate(new Date(), fmt);
	}

	/**
	 * 取得当前日期是多少周
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);

		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 取得当前日期是多少周
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear() {
		return getWeekOfYear(new Date());
	}

	/**
	 * 得到某一年周的总数
	 * 
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

		return getWeekOfYear(c.getTime());
	}

	/**
	 * 得到某年某周的第一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getFirstDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getFirstDayOfWeek(cal.getTime());
	}

	/**
	 * 得到某年某周的最后一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getLastDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getLastDayOfWeek(cal.getTime());
	}

	/**
	 * 取得指定日期所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return formatDate(c.getTime());
	}

	/**
	 * 取得指定日期所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return formatDate(c.getTime());
	}

	/**
	 * 取得当前日期所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfWeek() {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return formatDate(c.getTime());
	}

	/**
	 * 取得当前日期所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getLastDayOfWeek() {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return formatDate(c.getTime());
	}
}
