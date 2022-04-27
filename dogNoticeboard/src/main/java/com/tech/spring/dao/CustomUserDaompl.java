package com.tech.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.spring.dto.UserDto;


@Repository
public class CustomUserDaompl implements CustomUserDao {

	@Autowired
	SqlSession sqlSession;
	
	/*
	 * @Autowired SqlSessionTemplate sqlsessionTemplate;
	 */
	
	private static String nameSpace = "com.tech.spring.dao.CustomUserDao";
	
	@Override
	public void registerToLogin(UserDto userDto) {
		System.out.println(0);
		try {
			sqlSession.insert(nameSpace + ".registerToLogin", userDto);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("00");
	}

	@Override
	public int nickCheck(String custom_user_nick) {
		return sqlSession.selectOne(nameSpace +".nickCheck", custom_user_nick);
	}

	@Override
	public int emailCheck(String custom_user_email) {
		return sqlSession.selectOne(nameSpace +".emailCheck", custom_user_email);
	}


	//로그인
	@Override
	public UserDto loginToMain(String custom_user_email) {
		
		return sqlSession.selectOne(nameSpace +".loginToMain", custom_user_email);
	}
	
	
}
