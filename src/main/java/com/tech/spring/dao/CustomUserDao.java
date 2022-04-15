package com.tech.spring.dao;

import com.tech.spring.dto.UserDto;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface CustomUserDao {
	public void registerToLogin(UserDto userDto);
}
