package com.dyq.base;

import org.apache.shiro.SecurityUtils;

import com.dyq.entity.User;
import com.dyq.model.ResultModel;

public class BaseController {

	public ResultModel getResultModel() {
		return new ResultModel();
	}
	
	/**
	 * 获取用户信息
	 * @return
	 */
	public User getLoginInfo() {
		return (User) SecurityUtils.getSubject().getPrincipal();
	}
	
}
