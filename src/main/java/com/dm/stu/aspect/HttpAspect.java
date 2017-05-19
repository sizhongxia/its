package com.dm.stu.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

	final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	@Before("execution (public * com.dm.stu.app.*.*(..))")
	public void before() {
		logger.info(">>> request before.");
	}

}
