package com.dft.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.util.Assert;


/**
 * 
 * <P>日期处理的支持类</P>
 * 
 * @version 1.0
 * @author 林仙龙（15361632946） 2013-10-11 下午3:21:36
 */
public class DateUtils {

	private DateUtils() {

	}

	private static final String FORMAT_YM = "yyyy-MM";
	private static final String FORMAT_YMD = "yyyyMMdd";
	private static final String FORMAT_YMD_NEW = "yyyy-MM-dd";
	private static final String FORMAT_YMDMS = "yyyyMMddHH:mm";
	private static final String FORMAT_HMS = "HHmmss";
	private static final String FORMAT_HM = "HH:mm";
	private static final String FORMAT_YMDHMS = "yyyyMMddHHmmss";
	private static final String FORMAT_YMDHM = "yyyyMMddHHmm";
	private static final String FORMAT_YMDHMS_FRONT = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMAT_YMDHM_FRONT = "yyyy-MM-dd HH:mm";
	private static final String FORMAT_YMDHM_CHINA = "yyyy年MM月dd日 HH:mm";
	public static final String YM = "yyyyMM";
	public static final String YM_NEW = "yyyy-MM";
	public static final String YMD = "yyyy-MM-dd";
	public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
	public static final String YMDHM = "yyyy-MM-dd HH:mm";
	public static final String HMS = "HHmmss";
	public static final String H = "HH";
	public static final String MMDD = "MMdd";
	public static final String Y = "yyyy";
	public static final String M = "MM";
	public static final String S = "ss";
	public static final String D = "dd";
	public static final String m = "mm";
	public static final String MM_DD = "MM-dd";
	private static final String FORMAT_YMD_CHINA = "yyyy年MM月dd日";

	// 节假日列表
	private static List<Calendar> holidayList = new ArrayList<Calendar>();

	// 周末为工作日
	private static List<Calendar> weekendList = new ArrayList<Calendar>();

	public static final String YYYYMM = "yyyy-MM";

	/**
	 * 
	 * <p>将字符串时间格式转成成Date</p><p>支持的格式有：<br/>
	 * yyyyMMddHH:mm<br/>HH:mm<br/>yyyyMMddHHmmss<br/>yyyyMMdd<br/>yyyy-MM-dd HH:mm:ss</p>
	 * 
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateFromString(final String time) throws ParseException {
		return org.apache.commons.lang3.time.DateUtils.parseDate(time, new String[] { FORMAT_YMD_NEW, FORMAT_YMDMS,
				FORMAT_HM, FORMAT_YMDHMS, FORMAT_YMD, FORMAT_YMDHMS_FRONT, YMDHM, YMD, YM_NEW, Y });
	}

	/**
	 * <p>获取当前年月日字符串</p>
	 * 
	 * @return
	 */
	public static String getCurrentYMD() {
		return DateFormatUtils.format(new Date(), FORMAT_YMD);
	}

	/**
	 * 
	 * <p>获取当前年月日字符串</p>
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getCurrentYMDNew() {
		return DateFormatUtils.format(new Date(), FORMAT_YMD_NEW);
	}

	/**
	 * <p>获取当前年月日字符串 yyyy-MM-dd HH:mm</p>
	 * 
	 * @return
	 */
	public static String getYMDHM() {
		return DateFormatUtils.format(new Date(), YMDHM);
	}

	public static String getYMDHM(Date date) {
		return DateFormatUtils.format(date, YMDHM);
	}

	/**
	 * 
	 * <p>获取当前时间:yyyy-MM-dd HH:mm:ss</p>
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		return DateFormatUtils.format(new Date(), FORMAT_YMDHMS_FRONT);
	}

	/**
	 * 
	 * <p>获取当前时间时分秒</p>
	 * 
	 * @return
	 */
	public static String getCurrentHMS() {
		return DateFormatUtils.format(new Date(), HMS);
	}

	/**
	 * 
	 * <p>获取当前时间时</p>
	 * 
	 */
	public static String getCurrentH() {
		return DateFormatUtils.format(new Date(), H);
	}

	/**
	 * <p>获取MMDD日期格式</p>
	 * 
	 * @return
	 * @user 2015-7-1 上午9:05:24
	 * @return String
	 */
	public static String getCurrentMMDD() {
		return DateFormatUtils.format(new Date(), MMDD);
	}

	/**
	 * 
	 * <p>获取当前时间:yyyyMMddHHmm</p>
	 * 
	 * @return
	 */
	public static String getCurrentYMDHM() {
		return DateFormatUtils.format(new Date(), FORMAT_YMDHM);
	}

	/**
	 * <p>获取当前时间HMS字符串，格式为HHmmss</p>
	 * 
	 * @return SimpleDateFormat格式化为HHmmss的字符串
	 */
	public static String getCurrentTime() {
		return DateFormatUtils.format(new Date(), FORMAT_HMS);
	}

	/**
	 * <p>获取当前年月,格式为yyyyMM</p>
	 * 
	 * @return
	 */
	public static String getCurrentYM() {
		return DateFormatUtils.format(new Date(), YM);
	}

	public static String getCurrentYMNew() {
		return DateFormatUtils.format(new Date(), YM_NEW);
	}

	/**
	 * <p>获取当前日期YMD字符串，格式为yyyyMMdd</p>
	 * 
	 * @return SimpleDateFormat格式化为yyyyMMdd的字符串
	 */
	public static String getYMDDate(final Date date) {
		return DateFormatUtils.format(date, FORMAT_YMD);
	}

	/**
	 * <p>获取当前日期YMD字符串，格式为yyyy-MM-dd</p>
	 * 
	 * @param date
	 * @return
	 * @version V1.0
	 */
	public static String getDateYMD(final Date date) {
		return DateFormatUtils.format(date, YMD);
	}

	/**
	 * <p>获取当前日期YMD字符串，格式为yyyy-MM-dd HH:mm:ss</p>
	 * 
	 * @param date
	 * @return
	 * @version V1.0
	 */
	public static String getDateYMDHMS(final Date date) {
		return DateFormatUtils.format(date, YMDHMS);
	}

