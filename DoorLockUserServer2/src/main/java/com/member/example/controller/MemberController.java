package com.member.example.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.member.example.dto.MemberDTO;
import com.member.example.service.MemberService;
import com.mysql.cj.api.Session;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger=LoggerFactory.getLogger(MemberController.class);
	@Inject
	MemberService memberService;
	
	@RequestMapping("login.do")
	public String MemberList(Model model) throws Exception {
		return "member/login"; 
	}
	
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberDTO dto, HttpSession session) {
		System.out.println(memberService.loginCheck(dto, session));
		boolean result = memberService.loginCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		if(result == true) {
			mav.setViewName("home");
			mav.addObject("msg","success");
		}
		else {
			mav.setViewName("member/login");
			mav.addObject("msg","failure");
		}
		return mav;
	}
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg","logout");
		return mav;
	}
	@RequestMapping("list.do")
	public String memberList(Model model) {
		List<MemberDTO> list = memberService.memberList();
		model.addAttribute("list", list);
		return "member/member_list";
	}
	//회원 등록 페이지 이동
	@RequestMapping(value="write.do",method=RequestMethod.GET)
	public String memberWrite() {
		return "member/member_write";
	}
	
	//회원 등록 처리후 => 회원 목록으로 리다이렉트
	//@ModelAttribute에 폼에서 입력한 데이터 저장
	//폼에서 입력한 데이터 받아오는법
		//public String memberInsert(HttpServlet reqeust){
		//public String memberInsert(String userId, String userPw,.....){
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String memberInsert(@ModelAttribute MemberDTO dto) throws Exception {
		System.out.println(dto.getMem_id());
		memberService.insertMember(dto);
		return "redirect:list.do";
	}
	

}