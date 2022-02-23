package com.dao.fundraising;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.fundraising.NowDTO;

public class NowDAO {
	public List<NowDTO> selectAllNow(SqlSession session, String sort){
		return session.selectList("com.config.NowMapper.selectAllNow", sort);
	}

	public List<NowDTO> selectTopicNow(SqlSession session, Map<String, Object> map) throws Exception {
		return session.selectList("com.config.NowMapper.selectTopicNow", map);
	}
	
	public NowDTO selectNowContent(SqlSession session, String idx) throws Exception {
		return session.selectOne("com.config.NowMapper.selectNowContent", idx);
	}
	
	public String selectNowContentTag(SqlSession session, String code) throws Exception {
		return session.selectOne("com.config.NowMapper.selectNowContentTag", code);
	}
	
	public int insertNow(SqlSession session, NowDTO dto) throws Exception {
		return session.insert("com.config.NowMapper.insertNow", dto);
	}
}
