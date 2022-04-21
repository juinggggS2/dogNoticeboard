package com.tech.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.spring.dto.BoardDto;
import com.tech.spring.service.CustomBoardService;
import com.tech.spring.vopage.SearchVO;

@Controller
@RequestMapping("/board")
public class CustomBoardController {
	// 게시판 생성시, seq -> redirect -> RedirectAttribute ->addAttribute(boardSeq,{seq})
	
	@Autowired
	CustomBoardService customBoardService;
	
	//보드이동
	@GetMapping("/board")
	public String boardList(HttpServletRequest request, Model model) {
		System.out.println("=========pass by board()=============");
		
		
		  ArrayList<BoardDto> boardList = customBoardService.boardList();
		  model.addAttribute("boardDto", boardList);
		 
		
		return "board/board";	
	}
}