//package com.dm.stu.service;
//
//import java.util.concurrent.TimeUnit;
//
//public interface RedisService {
//	void set(String key, String value);
//
//	void set(String key, String value, Long time);
//
//	Long increment(String key, long delta);
//
//	void del(String key);
//
//	String getString(String key);
//
//	String optString(String key, String def);
//
//	Long getExpire(String key);
//
//	boolean setExpire(String key, long timeout, TimeUnit unit);
//
//	boolean hasKey(String key);
//}