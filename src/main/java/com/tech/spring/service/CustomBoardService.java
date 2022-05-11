package com.tech.spring.service;

import java.util.ArrayList;

import com.tech.spring.dto.BoardDto;
import com.tech.spring.vopage.SearchVO;

public interface CustomBoardService {

	//보드목록
	public ArrayList<BoardDto> boardList(SearchVO searchVO); 
	//보드상세보기
	public BoardDto boardDetail(int boardSeq) ;
	//보드글쓰기
	public void boardInsert(BoardDto dto, String userNick);
	//보드글삭제
	public void boardDelete(int boardSeq);
	//보드글수정하기
	public void boardDetailModi(BoardDto dto);
	//총게시물수
	public int selectNoticeTotCount(SearchVO searchVO);
	
}


