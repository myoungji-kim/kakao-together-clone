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
	public NowDTO selectNowContent(String idx) throws Exception {
		NowDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			NowDAO dao = new NowDAO();
			dto = dao.selectNowContent(session, idx);
		} finally {
			session.close();
		}
		return dto;
	}

	@Override
	public String selectNowContentTag(String code) throws Exception {
		String name = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			NowDAO dao = new NowDAO();
			name = dao.selectNowContentTag(session, code);
		} finally {
			session.close();
		}
		return name;
	}

	@Override
	public int insertNow(NowDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			NowDAO dao = new NowDAO();
			num = dao.insertNow(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public int updateNow(NowDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			NowDAO dao = new NowDAO();
			num = dao.updateNow(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public int deleteNow(int idx) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			NowDAO dao = new NowDAO();
			num = dao.deleteNow(session, idx);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}
	
}
