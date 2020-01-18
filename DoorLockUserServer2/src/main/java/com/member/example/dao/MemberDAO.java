package com.member.example.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.member.example.dto.MemberDTO;

public interface MemberDAO {
	public void memberJoinMethod(MemberDTO dto);
	public MemberDTO viewMember(MemberDTO dto);
	public void logout(HttpSession session);
	public boolean loginCheck(MemberDTO dto);
	public List<MemberDTO> memberList();
	public void insertMember(MemberDTO dto) throws Exception;
	public void deleteMember(String mem_id);
	public void updateMember(MemberDTO dto);
	public boolean secondCheck(MemberDTO dto);
}