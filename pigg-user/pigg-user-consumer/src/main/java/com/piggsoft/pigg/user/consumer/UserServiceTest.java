package com.piggsoft.pigg.user.consumer;

import com.piggsoft.pigg.user.service.UserService;

public class UserServiceTest {
	
	private UserService userService;
	
	public void run() {
		userService.find(1l);
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
