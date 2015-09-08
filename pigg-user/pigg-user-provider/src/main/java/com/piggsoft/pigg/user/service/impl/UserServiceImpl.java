package com.piggsoft.pigg.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.piggsoft.pigg.user.dao.UserMapper;
import com.piggsoft.pigg.user.model.User;
import com.piggsoft.pigg.user.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public int save(User user) {
		return userMapper.insert(user);
	}

	public User find(Long userId) {
		User user = userMapper.selectByPrimaryKey(Integer.parseInt(userId.toString()));
		return user;
	}

	public User find(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User find() {
		System.out.println("find");
		return null;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
