package com.service.member;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.member.MemberDAO;
import com.dto.member.MemberDTO;

public class MemberServiceImpl implements MemberService {

	@Override
	public MemberDTO selectMember(Map<String, Object> map) throws Exception {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			dto = dao.selectMember(session, map);
		} finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int insertMember(MemberDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			num = dao.insertMember(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public MemberDTO idDuplicateCheck(String userid) throws Exception {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			dto = dao.idDuplicateCheck(session, userid);
		} finally {
			session.close();
		}
		return dto;
	}

}
