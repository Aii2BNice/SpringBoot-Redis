package com.dyq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dyq.entity.User;

@Mapper
public interface UserMapper {

	/**
	 * 获取所有用户
	 * @param user
	 * @return
	 */
	List<User> getAllUser(User user);
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	User login(User user);
	
	/**
	 * 获取用户数量
	 * @param user
	 * @return
	 */
	int getUserCnt(User user);
	
	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	int insUser(User user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int updUser(User user);
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	int delUser(User user);
	
}
