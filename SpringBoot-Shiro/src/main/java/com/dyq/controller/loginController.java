package com.dyq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyq.base.BaseController;
import com.dyq.entity.User;
import com.dyq.model.ResultModel;
import com.dyq.service.UserService;
import com.dyq.util.Base64Util;

@RestController
public class loginController extends BaseController{

	@Autowired
	private UserService userService;
	
	/**
	  * 登录
	 * @param user
	 * @return
	 */
	@RequestMapping("login")
	public ResultModel login(HttpServletRequest req, User user) {
		ResultModel result = this.getResultModel();
		Subject subject = SecurityUtils.getSubject();
		//密码加密
		String newPwd = Base64Util.encode(user.getPassword());
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), newPwd);
		try {
			subject.login(token);
		}catch(Exception e) {
			result.setErrorMessage("用户名或密码错误");
			return result;
		}
		req.getSession().setAttribute("user", this.getLoginInfo());
		result.setSuccess(true);
		return result;
	}
	
	/**
	  * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping("register")
	public ResultModel register(User user) {
		ResultModel result = this.getResultModel();
		if(!StringUtils.isEmpty(user)) {
			// 密码加密
			String newPass = Base64Util.encode(user.getPassword());
			user.setPassword(newPass);
			if(userService.insUser(user)) {
				result.setSuccess(true);
				result.setOkMessage("注册成功");
			}else {
				result.setErrorMessage("注册失败");
			}
		}
		return result;
	}
	
}
