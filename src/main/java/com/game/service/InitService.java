package com.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {

	@Autowired
	private UserService userService;
	
	public void init(){
		userService.init();
	}
}
