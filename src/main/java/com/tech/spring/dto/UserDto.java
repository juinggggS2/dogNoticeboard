package com.tech.spring.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private int customUserSeq	;	/*시퀀스*/
	private String customUserName;	/*유저 이름*/
	private String customUserNick; /*유저 닉네임*/
	private String customUserEmail;	/*유저 메일*/
	private String customUserPswd ; /*유저 비밀번호*/
	private String customUserBirth ;	 /*유저 생년월일*/
	private String customUserPhone ;	/*유저 휴대폰번호*/
	private String customUserAddress; /*유저 주소	*/
	private String customUserAuth ; /*유저 권한*/
	private String customUserDelYn;	/*유저 삭제여부*/
	private Timestamp userRegDate; /*유저 등록일*/
	private Timestamp userModDate; /*유저 수정일*/
}
