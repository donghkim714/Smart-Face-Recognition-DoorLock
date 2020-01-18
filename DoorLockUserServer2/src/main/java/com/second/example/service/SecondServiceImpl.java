package com.second.example.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.second.example.dao.SecondDAO;
import com.second.example.dto.SecondDTO;

@Service
public class SecondServiceImpl implements SecondService {
	@Inject
	SecondDAO secondDao;
	
	@Override
	public boolean secondCheck(SecondDTO dto, HttpSession session) {
		boolean result = secondDao.secondCheck(dto);
		if(result) {
			SecondDTO dto2 = view(dto);
			session.setAttribute("second_pw", dto2.getSecond_pw());
		}
		return result;
	}
	
	@Override
	public SecondDTO view(SecondDTO dto) {
		return secondDao.view(dto); 
	}
}
