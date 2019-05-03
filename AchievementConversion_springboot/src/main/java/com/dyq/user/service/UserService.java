package com.dyq.user.service;

import java.util.List;

import com.dyq.user.domain.Login;
import com.dyq.user.domain.LoginGroupByTime;
import com.dyq.user.domain.User;

/**
 * �û�Service
 * @author dyq
 *
 */
public interface UserService {
	
	Login login(Login login);
	List<User> queryAll(User user);
	List<Login> queryAllLogin(Login login);
	int loginCount(Login login);
	User queryUserById(Integer userId);
	Login queryLoginByName(String loginName);
	int insertLogin(Login login);
	int insertUser(User user);
	int updateLogin(Login login);
	int updateUser(User user);
	int deleteLogin(Integer loginId);
	List<LoginGroupByTime> queryUserGroupByTime();
	
}
