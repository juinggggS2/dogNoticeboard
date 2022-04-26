package com.tech.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tech.spring.dto.BoardDto;
import com.tech.spring.service.CustomBoardService;
import com.tech.spring.vopage.SearchVO;

@Controller
@RequestMapping("/board")
public class CustomBoardController {
	// 게시판 생성시, seq -> redirect -> RedirectAttribute ->addAttribute(boardSeq,{seq})
	
	@Autowired
	CustomBoardService customBoardService;
	
	//게시물보드이동
	@GetMapping("/board")
	public String boardList(HttpServletRequest request, Model model) {
		System.out.println("=========pass by boardList()=============");
		
		  ArrayList<BoardDto> boardList = customBoardService.boardList();
		  model.addAttribute("boardList", boardList);
		 
		
		return "board/board";	
	}
	
	//게시물상세보기조희이동
	@GetMapping("/boardDetail")
	public String boardDetail(HttpServletRequest request, Model model) {
		System.out.println("=========pass by boardDetail()=============");
		int boardSeq = Integer.parseInt(request.getParameter("board_seq"));
		System.out.println("board_seq : "+boardSeq);
		
		BoardDto boardDto = new BoardDto();
		boardDto = customBoardService.boardDetail(boardSeq);
		
		model.addAttribute("boardDetail", boardDto);
		
		
		return "board/boardDetail";
	}
	
	//게시물생성페이지이동
	@GetMapping("/boardInsert")
	public String boardInsert() {
		return "board/boardInsert";
	}	
	
	//게시물생성하기
	@PostMapping("/boardInsert")
	public ModelAndView boardInsertExecute(BoardDto dto, HttpSession session) {
		ModelAndView mav = new ModelAndView("msg/msg");
		
		customBoardService.boardInsert(dto, (String) session.getAttribute("userNick"));
		
		mav.addObject("msg", "게시글 전송");
		mav.addObject("url", "/board/boardDetail?board_seq=" + dto.getBoard_seq());
		
		return mav;
	}
	
	
	//게시물수정페이지이동
		@GetMapping("/boardDetailModi")
		public String boardDetailModi() {
			return "board/boardDetailModi";
		}	
		
		//게시물삭제
		@RequestMapping("/boardDelete")
		public ModelAndView boardDelete(@RequestParam int board_seq) {
			
			ModelAndView mav = new ModelAndView("msg/msg");
			
			customBoardService.boardDelete(board_seq);
			
			mav.addObject("msg", "게시글 삭제");
			mav.addObject("url", "/board/board");
			
			return mav;
			
			
			
		}
	
	
	
	
	
}