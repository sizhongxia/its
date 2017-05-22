//package com.dm.stu.redis;
//
//import java.lang.reflect.Method;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
////@Configuration
////@EnableCaching
////@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
//public class RedisConfig extends CachingConfigurerSupport {
//
//	@Bean
//	@Override
//	public KeyGenerator keyGenerator() {
//		return new KeyGenerator() {
//			@Override
//			public Object generate(Object target, Method method, Object... params) {
//				StringBuilder sb = new StringBuilder();
//				sb.append(target.getClass().getName());
//				sb.append(method.getName());
//				for (Object obj : params) {
//					sb.append(obj.toString());
//				}
//				return sb.toString();
//			}
//		};
//	}
//
//	@Bean
//	public CacheManager cacheManager(RedisTemplate<String, String> redisTemplate) {
//		RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//		rcm.setDefaultExpiration(60);
//		return rcm;
//	}
//
//	@Bean
//	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//		StringRedisTemplate template = new StringRedisTemplate(factory);
//		Jackson2JsonRedisSerializer<Object> jrs = new Jackson2JsonRedisSerializer<Object>(Object.class);
//		ObjectMapper om = new ObjectMapper();
//		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//		jrs.setObjectMapper(om);
//		template.setValueSerializer(jrs);
//		template.afterPropertiesSet();
//		return template;
//	}
//}
