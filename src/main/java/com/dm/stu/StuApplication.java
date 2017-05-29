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
//			container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, ERRPAGE_PREFIX + "403.html"));
//		});
//	}

	// 项目启动Main方法
	public static void main(String[] args) {
		SpringApplication.run(StuApplication.class, args);
	}

}
