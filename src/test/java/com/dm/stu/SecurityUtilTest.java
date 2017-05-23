package com.dm.stu;

import org.junit.Test;

import com.dm.stu.util.SecurityUtil;

public class SecurityUtilTest {
	@Test
	public void TestMd5() {
		System.out.println(SecurityUtil.md5("123456"));
		System.out.println(SecurityUtil.md5("123456123456123456123456123456123456123456123456").length());
	}

	@Test
	public void TestSha1() {
		System.out.println(SecurityUtil.sha1("123456"));
	}

	@Test
	public void TestEncode() {
		System.out.println(SecurityUtil.AESEncrypt(SecurityUtil.sha1("123456")));
	}

	@Test
	public void TestDecode() {
		System.out.println(SecurityUtil.AESEncrypt("Mg=="));
		System.out.println(SecurityUtil.AESDecrypt("fkvmgc0dzBerGJTsi3QU0A=="));
	}

}
