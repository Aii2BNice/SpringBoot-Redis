package com.dyq.config;

import java.util.LinkedHashMap;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dyq.service.UserRealm;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {

	//thymeleaf模板使用shiro标签
	@Bean
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}
	
	//配置Shiro过滤器
	@Bean(name="shiroFilterFactoryBean")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
		//配置登录的url
		shiroFilterFactoryBean.setLoginUrl("/tologin");
		//登录成功的url
		shiroFilterFactoryBean.setSuccessUrl("/toHomePage");
		//未授权页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/tologin"); 
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        //可以直接访问的静态资源
        filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/res/**", "anon");
		//可以访问的页面
		filterChainDefinitionMap.put("/toindex", "anon");
		filterChainDefinitionMap.put("/toabout", "anon");
		filterChainDefinitionMap.put("/tocase", "anon");
		filterChainDefinitionMap.put("/tonews", "anon");
		filterChainDefinitionMap.put("/tostatistics", "anon");
		filterChainDefinitionMap.put("/toregister", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/register", "anon");
		//需要认证才可以访问(全部)
        filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
	
	/**
	 * shiro管理器
	 * @param userRealm
	 * @return
	 */
	@Bean(name="defaultWebSecurityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(userRealm);
		return defaultWebSecurityManager;
	}
	
	//创建Realm
	@Bean(name="userRealm")
	public UserRealm getUserRealm(){
		return new UserRealm();
	}	
	
}