	/**
	 * <p>获取当前日期 格式为yyyy-MM </p>
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateYM(final Date date) {
		return DateFormatUtils.format(date, FORMAT_YM);
	}

	/**
	 * <p>获取当前日期YM字符串，格式为yyyyMM</p>
	 * 
	 * @return SimpleDateFormat格式化为yyyyMM的字符串
	 */
	public static String getYMDate(final Date date) {
		return DateFormatUtils.format(date, YM);
	}

	/**
	 * 
	 * <p>获取当前日期YM字符串，格式为yyyy年MM月</p>
	 * 
	 */
	public static String getYYYYMMDate(final Date date) {
		return DateFormatUtils.format(date, YYYYMM);
	}

	/**
	 * <p>获取当前日期YM字符串，格式为yyyy</p>
	 * 
	 * @return SimpleDateFormat格式化为yyyyMM的字符串
	 */
	public static String getYDate(final Date date) {
		return DateFormatUtils.format(date, Y);
	}

	/**
	 * <p>获取对应的Date的格式yyyyMMddHHmmss</p>
	 * 
	 * @param date 传入的日期
	 * @return SimpleDateFormat格式化为yyyyMMddHHmmss的字符串
	 */
	public static String getDateTime(final Date date) {
		if (date == null)
			return null;
		return DateFormatUtils.format(date, FORMAT_YMDHMS);
	}

	/**
	 * 
	 * <p>获取对应的Date的格式HH</p>
	 * 
	 */
	public static String getHTime(final Date date) {
		if (date == null)
			return null;
		return DateFormatUtils.format(date, H);
	}

	/**
	 * <p>获取对应的Date的格式yyyy-MM-dd HH:mm:ss</p>
	 * 
	 * @param date 传入的日期
	 * @return SimpleDateFormat格式化为yyyy-MM-dd HH:mm:ss的字符串
	 */
	public static String getYMDHMSDateTime(final Date date) {
		if (date == null)
			return null;
		return DateFormatUtils.format(date, FORMAT_YMDHMS_FRONT);
	}

	/**
	 * <p>获取对应的Date的格式yyyy-MM-dd HH:mm</p>
	 * 
	 * @param date
	 * @return
	 */
	public static String getYMDHMDateTime(final Date date) {
		if (date == null)
			return null;
		return DateFormatUtils.format(date, FORMAT_YMDHM_FRONT);
	}

	/**
	 * 
	 * <p>yyyyMMdd to yyyyMMddHHmmss</p>
	 * 
	 * @param ymd
	 * @return
	 * @throws ParseException
	 */
	public static String parseDateYMDToString(final String ymd) throws ParseException {
		Assert.hasText(ymd, "参数为空:" + ymd);
		return DateTimeFormat.forPattern(FORMAT_YMD).parseDateTime(ymd).toString(FORMAT_YMDHMS);
	}

	/**
	 * <p>yyyyMMdd to yyyy-MM</p>
	 * 
	 * @param ymd
	 * @return
	 * @throws ParseException
	 */
	public static String parseDateYMToString(final String ymd) throws ParseException {
		Assert.hasText(ymd, "参数为空:" + ymd);
		return DateTimeFormat.forPattern(FORMAT_YMD).parseDateTime(ymd).toString(FORMAT_YM);
	}

	/**
	 * <p>yyyy-MM-dd to yyyyMM</p>
	 * 
	 * @param ymd
	 * @return
	 * @throws ParseException
	 */
	public static String parseYMToString(final String ymd) throws ParseException {
		Assert.hasText(ymd, "参数为空:" + ymd);
		return DateTimeFormat.forPattern(YMD).parseDateTime(ymd).toString(YM);
	}

	/**
	 * 
	 * <p>yyyyMMddHHmmss转换成yyyyMMdd</p>
	 * 
	 * @param ymdhms
	 * @return
	 * @throws ParseException
	 */
	public static String parseStringYMD(final String ymdhms) throws ParseException {
		Assert.hasText(ymdhms, "参数为空:" + ymdhms);
		return DateTimeFormat.forPattern(FORMAT_YMDHMS).parseDateTime(ymdhms).toString(FORMAT_YMD);
	}

	/**
	 * <p>按照yyyyMMddHHmmSS返回yyyy-MM-dd HH:mm:ss</p>
	 * 
	 * @param ymdhms
	 * @return
	 * @throws ParseException
	 */
	public static String parseDateYMDHMSFront(final String ymdhms) throws ParseException {
		Assert.hasText(ymdhms, "参数为空:" + ymdhms);
		return DateTimeFormat.forPattern(FORMAT_YMDHMS).parseDateTime(ymdhms).toString(FORMAT_YMDHMS_FRONT);
	}

	/**
	 * <p>按照yyyy-MM-dd HH:mm:ss返回yyyyMMdd</p>
	 * 
	 * @param ymdhms
	 * @return
	 * @throws ParseException
	 */
	public static String parseDateYMDFront(final String ymdhms) throws ParseException {
		Assert.hasText(ymdhms, "参数为空:" + ymdhms);
		return DateTimeFormat.forPattern(FORMAT_YMDHMS_FRONT).parseDateTime(ymdhms).toString(FORMAT_YMD);
	}

	/**
	 * <p>按照yyyy-MM-dd返回yyyyMMdd</p>
	 * 
	 * @param ymd
	 * @return
	 * @throws ParseException
	 */
	public static String parseYMDFront(final String ymd) throws ParseException {
		Assert.hasText(ymd, "参数为空:" + ymd);
		return DateTimeFormat.forPattern(YMD).parseDateTime(ymd).toString(FORMAT_YMD);
	}

	/**
	 * <p>按照yyyyMMdd返回yyyy-MM-dd</p>
	 * 
	 * @param ymd
	 * @return
	 * @throws ParseException
	 */
	public static String parseYMDFrontStr(final String ymd) throws ParseException {
		Assert.hasText(ymd, "参数为空:" + ymd);
		return DateTimeFormat.forPattern(FORMAT_YMD).parseDateTime(ymd).toString(YMD);
	}

	/**
	 * <p>用于计算下一天的时间</p>
	 * 
	 * @param orgCutDayTime 当前时间，精确到天级别 yyyyMMdd
	 * @return 第二天
	 * @throws ParseException
	 */
	public static String calculateNextDay(final String orgCutDayTime) throws ParseException {
		return calculateNextNDay(orgCutDayTime, 1);
	}

