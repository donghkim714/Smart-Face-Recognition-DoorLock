package com.second.example.service;

import javax.servlet.http.HttpSession;

import com.member.example.dto.MemberDTO;
import com.second.example.dto.SecondDTO;

public interface SecondService {
	//ȸ������ ���μ���
	public boolean secondCheck(SecondDTO dto, HttpSession session);
	public SecondDTO view(SecondDTO dto);


}
