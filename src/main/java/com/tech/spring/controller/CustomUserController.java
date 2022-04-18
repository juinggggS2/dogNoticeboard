package com.tech.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.spring.dto.UserDto;
import com.tech.spring.service.CustomUserService;

@Controller
@RequestMapping("/user")
public class CustomUserController {

	@Autowired
	CustomUserService customUserService;
	
	@GetMapping("/register")
	public String register() {
		System.out.println("=========pass by register()=============");
		
		return "user/register";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("=========pass by login()=============");

		return "user/login";
	}
	
	//회원가입페이지
	@PostMapping("/registerToLogin")
	public String registerToLogin(UserDto dto) {
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
			System.out.println("DTO: "+dto.toString());
			System.out.println("name: "+dto.getCustom_user_name());
			System.out.println("nick: "+dto.getCustom_user_nick());
			System.out.println("email: "+dto.getCustom_user_email());
			System.out.println("pswd: "+dto.getCustom_user_pswd());
			System.out.println("birth: "+dto.getCustom_user_birth());
			System.out.println("phone: "+dto.getCustom_user_phone());
			System.out.println("address : "+dto.getCustom_user_address());
			
			customUserService.registerToLogin(dto);
			return "redirect:login";
	}
	
	
	//로그인페이지
	@PostMapping("/loginCheck")
	public String LoginToMain(HttpServletRequest request, Model model, UserDto userDto) {
		System.out.println("=========pass by registerToLogin()=============");
		
		String customUserEmail = request.getParameter("userEmail");
		String customUserPswd = request.getParameter("userPswd");
		System.out.println("customUserEmail : "+customUserEmail);
		System.out.println("customUserPswd : "+customUserPswd);
		
		customUserService.LoginToMain(customUserEmail, customUserPswd);
		

		
		return "redirect:main";
		
	}
	
}