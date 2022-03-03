package com.dao.cheer;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.member.MemberDTO;

public class CheerDAO {
	public int selectCheer(SqlSession session, int content_idx) throws Exception {
		return session.selectOne("com.config.CheerMapper.selectCheer", content_idx);
	}
	
	public int insertCheer(SqlSession session, HashMap<String, Object> map) throws Exception {
		return session.insert("com.config.CheerMapper.insertCheer", map);
	}
	
	public int deleteCheer(SqlSession session, int content_idx) throws Exception {
		return session.delete("com.config.CheerMapper.deleteCheer", content_idx);
	}
}