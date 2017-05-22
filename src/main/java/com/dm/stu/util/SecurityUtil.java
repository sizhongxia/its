package com.dm.stu.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/***
 * 安全加密相关工具类
 * 
 * @author sizho
 *
 */
public class SecurityUtil {

	/**
	 * MD5加密算法
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		return DigestUtils.md5Hex(str);
	}

	/**
	 * SHA1加密算法
	 * 
	 * @param str
	 * @return
	 */
	public static String sha1(String str) {
		return DigestUtils.sha1Hex(str);
	}

	/***
	 * 对称Base64加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encode(String str) {
		Base64 base64 = new Base64();
		try {
			return base64.encodeToString(str.getBytes("UTF-8"));
		} catch (Exception e) {
			return null;
		}
	}

	/***
	 * 对称Base64解密
	 * 
	 * @param str
	 * @return
	 */
	public static String decode(String str) {
		try {
			return new String(Base64.decodeBase64(str));
		} catch (Exception e) {
			return null;
		}
	}
}