	/**
	 * <p>用于计算前一天的时间</p>
	 * 
	 * @param orgTime 当前时间，精确到天级别 calculateNextNDay yyyyMMdd
	 * @return 前一天时间
	 * @throws ParseException
	 */
	public static String calculatePreDay(final String orgTime) throws ParseException {
		return calculateNextNDay(orgTime, -1);
	}

	/**
	 * <p>用于计算前一天的时间</p>
	 * 
	 * @param orgTime 当前时间，精确到天级别 calculateNextNDay yyyyMMdd
	 * @return 前一天时间
	 * @throws ParseException
	 */
	public static Date calculatePreDayDate(final String orgTime) throws ParseException {
		String calculateNextNDay = calculateNextNDay(orgTime, -1);
		return getDateFromString(calculateNextNDay);
	}

	/**
	 * <p>用于计算前几天的时间</p>
	 * 
	 * @param orgTime 当前时间，精确到天级别 yyyyMMdd
	 * @return 前几天时间
	 * @throws ParseException
	 */
	public static String calculatePreNDay(final String orgTime, int preNum) throws ParseException {
		return calculateNextNDay(orgTime, -preNum);
	}

	/**
	 * <p>用于某日期加几分钟</p>
	 * 
	 * @param orgCutDayTime 当前时间，精确到天级别 yyyy-MM-dd HH:mm
	 * @return 第N天
	 * @throws ParseException
	 */
	public static String calculateNextNMinutes(final Date orgCutDayTime, int minutes) throws ParseException {
		String format = DateFormatUtils.format(orgCutDayTime, FORMAT_YMDHM_FRONT);
		return DateTimeFormat.forPattern(FORMAT_YMDHM_FRONT).parseDateTime(format).plusMinutes(minutes)
				.toString(FORMAT_YMDHM_FRONT);
	}

	/**
	 * <p>用于某日期加几分钟</p>
	 * 
	 * @param orgCutDayTime 当前时间，精确到天级别 yyyy-MM-dd HH:mm:ss
	 * @param minutes 分钟
	 * @return yyyy-MM-dd HH:mm:ss
	 * @throws ParseException
	 */
	public static String calculateNextNMinutesYMDHMS(final Date orgCutDayTime, int minutes) throws ParseException {
		String format = DateFormatUtils.format(orgCutDayTime, FORMAT_YMDHMS_FRONT);
		return DateTimeFormat.forPattern(FORMAT_YMDHMS_FRONT).parseDateTime(format).plusMinutes(minutes)
				.toString(FORMAT_YMDHMS_FRONT);
	}

	/**
	 * <p>用于某日期加几个小时</p>
	 * 
	 * @param orgCutDayTime 当前时间，精确到天级别 yyyy-MM-dd HH:mm
	 * @return 第N天
	 * @throws ParseException
	 */
	public static String calculateNextNHours(final Date orgCutDayTime, int hours) throws ParseException {
		String format = DateFormatUtils.format(orgCutDayTime, FORMAT_YMDHM_FRONT);
		return DateTimeFormat.forPattern(FORMAT_YMDHM_FRONT).parseDateTime(format).plusHours(hours)
				.toString(FORMAT_YMDHM_FRONT);
	}

	/**
	 * <p>用于某日期加几个小时</p>
	 * 
	 * @param orgCutDayTime 当前时间，精确到天级别 yyyyMMdd
	 * @return 第N天
	 * @throws ParseException
	 */
	public static String calculateNextNHours(final String orgCutDayTime, int hours) throws ParseException {
		return DateTimeFormat.forPattern(FORMAT_YMD).parseDateTime(orgCutDayTime).plusHours(hours).toString(FORMAT_YMD);
	}

	/**
	 * <p>用于某日期加几天</p>
	 * 
	 * @param orgCutDayTime 当前时间，精确到天级别 yyyyMMdd
	 * @return 第N天
	 * @throws ParseException
	 */
	public static String calculateNextNDay(final String orgCutDayTime, int nextDay) throws ParseException {
		return DateTimeFormat.forPattern(FORMAT_YMD).parseDateTime(orgCutDayTime).plusDays(nextDay)
				.toString(FORMAT_YMD);
	}

	/**
	 * 
	 * <p>用于某日加几个月</p>
	 * 
	 */
	public static String calculateNextNMonth(final String orgCutDayTime, int nextMonth) throws ParseException {

		return DateTimeFormat.forPattern(FORMAT_YMD).parseDateTime(orgCutDayTime).plusMonths(nextMonth)
				.toString(FORMAT_YMD);
	}

	/**
	 * 
	 * <p>用于某日加几个月</p>
	 * 
	 * @author
	 */
	public static String calculateNextMonthYM(final String orgCutDayTime, int nextMonth) throws ParseException {

		return DateTimeFormat.forPattern(FORMAT_YM).parseDateTime(orgCutDayTime).plusMonths(nextMonth)
				.toString(FORMAT_YM);
	}

	/**
	 * 
	 * <p>用于某日几个月</p>
	 * 
	 * @author
	 */
	public static String calculatePreMonthYM(final String orgCutDayTime, int preMonth) throws ParseException {

		return DateTimeFormat.forPattern(FORMAT_YM).parseDateTime(orgCutDayTime).minusMonths(preMonth)
				.toString(FORMAT_YM);
	}

	/**
	 * 
	 * <p>用于某日加几年</p>
	 * 
	 */
	public static String calculateNextNYear(final String orgCutDayTime, int nextMonth) throws ParseException {
		return DateTimeFormat.forPattern(FORMAT_YMD).parseDateTime(orgCutDayTime).plusYears(nextMonth)
				.toString(FORMAT_YMD);
	}

