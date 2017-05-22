package com.dm.stu;

import java.util.Date;

import com.dm.stu.util.DateFormatUtil;

public class DateFormatUtilTest {

	public static void main(String[] args) {
		Date date = new Date(1495316458000l);
		String string = DateFormatUtil.formatStringDateTime(date);
		System.out.println(string);
		String time = "2016-05-21 19:41:58";
		System.out.println(DateFormatUtil.getTimeDesc(time));
	}

}
