package com.dm.stu.util;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

/***
 * 常用工具类
 * 
 * @author sizho
 *
 */
public class PublicUtil {
	public static String[] chars = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
			"z" };

	/***
	 * 生成ID方法
	 * 
	 * @return
	 */
	public static String id() {
		StringBuffer shortBuffer = new StringBuffer(Long.toString(new Date().getTime(), 26));
		for (int i = 0; i < 8; i++) {
			shortBuffer.append(chars[Integer
					.parseInt(UUID.randomUUID().toString().replace("-", "").substring(i * 4, i * 4 + 4), 16) % 26]);
		}
		return shortBuffer.toString();
	}

	/***
	 * 判断字符串是否为空
	 * 
	 * @param txt
	 * @return
	 */
	public static boolean isEmpty(String txt) {
		if (txt == null) {
			return true;
		}
		return StringUtils.isEmpty(txt);
	}

	/***
	 * 判断集合是否为空
	 * 
	 * @param txt
	 * @return
	 */
	public static boolean isEmpty(Collection<?> list) {
		if (list == null) {
			return true;
		}
		return list.isEmpty();
	}

	/**
	 * 判断是否为数字(正负数都行)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/***
	 * 转换成int
	 * 
	 * @param number
	 * @return
	 */
	public static int toInteger(String number) {
		if (isEmpty(number) || !isNumeric(number)) {
			return 0;
		}
		return new Integer(number).intValue();
	}

	/***
	 * 秒数转成时分秒格式
	 * 
	 * @param second
	 * @return
	 */
	public static String toTextTime(long second) {
		long h = second / 3600;
		long m = (second - h * 3600) / 60;
		long s = (second - h * 3600) % 60;
		StringBuffer sb = new StringBuffer();
		if (h > 0) {
			return (h + 1) + "小时后";
		}
		if (m > 0) {
			if (m + 1 == 60) {
				return "1小时后";
			}
			return (m + 1) + "分钟后";
		}
		if (s > 0) {
			if (s + 1 == 60) {
				return "1分钟后";
			}
			return (s + 1) + "秒后";
		}
		return sb.toString();
	}
}
