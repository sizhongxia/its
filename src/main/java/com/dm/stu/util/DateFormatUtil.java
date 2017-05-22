package com.dm.stu.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static DateFormat dateTimeTextFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

	/**
	 * 格式化为日期字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String formatStringDate(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * 格式化为日期时间字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String formatStringDateTime(Date date) {
		return dateTimeFormat.format(date);
	}

	private static Long getDateMillisecond(String string) {
		Date date = null;
		try {
			date = dateTimeFormat.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}

	/**
	 * 获取时间描述
	 * 
	 * @param commitDate
	 * @return
	 */
	public static String getTimeDesc(Date commitDate) {
		return getTimeDesc(formatStringDateTime(commitDate));
	}

	/**
	 * 获取时间描述
	 * 
	 * @param commitDate
	 * @return
	 */
	public static String getTimeDesc(String commitDate) {
		Date nowTime = new Date();
		String currDate = dateTimeFormat.format(nowTime);
		Date date = null;
		try {
			date = dateTimeFormat.parse(commitDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int nowDate = Integer.valueOf(currDate.substring(8, 10));
		int commit = Integer.valueOf(commitDate.substring(8, 10));
		String monthDay = dateTimeTextFormat.format(date).substring(5, 12);
		String yearMonthDay = dateTimeTextFormat.format(date).substring(0, 12);
		int month = Integer.valueOf(monthDay.substring(0, 2));
		int day = Integer.valueOf(monthDay.substring(3, 5));
		if (month < 10 && day < 10) {
			monthDay = monthDay.substring(1, 3) + monthDay.substring(4);
		} else if (month < 10) {
			monthDay = monthDay.substring(1);
		} else if (day < 10) {
			monthDay = monthDay.substring(0, 3) + monthDay.substring(4);
		}
		int yearMonth = Integer.valueOf(yearMonthDay.substring(5, 7));
		int yearDay = Integer.valueOf(yearMonthDay.substring(8, 10));
		if (yearMonth < 10 && yearDay < 10) {
			yearMonthDay = yearMonthDay.substring(0, 5) + yearMonthDay.substring(6, 8) + yearMonthDay.substring(9);
		} else if (yearMonth < 10) {
			yearMonthDay = yearMonthDay.substring(0, 5) + yearMonthDay.substring(6);
		} else if (yearDay < 10) {
			yearMonthDay = yearMonthDay.substring(0, 8) + yearMonthDay.substring(9);
		}
		String str = " 00:00:00";
		long currDay = getDateMillisecond(currDate.substring(0, 10) + str);
		long commitDay = getDateMillisecond(commitDate.substring(0, 10) + str);
		int currYear = Integer.valueOf(currDate.substring(0, 4));
		int commitYear = Integer.valueOf(commitDate.substring(0, 4));
		int flag = (int) (getDateMillisecond(currDate) / 1000 - getDateMillisecond(commitDate) / 1000);
		String des = null;
		String hourMin = commitDate.substring(11, 16);
		int temp = flag;
		if (temp < 60) {
			if (commitDay < currDay) {
				des = "昨天  " + hourMin;
			} else {
				des = "刚刚";
			}
		} else if (temp < 60 * 60) {
			if (commitDay < currDay) {
				des = "昨天  " + hourMin;
			} else {
				des = temp / 60 + "分钟以前";
			}
		} else if (temp < 60 * 60 * 24) {
			int hour = temp / (60 * 60);
			if (commitDay < currDay) {
				des = "昨天  " + hourMin;
			} else {
				if (hour < 6) {
					des = hour + "小时前";
				} else {
					des = hourMin;
				}
			}
		} else if (temp < (60 * 60 * 24 * 2)) {
			if (nowDate - commit == 1) {
				des = "昨天  " + hourMin;
			} else {
				des = "前天  " + hourMin;
			}
		} else if (temp < 60 * 60 * 60 * 3) {
			if (nowDate - commit == 2) {
				des = "前天  " + hourMin;
			} else {
				if (commitYear < currYear) {
					des = yearMonthDay + hourMin;
				} else {
					des = monthDay + hourMin;
				}
			}
		} else {
			if (commitYear < currYear) {
				des = yearMonthDay + hourMin;
			} else {
				des = monthDay + hourMin;
			}
		}
		if (des == null) {
			des = commitDate;
		}
		return des;
	}

}
