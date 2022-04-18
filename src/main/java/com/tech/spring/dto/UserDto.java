package com.tech.spring.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private int custom_user_seq	;	/*시퀀스*/
	private String custom_user_name;	/*유저 이름*/
	private String custom_user_nick; /*유저 닉네임*/
	private String custom_user_email;	/*유저 메일*/
	private String custom_user_pswd; /*유저 비밀번호*/
	private String custom_user_birth;	 /*유저 생년월일*/
	private String custom_user_phone;	/*유저 휴대폰번호*/
	private String custom_user_address; /*유저 주소	*/
	private String custom_user_auth ; /*유저 권한*/
	private String custom_user_del_yn;	/*유저 삭제여부*/
	private Timestamp custom_user_reg_date; /*유저 등록일*/
	private Timestamp custom_user_mod_date; /*유저 수정일*/
}
