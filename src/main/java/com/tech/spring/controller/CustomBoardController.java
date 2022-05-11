package com.tech.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tech.spring.dto.BoardDto;
import com.tech.spring.service.CustomBoardService;
import com.tech.spring.vopage.SearchVO;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
public class CustomBoardController {
	// 게시판 생성시, seq -> redirect -> RedirectAttribute ->addAttribute(boardSeq,{seq})

	@Autowired
	CustomBoardService customBoardService;

	// 게시물보드이동
	@GetMapping("/board")
	public String boardList(HttpServletRequest request, 
							SearchVO searchVO, 
							Model model) {
		System.out.println("=========pass by boardList()=============");

		// paging
		String strPage = request.getParameter("page");
		System.out.println("strPage1 : " + strPage);
		if (strPage == null) {
			strPage = "1";
		}
		System.out.println("strPage2 : " + strPage);
		
		int page = Integer.parseInt(strPage);
		searchVO.setPage(page);
		//searchVO.setPageStart(page);
		
		//totcnt
		int total = customBoardService.selectNoticeTotCount();
		searchVO.pageCalculate(total);
		System.out.println("total: " + total);
		
		System.out.println("clickPage : " + strPage);
		//log.info(searchVO);
		System.out.println("pageStart : " + searchVO.getPageStart());
		System.out.println("pageEnd : " + searchVO.getPageEnd());
		System.out.println("pageTot : " + searchVO.getTotPage());
		System.out.println("rowStart : " + searchVO.getRowStart());
		System.out.println("rowEnd : " + searchVO.getRowEnd());
		
		
		ArrayList<BoardDto> boardList = customBoardService.boardList();
		model.addAttribute("boardList", boardList);
		model.addAttribute("searchVO", searchVO);

		return "board/board";
	}

	// 게시물상세보기조회이동
	@GetMapping("/boardDetail")
	public String boardDetail(HttpServletRequest request, Model model) {
		System.out.println("=========pass by boardDetail()=============");
		int boardSeq = Integer.parseInt(request.getParameter("board_seq"));
		System.out.println("board_seq : " + boardSeq);

		BoardDto boardDto = new BoardDto();
		boardDto = customBoardService.boardDetail(boardSeq);

		model.addAttribute("boardDetail", boardDto);

		return "board/boardDetail";
	}

	// 게시물생성페이지이동
	@GetMapping("/boardInsert")
	public String boardInsert() {
		return "board/boardInsert";
	}

	// 게시물생성하기
	@PostMapping("/boardInsert")
	public ModelAndView boardInsertExecute(@RequestParam(value = "file", required = false) MultipartFile singleFile,
			HttpServletRequest request, BoardDto dto, HttpSession session) {
		ModelAndView mav = new ModelAndView("msg/msg");
		
		System.out.println(dto.getBoard_title());
		String originFileName = singleFile.getOriginalFilename();
		System.out.println("오리지날 파일네임 : "+originFileName);
		System.out.println("오리지날 파일네임 길이 : "+originFileName.length());
			
			// 1. 전송받은 파일 및 파일설명 값 가져오기
			System.out.println("singleFile : " + singleFile.toString());
			if(originFileName.length()!=0) { 
			// 2. 저장할 경로 가져오기
			String path = request.getSession().getServletContext().getRealPath("resources");
			System.out.println("path : " + path);
			String root = path + "\\uploadFiles";

			File file = new File(root);

			// 만약 uploadFiles 폴더가 없으면 생성해라 라는뜻
			if (!file.exists())
				file.mkdirs();

			// 업로드할 폴더 설정
			//System.out.println("1");
			System.out.println("originFileName : "+originFileName);
			//System.out.println("2");
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
				
			//System.out.println("3");
			String ranFileName = UUID.randomUUID().toString()+ext;
			//System.out.println("4");
			File changeFile = new File(root + "\\" + ranFileName);

			// 파일업로드
			try {
				singleFile.transferTo(changeFile);
				System.out.println("파일 업로드 성공");
			} catch (IllegalStateException | IOException e) {
				System.out.println("파일 업로드 실패");
				e.printStackTrace();
			}
			dto.setBoard_img_path(ranFileName);
			System.out.println("ranFileName : "+ranFileName);
		}
		
		
		customBoardService.boardInsert(dto, (String) session.getAttribute("userNick"));
		
		mav.addObject("msg", "게시글 전송");
		mav.addObject("url", "/board/boardDetail?board_seq=" + dto.getBoard_seq());

		return mav;
	}

	// 게시물수정페이지이동
	@GetMapping("/boardDetailModi")
	public String boardDetailModi(@RequestParam int board_seq, Model model) {

		BoardDto boardDto = new BoardDto();
		boardDto = customBoardService.boardDetail(board_seq);

		model.addAttribute("dto", boardDto);

		return "board/boardDetailModi";
	}

	// 게시판 수정하기
	@PostMapping("/boardDetailModi")
	public ModelAndView boardDetailModiAction(BoardDto dto) {
		ModelAndView mav = new ModelAndView("msg/msg");

		customBoardService.boardDetailModi(dto);

		mav.addObject("msg", "게시글 수정");
		mav.addObject("url", "/board/boardDetail?board_seq=" + dto.getBoard_seq());

		System.out.println("title : " + dto.getBoard_title());

		return mav;
	}

//		@PostMapping("/boardDetailModi")
//		public ModelAndView boardDetailModiAction(BoardDto dto, 
//												  ModelAndView mav) {
//
//			customBoardService.boardDetailModi(dto); // 수정 db
//			
//			mav.setViewName("msg/msg");
//			mav.addObject("msg", "게시글 수정");
//			mav.addObject("url", "/board/boardDetail?board_seq=" + dto.getBoard_seq());
//			
//			return mav;
//		}	
//		
//		@PostMapping("/boardDetailModi")
//		public String boardDetailModiAction(BoardDto dto, 
//										    Model model) {
//
//			customBoardService.boardDetailModi(dto);	
//			
//			model.addAttribute("msg", "게시글 수정");
//			model.addAttribute("url", "/board/boardDetail?board_seq=" + dto.getBoard_seq());
//			
//			return "msg/msg";
//		}	

	// 게시물삭제
	@PostMapping("/boardDelete")
	public ModelAndView boardDelete(@RequestParam("board_seq") int board_seq) {

		ModelAndView mav = new ModelAndView("msg/msg");

		customBoardService.boardDelete(board_seq);

		mav.addObject("msg", "게시글 삭제");
		mav.addObject("url", "/board/board");

		return mav;
	}
	
	
	
	

}