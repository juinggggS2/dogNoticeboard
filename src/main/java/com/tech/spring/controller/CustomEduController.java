package com.tech.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CustomEduController {
	
	
	@RequestMapping("/main")
	public String main(Model model) {
		System.out.println("=========pass by main()=============");
		/* CustomUserService.test(); */
		return "/main";
		
	}
	
		
	
}