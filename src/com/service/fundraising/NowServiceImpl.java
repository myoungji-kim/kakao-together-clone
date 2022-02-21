package com.service.fundraising;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.fundraising.NowDAO;
import com.dto.fundraising.NowDTO;

public class NowServiceImpl implements NowService {

	@Override
	public List<NowDTO> selectAllNow(String sort) throws Exception {
		List<NowDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			NowDAO dao = new NowDAO();
			list = dao.selectAllNow(session, sort);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<NowDTO> selectTopicNow(Map<String, Object> map) throws Exception {
		List<NowDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			NowDAO dao = new NowDAO();
			list = dao.selectTopicNow(session, map);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public NowDTO selectNowContent(String ncode) throws Exception {
		NowDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			NowDAO dao = new NowDAO();
			dto = dao.selectNowContent(session, ncode);
		} finally {
			session.close();
		}
		return dto;
	}
	
}
