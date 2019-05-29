package com.dyq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dyq.base.BaseService;
import com.dyq.entity.User;
import com.dyq.mapper.UserMapper;

@Service
public class UserService extends BaseService{

	@Autowired
	private UserMapper userMapper;
	
	public User login(User user) {
		if(!StringUtils.isEmpty(user)){
			return userMapper.login(user);
		}else{
			return null;
		}
	}
	
	public boolean insUser(User user) {
		if(StringUtils.isEmpty(user)) {
			return false;
		}else {
			int count = userMapper.insUser(user);
			if(count > 0) {
				return true;
			}else {
				return false;
			}
		}
	}
	
}
