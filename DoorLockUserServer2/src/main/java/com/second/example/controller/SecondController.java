package com.second.example.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.second.example.dto.SecondDTO;
import com.second.example.service.SecondService;

@Controller
@RequestMapping("/second/*")
public class SecondController {
	@Inject
	SecondService secondService;
	
	@RequestMapping("secondCheck.do")
	public String secondCheck(@ModelAttribute SecondDTO dto, HttpSession session) {
		System.out.println(secondService.secondCheck(dto, session));
		boolean result = secondService.secondCheck(dto, session);
//		ModelAndView mav = new ModelAndView();
		System.out.println(result);
		if(result == true) {
			return "redirect:http://192.168.43.158/open.php";
//			mav.setViewName("http://192.168.43.158/open.php");
//			mav.addObject("msg","success");
		}
		else {
			return "second/cantOpen";
//			mav.setViewName("second/cantOpen");
//			mav.addObject("msg","failure");
		}
	}
}
