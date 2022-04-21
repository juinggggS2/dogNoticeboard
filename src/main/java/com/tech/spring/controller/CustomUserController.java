package com.tech.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tech.spring.dto.UserDto;
import com.tech.spring.service.CustomUserService;

@Controller
@RequestMapping("/user")
public class CustomUserController {

	@Autowired
	CustomUserService customUserService;

	// 회원가입이동
	@GetMapping("/register")
	public String register() {
		System.out.println("=========pass by register()=============");

		return "user/register";
	}

	// 회원가입페이지
	@PostMapping("/register")
	public String registerToLogin(UserDto dto) {
		// User
		// Class = User
		// Variable = user
		// Method = getUserInfo
		// Field = userName, userAddress, userPwd
		// DB table = tb_user_info
		// DB column = user_name, user_address, user_pwd || userName, userAddress,
		// userPwd
		// Field = userName & DB col = user_name
		// Alias -> select user_name as userName from user where ~
		System.out.println("=========pass by registerToLogin()=============");
		System.out.println("DTO: " + dto.toString());
		System.out.println("name: " + dto.getCustom_user_name());
		System.out.println("nick: " + dto.getCustom_user_nick());
		System.out.println("email: " + dto.getCustom_user_email());
		System.out.println("pswd: " + dto.getCustom_user_pswd());
		System.out.println("birth: " + dto.getCustom_user_birth());
		System.out.println("phone: " + dto.getCustom_user_phone());
		System.out.println("address : " + dto.getCustom_user_address());

		customUserService.registerToLogin(dto);
		return "redirect:login";
	}

	// 닉네임 중복 체크, 글자수 제한(2~30자) //220420적용안되서수정해야됌
	@ResponseBody
	@PostMapping("/nickCheck")
	public int nickCheck(@RequestParam String custom_user_nick) {
		return customUserService.nickCheck(custom_user_nick);

	}

	// 이멜중복체크 //220420적용안되서수정해야됌
	@ResponseBody
	@PostMapping("/emailCheck")
	public int emailCheck(@RequestParam String custom_user_email) {
		return customUserService.emailCheck(custom_user_email);

	}

	// 로그인이동
	@GetMapping("/login")
	public String login() {
		System.out.println("=========pass by login()=============");

		return "user/login";
	}

	// 로그인페이지
	@PostMapping("/login")
	public ModelAndView loginToMain(UserDto dto,
			@RequestParam(value = "autoLogin", defaultValue = "off") String autoLogin, HttpSession session,
			HttpServletResponse response) {
		System.out.println("=========pass by LoginToMain()=============");

		ModelAndView mav = new ModelAndView("msg/msg");

		UserDto userDto = customUserService.loginToMain(dto.getCustom_user_email());

		// 디비내 비번, 클라이언트비번이 같을 시
		if (userDto.getCustom_user_pswd().equals(dto.getCustom_user_pswd())) {
			session.setAttribute("userName", userDto.getCustom_user_name());
			session.setAttribute("userNick", userDto.getCustom_user_nick());
			session.setAttribute("userEmail", userDto.getCustom_user_email());
			session.setAttribute("userAuth", userDto.getCustom_user_auth());

			if (autoLogin.equals("off")) {
				//자동로그인off
				Cookie loginCookie = new Cookie("autoLogin",null);
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				
			} else {
				//자동로그인on
				Cookie loginCookie = new Cookie("autoLogin",userDto.getCustom_user_email());
				loginCookie.setPath("/"); //쿠키의 저장경로는 기본 uri경로 홈페이지 시작 uri
				loginCookie.setMaxAge(60*30); //30분
				response.addCookie(loginCookie); //response에 쿠키를 담아 클라이언트에 보냄
				System.out.println("loginSuccess");
			}
			
			mav.addObject("msg", "로그인에 성공하였습니다.");
			mav.addObject("url", "/main");
			
		} else {
			mav.addObject("msg", "로그인에 실패하였습니다.");
			mav.addObject("url", "/user/login");
		}

		return mav;

	}

}