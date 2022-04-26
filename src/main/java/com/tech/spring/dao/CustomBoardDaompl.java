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
	  
	 @Override 
	 public ArrayList<BoardDto> boardList() {
		 System.out.println("=====DaoImpl boardList()=====");
	 List<BoardDto> boardDto = sqlSession.selectList(nameSpace + ".boardList");
	  for (BoardDto dto : boardDto) {
		  System.out.println("타이틀: "+dto.getBoard_title());
		  System.out.println("작성자: "+dto.getBoard_writer());
		  System.out.println("제   목: "+dto.getBoard_title());
		  System.out.println("글내용: "+dto.getBoard_text());
		  System.out.println("수정시간: "+dto.getBoard_mod_date());
		  
	}
	 return (ArrayList<BoardDto>) boardDto; 
	 }

	@Override
	public BoardDto boardDetail(int boardSeq) {
		System.out.println("=====DaoImpl boardDetail()=====");
		
		BoardDto boardDto = sqlSession.selectOne(nameSpace + ".boardDetail", boardSeq);
		
		return boardDto;
	}
	
	@Override
	public void boardInsert(BoardDto dto) {
		System.out.println("=====DaoImpl boardInsert()=====");
		
		sqlSession.insert(nameSpace + ".boardInsert", dto);
		
	}
	
	
	@Override
	public void boardDelete(int boardSeq) {
		sqlSession.delete("boardDelete", boardSeq);
	}
	 
	
	

}
