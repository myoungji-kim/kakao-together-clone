package com.dao.fundraising;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.fundraising.NowDTO;

public class NowDAO {
	public List<NowDTO> selectAllNow(SqlSession session, String sort){
		return session.selectList("com.config.FundraisingMapper.selectAllNow", sort);
	}

	public List<NowDTO> selectTopicNow(SqlSession session, Map<String, Object> map) throws Exception {
		return session.selectList("com.config.FundraisingMapper.selectTopicNow", map);
	}
}
