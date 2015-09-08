package com.piggsoft.pigg.user.service;

import com.piggsoft.pigg.user.model.User;
import com.piggsoft.pigg.user.model.UserExample;

import java.util.List;

public interface UserService {
	int save(User user);
	User find(Long userId);
	List<User> findByExample(UserExample example);
	List<User> find();
	int updateUserByExample(User user, UserExample example);
	int deleteById(Long userId);
	int deleteByUserExample(UserExample example);
}
