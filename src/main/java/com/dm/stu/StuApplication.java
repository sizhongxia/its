package com.dm.stu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StuApplication {

//	private String ERRPAGE_PREFIX = "/pages/";

//	/**
//	 * 异常页面拦截
//	 * 
//	 * @return
//	 */
//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//		return (container -> {
//			container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, ERRPAGE_PREFIX + "400.html"),
//					new ErrorPage(HttpStatus.UNAUTHORIZED, ERRPAGE_PREFIX + "401.html"),
//					new ErrorPage(HttpStatus.FORBIDDEN, ERRPAGE_PREFIX + "403.html"),
//					new ErrorPage(HttpStatus.NOT_FOUND, ERRPAGE_PREFIX + "404.html"),
//					new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, ERRPAGE_PREFIX + "405.html"),
//					new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, ERRPAGE_PREFIX + "500.html"),
//					new ErrorPage(HttpStatus.BAD_GATEWAY, ERRPAGE_PREFIX + "502.html"));
//		});
//	}

	// 项目启动Main方法
	public static void main(String[] args) {
		SpringApplication.run(StuApplication.class, args);
	}

}
