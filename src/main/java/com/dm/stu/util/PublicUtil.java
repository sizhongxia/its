package com.dm.stu.util;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

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
}
