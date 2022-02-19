package com.dao.fundraising;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.fundraising.NowDTO;

public class NowDAO {
	public List<NowDTO> selectAllNow(SqlSession session){
		return session.selectList("com.config.FundraisingMapper");
	}
}
