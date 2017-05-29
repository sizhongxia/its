//package com.dm.stu.service.impl;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Service;
//
//import com.dm.stu.service.RedisService;
//
//@Service
//public class RedisServiceImpl implements RedisService {
//
//	@Autowired
//	RedisTemplate<String, String> redisTemplate;
//
//	@Override
//	public void set(String key, String value) {
//		ValueOperations<String, String> operations = redisTemplate.opsForValue();
//		operations.set(key, value);
//	}
//
//	@Override
//	public void set(String key, String value, Long seconds) {
//		ValueOperations<String, String> operations = redisTemplate.opsForValue();
//		operations.set(key, value, seconds, TimeUnit.SECONDS);
//
//	}
//
//	@Override
//	public Long increment(String key, long delta) {
//		ValueOperations<String, String> operations = redisTemplate.opsForValue();
//		return operations.increment(key, delta);
//	}
//
//	@Override
//	public void del(String key) {
//		if (hasKey(key)) {
//			redisTemplate.delete(key);
//		}
//	}
//
//	@Override
//	public String getString(String key) {
//		return redisTemplate.opsForValue().get(key);
//	}
//
//	@Override
//	public String optString(String key, String def) {
//		String obj = redisTemplate.opsForValue().get(key);
//		return obj == null ? def : obj;
//	}
//
//	@Override
//	public Long getExpire(String key) {
//		if (!hasKey(key)) {
//			return 0L;
//		}
//		return redisTemplate.getExpire(key);
//	}
//
//	@Override
//	public boolean setExpire(String key, long timeout, TimeUnit unit) {
//		return redisTemplate.expire(key, timeout, unit);
//	}
//
//	@Override
//	public boolean hasKey(String key) {
//		return redisTemplate.hasKey(key);
//	}
//
//}
