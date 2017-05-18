package com.dm.stu.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class SecurityUtil {

	public static String md5(String str) {
		return DigestUtils.md5Hex(str);
	}

	public static String sha1(String str) {
		return DigestUtils.sha1Hex(str);
	}

	public static String encode(String str) {
		Base64 base64 = new Base64();
		try {
			return base64.encodeToString(str.getBytes("UTF-8"));
		} catch (Exception e) {
			return null;
		}
	}

	public static String decode(String str) {
		try {
			return new String(Base64.decodeBase64(str));
		} catch (Exception e) {
			return null;
		}
	}
}
