package com.tech.spring.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tech.spring.dao.CustomUserDao;
import com.tech.spring.dto.UserDto;

@Service
public class CustomUserServicempl implements CustomUserService{

	
	  @Inject CustomUserDao customUserDao;
	 
	
	/*
	 * CustomUserDao customUserDao;
	 * 
	 * public CustomUserServicempl(CustomUserDaompl customUserDaompl) {
	 * this.customUserDao = customUserDaompl; }
	 */

	@Override
	public void registerToLogin(UserDto userDto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", userDto.getCustomUserName());
		map.put("nick", userDto.getCustomUserNick());
		map.put("email", userDto.getCustomUserEmail());
		map.put("pswd", userDto.getCustomUserPswd());
		map.put("birth", userDto.getCustomUserBirth());
		map.put("phone", userDto.getCustomUserPhone());
		map.put("address", userDto.getCustomUserAddress());
		map.put("auth", userDto.getCustomUserAuth());
		map.put("del_yn", userDto.getCustomUserDelYn());
		map.put("reg_date", userDto.getUserRegDate());
		map.put("mod_date", userDto.getUserModDate());

		System.out.println("nick ser: "+map.get("nick"));
	
		customUserDao.registerToLogin(userDto);
		
	}


	@Override
	public String LoginToMain(String customUserEmail, String customUserPswd) {
		System.out.println("check E : "+customUserEmail);
		System.out.println("check P : "+customUserPswd);
		
		
		
		
		return null;
	}
}
