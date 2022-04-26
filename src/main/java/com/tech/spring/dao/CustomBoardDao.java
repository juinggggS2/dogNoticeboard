package com.tech.spring.dao;

import java.util.ArrayList;

import com.tech.spring.dto.BoardDto;

public interface CustomBoardDao {
	//보드리스트
	public ArrayList<BoardDto> boardList();
	//보드상세보기
	public BoardDto boardDetail(int boardSeq); 
	//보드글쓰기
	public void boardInsert(BoardDto dto);
	//보드글삭제
	public void boardDelete(int board_seq);

}
