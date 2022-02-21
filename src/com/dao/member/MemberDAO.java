package com.dao.member;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.member.MemberDTO;

public class MemberDAO {
	public MemberDTO selectMember(SqlSession session, Map<String, Object> map) throws Exception {
		return session.selectOne("com.config.MemberMapper.selectMember", map);
	}
	
	public int insertMember(SqlSession session, MemberDTO dto) throws Exception {
		return session.insert("com.config.MemberMapper.insertMember", dto);
	}

	public MemberDTO idDuplicateCheck(SqlSession session, String userid) {
		return session.selectOne("com.config.MemberMapper.idDuplicateCheck", userid);
	}
}
