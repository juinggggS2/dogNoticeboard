package com.tech.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.spring.dto.UserDto;
import com.tech.spring.service.CustomUserService;

@Controller
public class CustomUserController {

	@Autowired
	CustomUserService customUserService;
	
	//회원가입페이지
	@RequestMapping(method = RequestMethod.POST, value = "/registerToLogin")
	public String registerToLogin(HttpServletRequest request, Model model, UserDto userDto) {
		// User
		// Class = User
		// Variable = user
		// Method = getUserInfo
		// Field = userName, userAddress, userPwd
		// DB table = tb_user_info
		// DB column = user_name, user_address, user_pwd || userName, userAddress, userPwd
		// Field = userName & DB col = user_name
		// Alias -> select user_name as userName from user where ~ 
			System.out.println("=========pass by registerToLogin()=============");
			System.out.println("DTO: "+userDto.toString());
			System.out.println("name: "+userDto.getCustomUserName());
			System.out.println("nick: "+userDto.getCustomUserNick());
			System.out.println("email: "+userDto.getCustomUserEmail());
			System.out.println("pswd: "+userDto.getCustomUserPswd());
			System.out.println("birth: "+userDto.getCustomUserBirth());
			System.out.println("phone: "+userDto.getCustomUserPhone());
			System.out.println("address : "+userDto.getCustomUserAddress());
			
			customUserService.registerToLogin(userDto);
			return "redirect:login";
	}
	
	//로그인페이지
	@RequestMapping(method = RequestMethod.POST, value = "/loginCheck")
	public String LoginToMain(HttpServletRequest request, Model model, UserDto userDto) {
		System.out.println("=========pass by registerToLogin()=============");
		
		String customUserEmail = request.getParameter("userEmail");
		String customUserPswd = request.getParameter("userPswd");
		
		System.out.println("customUserEmail : "+customUserEmail);
		System.out.println("customUserPswd : "+customUserPswd);
		
		
		
		
		
		return "redirect:main";
		
	}
	
}