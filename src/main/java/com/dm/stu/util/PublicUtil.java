package com.dm.stu.util;

import com.dm.stu.sys.util.IdWorker;

public class PublicUtil {
	final static IdWorker idWorker = new IdWorker(0, 0);

	public static String id() {
		return idWorker.nextId();
	}
}
