package com.second.example.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.second.example.dto.SecondDTO;

@Repository
public class SecondDAOImpl implements SecondDAO {
	@Inject
	SqlSession sqlSession;

	public boolean secondCheck(SecondDTO dto) {
		String name= sqlSession.selectOne("second.secondCheck",dto);
		return (name == null) ? false : true;
	}
	@Override
	public SecondDTO view(SecondDTO dto) {
		return sqlSession.selectOne("second.view",dto);
	}

}
