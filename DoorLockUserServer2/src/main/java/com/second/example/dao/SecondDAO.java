package com.second.example.dao;

import com.second.example.dto.SecondDTO;

public interface SecondDAO {
	public boolean secondCheck(SecondDTO dto);
	public SecondDTO view(SecondDTO dto);

}