	/**
	 * 
	 * <p>得到当前日期+天数</p>
	 * 
	 * @return yyyyMMdd
	 */
	public static String getNextYMRByDay(final int nextDay) {
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, nextDay);
		return DateFormatUtils.format(calendar, FORMAT_YMD);
	}

	/**
	 * 
	 * <p>得到当前日期+天数</p>
	 * 
	 * @return yyyyMMddHHmmss
	 */
	public static String getNextYMDHMSByDay(final int nextDay) {
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, nextDay);
		return DateFormatUtils.format(calendar, FORMAT_YMDHMS_FRONT);
	}

	/**
	 * 
	 * <p>得到当前日期+天数</p>
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getNextYMDByDay(final int nextDay) {
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, nextDay);
		return DateFormatUtils.format(calendar, FORMAT_YMD_NEW);
	}

	/**
	 * 
	 * <p>前一个月最后一天</p>
	 * 
	 * @return yyyyMMdd
	 */
	public static String getPreMonLastDay() {
		DateTime now = new DateTime();
		DateTime nextMouthLastDay = now.plusMonths(-1).dayOfMonth().withMaximumValue();
		return nextMouthLastDay.toString(FORMAT_YMD);
	}

	/**
	 * 
	 * <p>获取最后一天</p>
	 * 
	 * @return yyyyMMdd
	 */
	public static String getMonLastDay(Date date) {
		DateFormat dbFromat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = dbFromat.format(calendar.getTime());
		return last;
	}

	/**
	 * 
	 * <p>前一个月的第一天</p>
	 * 
	 * @return yyyyMMdd
	 */
	public static String getPreMonFirstDay() {
		DateTime now = new DateTime();
		DateTime nextMouthLastDay = now.plusMonths(-1).dayOfMonth().withMinimumValue();
		return nextMouthLastDay.toString(FORMAT_YMD);
	}

	/**
	 * 
	 * <p>获取当前月的第一天</p>
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getCurrentMonFirstDay() {
		DateTime now = new DateTime();
		DateTime nextMouthLastDay = now.plusMonths(0).dayOfMonth().withMinimumValue();
		return nextMouthLastDay.toString(YMD);
	}

	/**
	 * 
	 * <p>获取当前月的最后一天</p>
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getCurrentMonLastDay() {
		DateTime now = new DateTime();
		DateTime nextMouthLastDay = now.plusMonths(0).dayOfMonth().withMaximumValue();
		return nextMouthLastDay.toString(YMD);
	}

	/**
	 * 
	 * <p>获取当前季度</p>
	 * 
	 * @param date
	 * @return
	 */
	public static int getQuarter(Date date) {
		// 取得日历
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int mouth = calendar.get(Calendar.MONTH) + 1;// 上季度的月份
		// 根据月份,判断是哪个季度
		if (mouth == 1 || mouth == 2 || mouth == 3) {
			return 1;
		} else if (mouth == 4 || mouth == 5 || mouth == 6) {
			return 2;
		} else if (mouth == 7 || mouth == 8 || mouth == 9) {
			return 3;
		} else {
			return 4;
		}
	}

	/**
	 * 
	 * <p>昨天零点</p>
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getYesterdayZero() {
		DateTime now = new DateTime();
		return now.minusDays(1).toString(YMD) + " 00:00:00";
	}

	/**
	 * 
	 * <p>今天零点</p>
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getTodayZero() {
		DateTime now = new DateTime();
		return now.toString(YMD) + " 00:00:00";
	}

	/**
	 * 
	 * <p>判断两个时间是否在当前之内</p>
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean nowBetween(Date startDate, Date endDate) {
		DateTime now = new DateTime();
		return now.isAfter(new DateTime(startDate)) && now.isBefore(new DateTime(endDate));
	}

	/**
	 * 
	 * <p>当前天数+年数</p>
	 * 
	 * @param nextYear
	 * @return
	 */
	public static String getNextYMRByYear(final int nextYear) {
		DateTime now = new DateTime();
		return now.minusYears(nextYear).toString(FORMAT_YMD);
	}

	/**
	 * <p>当前的时间 + 年数</p>
	 * 
	 * @param date 当前时间
	 * @param years 年数
	 * @return
	 * @version V1.0
	 */
	public static final Date addYears(Date date, int years) {
		if (date == null) {
			return null;
		}
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.YEAR, years);
		return cal.getTime();
	}

	/**
	 * 
	 * <p>获取当前秒数</p>
	 * 
	 * @return
	 */
	public static int getTimeSecond(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int hour = ca.get(Calendar.HOUR_OF_DAY);// 24小时制
		int minute = ca.get(Calendar.MINUTE);// 分
		int second = ca.get(Calendar.SECOND);// 秒
		int sum = hour * 60 * 60 + minute * 60 + second;
		return sum;
	}

	/**
	 * <p>获取与当前时间相差的秒数</p>
	 * 
	 * @param dateStart 时间
	 * @return
	 * @throws ParseException
	 */
	public static long timeDiff(Date dateStart) throws ParseException {
		// 秒
		long diff = (new Date().getTime() - dateStart.getTime()) / 1000;
		return diff;
	}

	/**
	 * 获取对应日期是星期几 <p>TODO</p>
	 * 
	 * @return
	 * @user 2015-6-29 下午4:08:42
	 * @return int
	 */
	public static int getWeekDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 
	 * <p>获取对应日期是星期几</p>
	 * 
	 * @param dt
	 * @return
	 */
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		// 返回0-6，从0开始，0是星期天
		int weekNum = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (weekNum < 0)
			weekNum = 0;
		return weekDays[weekNum];
	}

	/**
	 * <p>格式时间 返回 例如 ：2016年10月27日 22:48</p>
	 * 
	 * @param date
	 * @return
	 */
	public static String getChinaDate(Date date) {
		if (null == date)
			date = new Date();
		return DateFormatUtils.format(date, FORMAT_YMDHM_CHINA);
	}

	/**
	 * 返回二个时间相差的分分钟数,如果一个为空，返回为0；
	 * 
	 * @param startDate，eg:2016-12-24 11:50
	 * @param endDate，eg:2016-12-24 11:20
	 * @return
	 * @throws Exception
	 */
	public static long getMinutesDiff(String startDate, String endDate) throws Exception {
		long ret = 0l;
		if (StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)) {
			return ret;
		} else {
			Date dateFromStr = DateUtils.getDateFromString(startDate);
			Date endDateStr = DateUtils.getDateFromString(endDate);
			ret = ((dateFromStr.getTime() - endDateStr.getTime()) / 1000) / 60;

		}
		return ret;
	}

	/**
	 * 
	 * <p>返回二个时间相差的秒数,如果一个为空，返回为0</p>
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public static long getSecondsDiff(String startDate, String endDate) throws Exception {
		long ret = 0l;
		if (StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)) {
			return ret;
		} else {
			Date dateFromStr = DateUtils.getDateFromString(startDate);
			Date endDateStr = DateUtils.getDateFromString(endDate);
			ret = ((dateFromStr.getTime() - endDateStr.getTime()) / 1000);

		}
		return ret;
	}

	/**
	 * <p>是否是同一天</p>
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isSameDayWithToday(Date date) {
		if (date == null) {
			return false;
		}
		Calendar todayCal = Calendar.getInstance();
		Calendar dateCal = Calendar.getInstance();
		todayCal.setTime(new Date());
		dateCal.setTime(date);
		int subYear = todayCal.get(Calendar.YEAR) - dateCal.get(Calendar.YEAR);
		int subMouth = todayCal.get(Calendar.MONTH) - dateCal.get(Calendar.MONTH);
		int subDay = todayCal.get(Calendar.DAY_OF_MONTH) - dateCal.get(Calendar.DAY_OF_MONTH);
		if (subYear == 0 && subMouth == 0 && subDay == 0) {
			return true;
		}
		return false;
	}

	public static void main(String arg[]) throws Exception {
		// Date nowTime = DateUtils.getDateFromString("2019-02-26 01:12");
		// Date startTime = DateUtils.getDateFromString("2019-02-26 00:00");
		// Date endTime = DateUtils.getDateFromString("2019-02-26 02:02");

		// String calculateNextMonthYM = DateUtils.getNextYMDHMSByDay(1);
		// System.out.println(calculateNextMonthYM);

		// Date dateFromString = DateUtils.getDateFromString("2020-03-15 20:00:00");
		// System.out.println(dateFromString.getTime());

		// long minutesDiff = DateUtils.getMinutesDiff("2019-11-14 00:00:00".replace(".0", ""),
		// DateUtils.getCurrentYMDNew() + " 00:00:00");
		// System.out.println(minutesDiff);

		// Calendar calendar = Calendar.getInstance();
		// calendar.set(calendar.MONTH, 2);
		// int year = calendar.get(Calendar.YEAR);
		// int month = calendar.get(Calendar.MONTH) + 1;
		// int day = calendar.get(Calendar.DAY_OF_MONTH);
		// System.out.println(year + "-" + month + "-" + day);
		// isEffectiveDate(nowTime, startTime, endTime);
		// System.out.println(new Date());
		// System.out.println(DateUtils.getYMDHMDateTime(new Date()));
		// System.out.println(DateUtils.getCurrentYMDNew() + " 17:00");
		// System.out.println(DateUtils.getDateFromString(DateUtils.getYMDHMDateTime(new
		// Date())).getTime() < DateUtils
		// .getDateFromString(DateUtils.getCurrentYMDNew() + " 17:00").getTime());
	}

	/**
	 * 返回距离当天23:59:59还剩的秒数
	 * 
	 */
	public static long get24NodeToCurrentSenond() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date dayTime = calendar.getTime();
		Date nowTime = new Date();
		long timeDiff = (dayTime.getTime() - nowTime.getTime()) / 1000;
		return timeDiff;
	}

	/**
	 * <p>得到两个时间的相差月份</p>
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDifferMonths(String startDate, String endDate) throws Exception {
		int month = 0;
		Calendar bef = Calendar.getInstance();
		Calendar aft = Calendar.getInstance();
		bef.setTime(DateUtils.getDateFromString(startDate));
		aft.setTime(DateUtils.getDateFromString(endDate));
		int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
		int months = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
		month = (result + months);

		return month;
	}

	/**
	 * 
	 * <p>计算两个时间相差的秒数，并返回时分秒（倒计时）</p>
	 * 
	 */
	public static String timeDiff(Long dateStart, Long endDate) throws ParseException {
		// 毫秒
		long diff = endDate - dateStart;
		String remainingPayTime = null;
		if (diff > 0) {
			long hour = (diff / (60 * 60 * 1000));
			long minute = ((diff / (60 * 1000)) - hour * 60);
			String minuteStr = String.valueOf(minute);
			if (minute < 10) {
				minuteStr = "0" + minuteStr;
			}
			long second = (diff / 1000 - hour * 60 * 60 - minute * 60);
			String secondStr = String.valueOf(second);
			if (second < 10) {
				secondStr = "0" + secondStr;
			}
			remainingPayTime = hour + "小时" + minuteStr + "分" + secondStr + "秒";
		} else {
			remainingPayTime = 0 + "小时" + 00 + "分" + 00 + "秒";
		}
		return remainingPayTime;
	}

	/**
	 * 
	 * <p>将date类型时间，格式为yyyy-MM-dd HH:mm</p>
	 * 
	 */
	public static String getDateYMDHM(final Date date) {
		return DateFormatUtils.format(date, YMDHM);
	}

	/**
	 * 
	 * <p>判断当前签到时间是否合法</p>
	 * 
	 * @param amStart 上午开始时间
	 * @param amEnd 上午结束时间
	 * @param pmStart 下午开始时间
	 * @param pmEnd 下午结束时间
	 * @return boolean 合法性
	 */
	public static boolean isLegalCheckinDateStr(Date amStart, Date amEnd, Date pmStart, Date pmEnd) {
		if (null == amStart || null == amEnd || null == pmStart || null == pmEnd) {
			return false;
		}
		DateTime now = new DateTime();
		if ((!((now.isAfter(new DateTime(amStart)) && now.isBefore(new DateTime(amEnd)))
				|| (now.isAfter(new DateTime(pmStart)) && now.isBefore(new DateTime(pmEnd)))))
				|| getWeekDay(new Date()) == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * <p>获取今天早上9点09:00</p>
	 * 
	 */
	public static String getTodayNine() {
		DateTime now = new DateTime();
		return now.toString(YMD) + " 09:00:00";
	}

	/**
	 * 
	 * <p>获取今天早上12点 12:00</p>
	 * 
	 */
	public static String getTodayTwelve() {
		DateTime now = new DateTime();
		return now.toString(YMD) + " 12:00:00";
	}

	/**
	 * 
	 * <p>获取今天13:30</p>
	 * 
	 */
	public static String getHalfastThirteen() {
		DateTime now = new DateTime();
		return now.toString(YMD) + " 13:30:00";
	}

	/**
	 * 
	 * <p>获取今天17:30</p>
	 * 
	 */
	public static String getHalfastSeventeen() {
		DateTime now = new DateTime();
		return now.toString(YMD) + " 17:30:00";
	}

	/**
	 *
	 * <p>获取今天特定时间</p>
	 * 
	 * @param time 格式 12:00:00
	 */
	public static String getTodaySpecialTime(String time) {
		DateTime now = new DateTime();
		return now.toString(YMD) + " " + time;
	}

	/**
	 *
	 * <p>获取前天特定时间</p>
	 * 
	 * @param time 格式 12:00:00
	 */
	public static String getPreDaySpecialTime(String time) throws ParseException {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return getDateYMD(date) + " " + time;
	}

	/**
	 * 
	 * <p>获取当前的时间段上午工作时间段/下午工作时间段/非工作时间段</p>
	 * 
	 */
	public static Boolean getWorkTime() {
		// 当前时间段是否为工作时间
		Boolean timeSlot = true;
		try {
			Date time1 = getDateFromString(getTodayNine());
			Date time2 = getDateFromString(getTodayTwelve());
			// 判断当前时间是否在上午09:00-12:00之间
			Boolean morningBetween = nowBetween(time1, time2);

			// 判断当前时间是否在上午13:30-17:30之间
			Date time3 = getDateFromString(getHalfastThirteen());
			Date time4 = getDateFromString(getHalfastSeventeen());

			Boolean afternoonBttween = nowBetween(time3, time4);

			// 不是工作时间段
			if (!morningBetween && !afternoonBttween) {
				timeSlot = false;
			}

		} catch (ParseException e) {
		}

		return timeSlot;
	}

	/**
	 * 
	 * <p>判断日期是否为节假日</p>
	 * 
	 *
	 *         return boolean 返回类型 返回true是节假日，返回false不是节假日
	 */
	public static boolean checkHoliday(Calendar calendar) throws Exception {

		// 判断日期是否是周六周日
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {

			// 判断日期是否是节假日
			for (Calendar ca : weekendList) {
				if (ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
						&& ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)
						&& ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
					return false;
				}
			}

			return true;
		}
		// 判断日期是否是节假日
		for (Calendar ca : holidayList) {
			if (ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
					&& ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)
					&& ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * <p>把所有节假日放入list</p>
	 * 
	 *
	 * @param date 从数据库查 查出来的格式
	 */
	public void initHolidayList(String date) {

		String[] da = date.split("-");

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
		calendar.set(Calendar.MONTH, Integer.valueOf(da[1]) - 1);// 月份比正常小1,0代表一月
		calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
		holidayList.add(calendar);
	}

	/**
	 * 
	 * <p>判断当前时间是否为工作日（工作日时间段：周一到周五 9:00-12:00 13:30-17:30）</p>
	 * 
	 * @param now
	 * @return
	 * @throws Exception
	 */
	public static boolean isWorkDay() throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date = df.parse(DateUtils.getDateYMD(new Date()));
		cal.setTime(date);

		// 判断是否为节假日/周六日 true是
		Boolean checkHoliday = DateUtils.checkHoliday(cal);
		if (checkHoliday) {
			// 休息时间，不是工作日，返回false
			return false;
		}
		// 判断是否为工作时间9:00-12:00 13:30-17:30
		Boolean checkWorkTime = DateUtils.getWorkTime();
		return checkWorkTime;
	}

	/**
	 * 
	 * <p>初始化周末被调整为工作日的数据</p>
	 * 
	 */
	public void initWeekendList(String date) {
		String[] da = date.split("-");

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
		calendar.set(Calendar.MONTH, Integer.valueOf(da[1]) - 1);// 月份比正常小1,0代表一月
		calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
		weekendList.add(calendar);
	}

	/**
	 * 
	 * <p>获取某年某月的最后一天</p>
	 * 
	 */
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
	}

	/**
	 * 
	 * <p>获取某年某月的第一天</p>
	 * 
	 */
	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
		return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
	}

	/**
	 * 
	 * <p>当前日期加上几天 返回YYYY-mm-dd</p>
	 * 
	 */
	public static String calculateNextNDayYMD(final String orgCutDayTime, int nextDay) throws ParseException {
		return DateTimeFormat.forPattern(FORMAT_YMD_NEW).parseDateTime(orgCutDayTime).plusDays(nextDay)
				.toString(FORMAT_YMD_NEW);
	}

	/**
	 * 
	 * <p>用于计算前几天的时间</p>
	 * 
	 * @param currentTime 当前时间，精确到天级别 yyyy-MM-dd
	 * @param preNum 相差天数
	 * @return 前几天时间
	 * @throws ParseException
	 */
	public static String calcuPreDate(final String currentTime, int preNum) throws ParseException {
		return DateTimeFormat.forPattern(FORMAT_YMD_NEW).parseDateTime(currentTime).plusDays(-preNum)
				.toString(FORMAT_YMD_NEW);
	}

	/**
	 * 
	 * <p>用于计算前几月的时间</p>
	 * 
	 * @param preNum 相差月份
	 * @return
	 */
	public static String calcuPreMonth(int preNum) {
		return DateTimeFormat.forPattern(YM_NEW).parseDateTime(getCurrentYMNew()).minusMonths(preNum).toString(YM_NEW);
	}

	/**
	 * 
	 * <p>获取超时时间分钟级</p>
	 * 
	 * @return
	 */
	public static String calcuDiffTime(Date endTime, Date startTime) {
		if (null == startTime) {
			return null;
		}
		if (null == endTime) {
			endTime = new Date();
		}
		long diffSecond = endTime.getTime() - startTime.getTime();
		if (diffSecond < 0) {
			return null;
		}
		int secondUnit = 1000;
		int minuteUnit = secondUnit * 60;
		int hourUnit = minuteUnit * 60;
		int dayUnit = hourUnit * 24;
		long diffDay = diffSecond / dayUnit;
		long diffHour = (diffSecond - dayUnit * diffDay) / hourUnit;
		long diffMinute = (diffSecond - dayUnit * diffDay - diffHour * hourUnit) / minuteUnit;
		if (0 == diffDay && 0 == diffHour && 0 != (diffSecond - dayUnit * diffDay - diffHour * hourUnit)
				&& 0 != minuteUnit && (diffSecond - dayUnit * diffDay - diffHour * hourUnit) < minuteUnit) {
			diffMinute = 1;
		}
		String diffDayStr = diffDay != 0 ? (diffDay < 10 ? "0" + diffDay + "天" : diffDay + "天") : "";
		String diffHourStr = diffHour != 0 ? (diffHour < 10 ? "0" + diffHour + "时" : diffHour + "时") : "";// 小时
		String diffMinuteStr = diffMinute != 0 ? (diffMinute < 10 ? "0" + diffMinute + "分" : diffMinute + "分") : "";// 分钟
		return diffDayStr + diffHourStr + diffMinuteStr;
	}

	/**
	 * 
	 * <p>根据毫秒值算出时长</p>
	 * 
	 * @return
	 */
	public static String calcuDiffStr(Long scd) {
		if (null == scd || scd < 0) {
			return null;
		}
		int secondUnit = 1;
		int minuteUnit = secondUnit * 60;
		int hourUnit = minuteUnit * 60;
		int dayUnit = hourUnit * 24;
		long diffDay = scd / dayUnit;
		long diffHour = (scd - dayUnit * diffDay) / hourUnit;
		long diffMinute = (scd - dayUnit * diffDay - diffHour * hourUnit) / minuteUnit;
		if (0 == diffDay && 0 == diffHour && 0 != (scd - dayUnit * diffDay - diffHour * hourUnit) && 0 != minuteUnit
				&& (scd - dayUnit * diffDay - diffHour * hourUnit) < minuteUnit) {
			diffMinute = 1;
		}
		String diffDayStr = diffDay != 0 ? (diffDay < 10 ? "0" + diffDay + "天" : diffDay + "天") : "";
		String diffHourStr = diffHour != 0 ? (diffHour < 10 ? "0" + diffHour + "时" : diffHour + "时") : "";// 小时
		String diffMinuteStr = diffMinute != 0 ? (diffMinute < 10 ? "0" + diffMinute + "分" : diffMinute + "分") : "";// 分钟
		return diffDayStr + diffHourStr + diffMinuteStr;
	}

	/**
	 * 
	 * <p>得到两个日期相差的天数 </p>
	 * 
	 */
	public static final int daysBetween(Date early, Date late) {

		Calendar calst = Calendar.getInstance();
		Calendar caled = Calendar.getInstance();
		calst.setTime(early);
		caled.setTime(late);
		// 设置时间为0时
		calst.set(Calendar.HOUR_OF_DAY, 0);
		calst.set(Calendar.MINUTE, 0);
		calst.set(Calendar.SECOND, 0);
		caled.set(Calendar.HOUR_OF_DAY, 0);
		caled.set(Calendar.MINUTE, 0);
		caled.set(Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;

		return days;
	}

	/**
	 * 
	 * <p>判断某个时间是否在某个时间段</p>
	 * 
	 * @param nowTime:需要判断的时间
	 * @param startTime:时间段的开始时间
	 * @param endTime:时间段的结束时间
	 */
	public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
		if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
			return true;
		}

		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);

		Calendar begin = Calendar.getInstance();
		begin.setTime(startTime);

		Calendar end = Calendar.getInstance();
		end.setTime(endTime);

		if (date.after(begin) && date.before(end)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * <p>获取当前时间的次日17:00</p>
	 * 
	 */
	public static String getTomorrowDate() {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH),
				calendar2.get(Calendar.DAY_OF_MONTH) + 1, 17, 00, 00);
		Date endOfDate = calendar1.getTime();
		return DateFormatUtils.format(endOfDate, YMDHMS);
	}

	/**
	 * 
	 * <p>获取超时时间分钟级且根据超时规则类型判断是否超时</p>
	 * 
	 * @param endTime
	 * @param startTime
	 * @param operaType
	 * @return
	 */
	public static String calcuDiffTime(Date endTime, Date startTime, Integer operaType) {
		if (null == startTime) {
			return null;
		}
		if (null == endTime) {
			endTime = new Date();
		}
		long diffSecond = endTime.getTime() - startTime.getTime();
		if (diffSecond < 0) {
			return null;
		}
		int secondUnit = 1000;
		int minuteUnit = secondUnit * 60;
		int hourUnit = minuteUnit * 60;
		int dayUnit = hourUnit * 24;
		long diffDay = diffSecond / dayUnit;
		long diffHour = (diffSecond - dayUnit * diffDay) / hourUnit;
		long diffMinute = (diffSecond - dayUnit * diffDay - diffHour * hourUnit) / minuteUnit;
		String diffDayStr = diffDay != 0 ? (diffDay < 10 ? "0" + diffDay + "天" : diffDay + "天") : "";
		String diffHourStr = diffHour != 0 ? (diffHour < 10 ? "0" + diffHour + "时" : diffHour + "时") : "";// 小时
		String diffMinuteStr = diffMinute != 0 ? (diffMinute < 10 ? "0" + diffMinute + "分" : diffMinute + "分") : "";// 分钟
		if (1 == operaType) {// 1小时
			if (0 == diffDay && diffHour == 0) {
				return null;
			}
		} else if (2 == operaType) {// 30分钟
			if (0 == diffDay && diffHour == 0 && diffMinute < 30) {
				return null;
			}
		} else if (3 == operaType) {// 2小时
			if (0 == diffDay && diffHour < 2) {
				return null;
			}
		}
		return diffDayStr + diffHourStr + diffMinuteStr;
	}

	/**
	 * 
	 * <p>得到日期+增量数</p>
	 * 
	 * @param date
	 * @param nextStep
	 * @param calcuType(S:秒级,m:分钟级,H:小时级,D:日期级,M:月份级,Y:年份级)
	 * @return
	 */
	public static String getNextDateTimeByStepType(Date date, final int nextStep, String stepType) {
		Calendar calendar = Calendar.getInstance();
		if (null != date) {
			calendar.setTime(date);
		}
		if (S.equals(stepType)) {
			// 增加秒
			calendar.add(Calendar.SECOND, nextStep);
		} else if (m.equals(stepType)) {
			// 增加分钟
			calendar.add(Calendar.MINUTE, nextStep);
		} else if (H.equals(stepType)) {
			// 增加小时
			calendar.add(Calendar.HOUR, nextStep);
		} else if (D.equals(stepType)) {
			// 增加日期
			calendar.add(Calendar.DATE, nextStep);
		} else if (M.equals(stepType)) {
			// 增加月份
			calendar.add(Calendar.MONTH, nextStep);
		} else if (Y.equals(stepType)) {
			// 增加年份
			calendar.add(Calendar.YEAR, nextStep);
		}
		return DateFormatUtils.format(calendar, FORMAT_YMDHMS_FRONT);
	}

	/**
	 * 
	 * <p>获取过期时间</p>
	 * 
	 */
	public static int getExpireTime(Date date1) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date());
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);
		int day = day1 - day2;
		return day;
	}

	// 获取本周的开始时间
	public static Date getBeginDayOfWeek() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek);
		return getDayStartTime(cal.getTime());
	}

	// 获取本周的结束时间
	public static Date getEndDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}
	public static Date getBeginDayOfLastWeek() {
		Date date = new Date();
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek - 7);
		return getDayStartTime(cal.getTime());
	}
	//获取上周的结束时间
	public static Date getEndDayOfLastWeek(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfLastWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}
	//获取今年是哪一年
	public static Integer getNowYear() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return Integer.valueOf(gc.get(1));
	}
	//获取本月是哪一月
	public static int getNowMonth() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc.get(2) + 1;
	}
	//获取本月的开始时间
	public static Date getBeginDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		return getDayStartTime(calendar.getTime());
	}
	//获取本月的结束时间
	public static Date getEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 1, day);
		return getDayEndTime(calendar.getTime());
	}
	//获取上月的开始时间
	public static Date getBeginDayOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 2, 1);
		return getDayStartTime(calendar.getTime());
	}
	//获取上月的结束时间
	public static Date getEndDayOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 2, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 2, day);
		return getDayEndTime(calendar.getTime());
	}

	// 获取某个日期的结束时间
	public static Timestamp getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23,
				59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return new Timestamp(calendar.getTimeInMillis());
	}

	// 获取某个日期的开始时间
	public static Timestamp getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
				0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * <p>月份第一天</p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentMonFirstDayStr(final String time) throws Exception {
		Date dateTime = DateUtils.getDateFromString(time);
		DateTime now = new DateTime(dateTime.getTime());
		DateTime nextMouthLastDay = now.plusMonths(0).dayOfMonth().withMinimumValue();
		return nextMouthLastDay.toString(YMD);
	}

	/**
	 * <p>月份的最后一天</p>
	 * 
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static String getCurrentMonLastDayStr(final String time) throws ParseException {
		Date dateTime = DateUtils.getDateFromString(time);
		DateTime now = new DateTime(dateTime.getTime());
		DateTime nextMouthLastDay = now.plusMonths(0).dayOfMonth().withMaximumValue();
		return nextMouthLastDay.toString(YMD);
	}
	
	/**
	 * <p>获取日期指定部分</p> 
	 * 
	 * @param date
	 * @param type 类型
	 * @return
	 */
	public static Integer getDateSpecPart(Date date, String type) {
		if (null == date) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (Y.equals(type)) {
			// 年
			return calendar.get(Calendar.YEAR);
		} else if (M.equals(type)) {
			// 月
			return calendar.get(Calendar.MONTH) + 1;
		} else if (D.equals(type)) {
			// 日
			return calendar.get(Calendar.DAY_OF_MONTH);
		} else if (H.equals(type)) {
			// 时
			return calendar.get(Calendar.HOUR_OF_DAY);
		} else if (m.equals(type)) {
			// 分
			return calendar.get(Calendar.MINUTE);
		} else if (S.equals(type)) {
			// 秒
			return calendar.get(Calendar.SECOND);
		}
		return null;
	}
	
	/**     
	 * <p>两个日期的时间差转换成字符串描述</p>
	 *
	 * @param endDate
	 * @param startDate
	 * @return
	 */
	public static String calcuDateDiffStr(Date endDate, Date startDate) {
		// 每天毫秒数
		long nd = 1000 * 24 * 60 * 60;
		// 每小时毫秒数
		long nh = 1000 * 60 * 60;
		// 每分钟毫秒数
		long nm = 1000 * 60;
		// 每秒毫秒数
		long ns = 1000;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - startDate.getTime();
		// 计算差多少天
		long day = diff / nd;
		// 计算差多少小时
		long hour = diff % nd / nh;
		// 计算差多少分钟
		long min = diff % nd % nh / nm;
		// 计算差多少秒
		long second = diff % nd % nh % nm / ns;
		StringBuffer dateDiff = new StringBuffer();
		if (day > 0) {
			dateDiff.append(day).append("天");
		}
		if (hour > 0 || (day > 0 && second > 0)) {
			dateDiff.append(hour).append("小时");
		}
		if (min > 0 || (day > 0 && second > 0)) {
			dateDiff.append(min).append("分钟");
		}
		if (second > 0) {
			dateDiff.append(second).append("秒");
		}
		return dateDiff.toString();
	}
	
	/**     
	 * <p>两个日期相差的分钟数</p>
	 *
	 * @param endDate
	 * @param startDate
	 * @return
	 */
	public static long calcuDateDiffMinutes(Date endDate, Date startDate) {
		// 每分钟毫秒数
		long nm = 1000 * 60;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - startDate.getTime();
		long min = diff / nm;
		return min;
	}
	
	/**     
	 * <p>日期转换成MM-dd格式</p>
	 *
	 * @param date
	 * @return
	 */
	public static String getDateMMDD(Date date) {
		Date parseDate = null == date ? new Date(): date;
		return DateFormatUtils.format(parseDate, MM_DD);
	}
	
	/**     
	 * <p>两个日期相差的天数</p>
	 *
	 * @param endDate
	 * @param startDate
	 * @return
	 */
	public static long calcuDateDiffDays(Date endDate, Date startDate) {
		// 每天毫秒数
		long nd = 1000 * 24 * 60 * 60;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - startDate.getTime();
		// 计算差多少天
		long day = diff / nd;
		return day;
	}
	
	/**     
	 * <p>时间转换成yyyy年MM月dd日格式</p>
	 *
	 * @param date
	 * @return
	 */
	public static String getYmdChinaDate(Date date) {
		if (null == date)
			date = new Date();
		return DateFormatUtils.format(date, FORMAT_YMD_CHINA);
	}
	
}
