package com.dyq.base;

import org.apache.shiro.SecurityUtils;

import com.dyq.entity.User;

public class BaseService {

	/**
	 * 获取用户信息
	 * @return
	 */
	public User getLoginInfo() {
		return (User) SecurityUtils.getSubject().getPrincipal();
	}
	
}
