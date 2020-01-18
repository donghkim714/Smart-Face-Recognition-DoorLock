package com.member.example.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.member.example.dto.MemberDTO;

public interface MemberService {
	//회원가입 프로세스
	public void memberWriteProcess(MemberDTO dto);
	public boolean loginCheck(MemberDTO dto, HttpSession session);
	public MemberDTO viewMember(MemberDTO dto);
	public void logout(HttpSession session);
	public List<MemberDTO> memberList();
	public void insertMember(MemberDTO dto) throws Exception;
	public void deleteMember(String mem_id);
	public void updateMember(MemberDTO dto);
}
