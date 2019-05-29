package com.dyq.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.dyq.entity.User;

public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	// 执行认证逻辑
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken user = (UsernamePasswordToken) token;
		User loginUser = new User();
		loginUser.setUserName(user.getUsername());
		loginUser.setPassword(String.copyValueOf(user.getPassword()));
		User login = userService.login(loginUser);
		if (login == null) {
			return null;
		}
		return new SimpleAuthenticationInfo(login, login.getPassword(), "");
	}
	
	// 执行授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {	
		// 获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		User loginUser = (User) subject.getPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermission(loginUser.getRoleId().toString());
		return simpleAuthorizationInfo;
	}
	
}
