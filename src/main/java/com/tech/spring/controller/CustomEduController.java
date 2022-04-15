package com.tech.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.spring.service.CustomEduService;

@Controller
public class CustomEduController {
	
	@Autowired
	CustomEduService customEduService;

	/*
	 * @Autowired CustomUserService CustomUserService;
	 */
	
	@RequestMapping("/main")
	public String main(Model model) {
		System.out.println("=========pass by main()=============");
		/* CustomUserService.test(); */
		return "/main";
		
	}
	
		@RequestMapping("/register")
		public String register(Model model) {
			System.out.println("=========pass by register()=============");
			
			return "register";
		}
		
		@RequestMapping("/login")
		public String login(Model model) {
			System.out.println("=========pass by login()=============");

			return "login";
		}
	
}