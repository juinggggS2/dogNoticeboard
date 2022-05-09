package com.tech.spring.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
//	private int board_seq; /*게시판 시퀀스*/
//	private String board_title;  /*게시판 제목*/
//	private String board_text; /*게시판 내용*/
//	private String board_writer; /* 게시판 작성자 */
//	private Timestamp board_reg_date; /* 게시판 작성시간 */
//	private Timestamp board_mod_date; /* 게시판 수정시간 */
//	private String board_img_path; /* 게시판 이미지*/
//	private String board_del_yn; /*게시판 삭제여부*/
	
	private int board_seq; 
	private String board_title
					,board_text
					,board_writer
					, board_img_path
					, board_del_yn; 
	private Timestamp board_reg_date
					, board_mod_date; 
}

