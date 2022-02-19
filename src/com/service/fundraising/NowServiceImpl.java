package com.service.fundraising;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.fundraising.NowDAO;
import com.dto.fundraising.NowDTO;

public class NowServiceImpl implements NowService {

	@Override
	public List<NowDTO> selectAllNow() {
		List<NowDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			NowDAO dao = new NowDAO();
			list = dao.selectAllNow(session);
		} finally {
			session.close();
		}
		return list;
	}
	
}
