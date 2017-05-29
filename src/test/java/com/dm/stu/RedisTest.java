//package com.dm.stu;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.dm.stu.service.RedisService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RedisTest {
//
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
//
//	@Autowired
//	private RedisTemplate<String, String> redisTemplate;
//
//	@Autowired
//	private RedisService redisService;
//
//	@Test
//	public void test() throws Exception {
//		stringRedisTemplate.opsForValue().set("aaa", "111");
//		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
//		Thread.sleep(1000);
//		stringRedisTemplate.delete("aaa");
//	}
//
//	@Test
//	public void testDelta() throws Exception {
//		Long num = redisService.increment("aaaa", 1L);
//		System.out.println(num);
//		stringRedisTemplate.delete("aaaa");
//	}
//	
//
//	@Test
//	public void testExpire() throws Exception {
//		Long times = redisService.getExpire("aaaa");
//		System.out.println(times);
//	}
//
//	@Test
//	public void testObj() throws Exception {
//		ValueOperations<String, String> operations = redisTemplate.opsForValue();
//		// operations.set("com.neox", "text");
//		operations.set("com.neo.f", "sss", 1L, TimeUnit.SECONDS);
//		// redisTemplate.delete("com.neo.f");
//		boolean exists = redisTemplate.hasKey("com.neo.f");
//		if (exists) {
//			System.out.println("exists is true");
//		} else {
//			System.out.println("exists is false");
//		}
//		Thread.sleep(1001);
//		exists = redisTemplate.hasKey("com.neo.f");
//		if (exists) {
//			System.out.println("exists is true");
//		} else {
//			System.out.println("exists is false");
//		}
//		// Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//	}
//
//	@Test
//	public void testRedisService() throws Exception {
//		// redisService.set("k1.0", "testvalue1");
//		// redisService.set("k1.1", "testvalue1", 10L);
//		// System.out.println(redisService.getString("k1.0"));
//		// System.out.println(redisService.hasKey("k1.1"));
//		redisService.del("spring:session:sessions:a3127b72-5cb2-43df-8f6a-ae6f2f63899e");
//		redisService.del("spring:session:sessions:expires:a3127b72-5cb2-43df-8f6a-ae6f2f63899e");
//	}
//
//}
