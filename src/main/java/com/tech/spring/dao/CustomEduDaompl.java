package com.tech.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CustomEduDaompl implements CustomEduDao {

	@Autowired
	SqlSession sqlSession;
	
	/*
	 * @Autowired SqlSessionTemplate sqlsessionTemplate;
	 */
	
	private static String nameSpace = "com.tech.spring.dao.CustomerEduDao";


}
