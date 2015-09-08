package com.piggsoft.pigg.user.service;

import com.piggsoft.pigg.user.model.User;

public interface UserService {
	int save(User user);
	User find(Long userId);
	User find(User user);
	User find();
}
