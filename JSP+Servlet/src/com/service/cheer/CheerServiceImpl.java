package com.service.cheer;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.cheer.CheerDAO;

public class CheerServiceImpl implements CheerService {
	@Override
	public int selectCheer(int content_idx) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CheerDAO dao = new CheerDAO();
			num = dao.selectCheer(session, content_idx);
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public int insertCheer(HashMap<String, Object> map) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CheerDAO dao = new CheerDAO();
			num = dao.insertCheer(session, map);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public int deleteCheer(int content_idx) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CheerDAO dao = new CheerDAO();
			num = dao.deleteCheer(session, content_idx);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

}
