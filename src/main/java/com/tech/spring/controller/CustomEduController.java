package com.tech.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class CustomEduController {
	
	
	@RequestMapping("/main")
	public String main() {
		System.out.println("=========pass by main()=============");
		
		return "/main";
		
	}
	
//	@RequestMapping("/main")
//	public RedirectView main() {
//		RedirectView rdv = new RedirectView();
//		rdv.setUrl("user/login");
//		return rdv;
//	}
	
//	@RequestMapping("/main")
//	public ModelAndView main1() {
//		System.out.println("=========pass by main()=============");
//		
//		ModelAndView mav = new ModelAndView(new RedirectView("user/login"));
//		
//		return mav;
//		
//	}	
	
}