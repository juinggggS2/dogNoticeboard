package com.tech.spring.service;

import java.util.ArrayList;

import com.tech.spring.dto.BoardDto;

public interface CustomBoardService {

	//보드목록
	public ArrayList<BoardDto> boardList(); 
	
	public BoardDto boardDetail(int boardSeq) ;
	
}


