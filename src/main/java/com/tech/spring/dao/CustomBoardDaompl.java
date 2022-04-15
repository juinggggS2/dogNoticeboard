package com.tech.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomBoardDaompl implements CustomBoardDao {

	@Autowired
	SqlSession sqlSession;
	
	/*
	 * @Autowired SqlSessionTemplate sqlsessionTemplate;
	 */
	
	private static String nameSpace = "com.tech.spring.dao.CustomerBoardDao";
	
	

}
