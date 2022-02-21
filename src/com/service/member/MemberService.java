package com.service.member;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.member.MemberDTO;

public interface MemberService {
	public MemberDTO selectMember(Map<String, Object> map) throws Exception;
	public int insertMember(MemberDTO dto) throws Exception;
	public MemberDTO idDuplicateCheck(String userid) throws Exception;
}
