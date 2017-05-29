package com.dm.stu.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Md5Hash;

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
		return new Md5Hash(str, "201705281241").toBase64();
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
	 * 生成AES-KEY
	 * 
	 * @return
	 */
	private static Key getAESKey() {
		byte[] bytes = Base64.decodeBase64(Base64.encodeBase64("DTFQ6nEPmWuJvpr2".getBytes()));
		return new SecretKeySpec(bytes, "AES");
	}

	/***
	 * 对称AES加密
	 * 
	 * @param str
	 * @return
	 */
	public static String AESEncrypt(String str) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, getAESKey());
			byte[] result = cipher.doFinal(str.getBytes());
			return Base64.encodeBase64String(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/***
	 * 对称AES解密
	 * 
	 * @param str
	 * @return
	 */
	public static String AESDecrypt(String str) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, getAESKey());
			return new String(cipher.doFinal(Base64.decodeBase64(str.getBytes())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
