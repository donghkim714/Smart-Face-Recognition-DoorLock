package com.member.example.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.member.example.dao.MemberDAO;
import com.member.example.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	MemberDAO memberDao;

	@Override
	public void memberWriteProcess(MemberDTO dto) {
		memberDao.memberJoinMethod(dto);
	}

	@Override
	public boolean loginCheck(MemberDTO dto, HttpSession session) {
		boolean result = memberDao.loginCheck(dto);
		if(result) {
			MemberDTO dto2 = viewMember(dto);
			session.setAttribute("mem_id", dto2.getMem_id());
			session.setAttribute("mem_pw", dto2.getMem_pw());
		}
		return result;
	}

	@Override
	public MemberDTO viewMember(MemberDTO dto) {
		return memberDao.viewMember(dto);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate(); //세션 정보 초기화
		}

	@Override
	public List<MemberDTO> memberList() {
		
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberDTO dto) throws Exception {
		memberDao.insertMember(dto);
	}

	@Override
	public void deleteMember(String mem_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}

	
}
