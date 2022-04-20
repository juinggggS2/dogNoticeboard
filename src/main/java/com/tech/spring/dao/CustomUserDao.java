package com.tech.spring.dao;

import com.tech.spring.dto.UserDto;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface CustomUserDao {
	/* 회원가입 */
	//회원가입
	public void registerToLogin(UserDto userDto);
	//닉네임
	public int nickCheck(String custom_user_nick);
	//이메일
	public int emailCheck(String custom_user_email);
	
	/* 로그인 */
	//로그인
	public UserDto loginToMain(String custom_user_email);
}
