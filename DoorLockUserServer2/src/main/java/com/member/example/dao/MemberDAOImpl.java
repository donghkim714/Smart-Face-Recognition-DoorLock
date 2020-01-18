package com.member.example.dao;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.member.example.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public void memberJoinMethod(MemberDTO dto) {
		sqlSession.insert("member.memberWrite",dto);
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public MemberDTO viewMember(MemberDTO dto) {
		return sqlSession.selectOne("member.viewMember",dto);
	}

	@Override
	public void logout(HttpSession session) {
		
	}

	@Override
	public boolean loginCheck(MemberDTO dto) {
		// TODO Auto-generated method stub
		String name= sqlSession.selectOne("member.loginCheck",dto);
		return (name == null) ? false : true;
	}

	@Override
	public List<MemberDTO> memberList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("member.memberList");
	}
	

	@Override
	public void insertMember(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("member.insertMember",dto);
	}

	@Override
	public void deleteMember(String mem_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("member.deleteMember",mem_id);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}

	public boolean secondCheck(MemberDTO dto) {
		String pass= sqlSession.selectOne("second.secondCheck",dto);
		return (pass == null) ? false : true;
	}
	
	
	
}
