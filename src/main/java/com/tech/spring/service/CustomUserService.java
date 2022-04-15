package com.tech.spring.service;

import com.tech.spring.dto.UserDto;

public interface CustomUserService {
	public void registerToLogin(UserDto userdto);
	
	public String LoginToMain(String customUserEmail, String customUserPswd);
	
	
}

