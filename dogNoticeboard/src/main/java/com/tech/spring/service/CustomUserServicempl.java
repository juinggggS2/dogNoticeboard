package com.tech.spring.service;

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
	public void registerToLogin(UserDto dto) {
		
		//전화번호 - 자르기 ex)010-1234-5678 -> 01012345678
		String Pnum = "";
		String arr_Pnum[] = dto.getCustom_user_phone().split("-");
		
		for (int i = 0; i < arr_Pnum.length; i++) {
			Pnum += arr_Pnum[i];
		}
		
		dto.setCustom_user_phone(Pnum);
		
		customUserDao.registerToLogin(dto);
		
	}


	@Override
	public UserDto loginToMain(String custom_user_email) {
		
		return customUserDao.loginToMain(custom_user_email);
	}


	@Override
	public int nickCheck(String custom_user_nick) {
		return customUserDao.nickCheck(custom_user_nick);
	}


	@Override
	public int emailCheck(String custom_user_email) {
		return customUserDao.emailCheck(custom_user_email);
	}
}
