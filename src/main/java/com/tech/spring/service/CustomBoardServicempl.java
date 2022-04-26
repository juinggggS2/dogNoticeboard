package com.tech.spring.service;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tech.spring.dao.CustomBoardDao;
import com.tech.spring.dto.BoardDto;

@Service
public class CustomBoardServicempl implements CustomBoardService{

	
	  @Inject 
	  CustomBoardDao customBoardDao;
	  
	  @Override 
	  public ArrayList<BoardDto> boardList() {
	  
	  return customBoardDao.boardList(); 
	  
	  }

	@Override
	public BoardDto boardDetail(int boardSeq) {
		return customBoardDao.boardDetail(boardSeq);
	}

	@Override
	public void boardInsert(BoardDto dto, String userNick) {
		
		dto.setBoard_writer(userNick);
		customBoardDao.boardInsert(dto);
		
	}

	@Override
	public void boardDelete(int boardSeq) {
		customBoardDao.boardDelete(boardSeq);
		
	}
	 

		

}
