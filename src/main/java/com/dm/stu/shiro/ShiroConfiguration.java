package com.dm.stu.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

	/**
	 * Shiro的Web过滤器Factory 命名:shiroFilter<br />
	 * * * @param securityManager * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// Shiro的核心安全接口,这个属性是必须的
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 要求登录时的链接(可根据项目的URL进行替换),非必须的属性,默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的连接,逻辑也可以自定义，例如返回上次请求的页面
		shiroFilterFactoryBean.setSuccessUrl("/zx.m/index");
		/*
		 * 定义shiro过滤器,例如实现自定义的FormAuthenticationFilter，
		 * 需要继承FormAuthenticationFilter **本例中暂不自定义实现，在下一节实现验证码的例子中体现
		 */

		/*
		 * 定义shiro过滤链 Map结构 *
		 * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的
		 * anon：它对应的过滤器里面是空的,什么都没做,这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种
		 * authc：该过滤器下的页面必须验证后才能访问，它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
		 */
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
		// filterChainDefinitionMap.put("/logout", "logout");
		// authc:所有url都必须认证通过才可以访问;
		// anon:所有url都都可以匿名访问
		filterChainDefinitionMap.put("/index", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/template/*", "anon");
		filterChainDefinitionMap.put("/resources/**", "anon");
		filterChainDefinitionMap.put("/zx.m/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 缓存管理
	 * 
	 * @return
	 */
	@Bean
	public EhCacheManager ehCacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:shiro/ehcache-shiro.xml");
		return cacheManager;
	}

	/***
	 * 开启thymeleaf模板引擎标签
	 * 
	 * @return
	 */
	@Bean(name = "shiroDialect")
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}

	@Bean(name = "securityManager")
	public SecurityManager securityManager(UserRealm userRealm) {
		logger.info("注入Shiro的Web过滤器-->securityManager", ShiroFilterFactoryBean.class);
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		securityManager.setCacheManager(ehCacheManager());
		return securityManager;
	}

	/**
	 * Shiro生命周期处理器
	 * 
	 * @return
	 */
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),
	 * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证 *
	 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)
	 * 即可实现此功能
	 * 
	 * @return
	 */
	@Bean
	@DependsOn({ "lifecycleBeanPostProcessor" })
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
}