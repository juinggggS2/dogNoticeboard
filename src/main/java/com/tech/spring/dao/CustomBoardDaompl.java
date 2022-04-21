package com.tech.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.spring.dto.BoardDto;


@Repository
public class CustomBoardDaompl implements CustomBoardDao {

	@Autowired
	SqlSession sqlSession;
	
	
	  private static String nameSpace = "com.tech.spring.dao.CustomerBoardDao";
	  
	 @Override public ArrayList<BoardDto> boardList() {
		 System.out.println("=====DaoImpl boardList()=====");
	 List<BoardDto> boardDto = sqlSession.selectList(nameSpace + ".boardList");
	  for (BoardDto dto : boardDto) {
		  System.out.println("타이틀: "+dto.getBoard_title());
		
	}
	 return (ArrayList<BoardDto>) boardDto; 
	 }
	 
	
	

}
