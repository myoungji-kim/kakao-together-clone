package com.service.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.board.BoardDAO;
import com.dto.board.BoardDTO;

public class BoardServiceImpl implements BoardService {

	// Count
	@Override
	public int countTotalProm(HashMap<String, Object> map) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			num = dao.countTotalProm(session, map);
		} finally {
			session.close();
		}
		return num;
	}
	
	@Override
	public int countTotalMywrite(HashMap<String, Object> map) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			num = dao.countTotalMywrite(session, map);
		} finally {
			session.close();
		}
		return num;
	}
	
	
	
	// Fundraising
	@Override
	public List<BoardDTO> selectAllNow(HashMap<String, Object> map) throws Exception {
		List<BoardDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			list = dao.selectAllNow(session, map);
		} finally {
			session.close();
		}
		return list;
	}


	@Override
	public BoardDTO selectNowContent(HashMap<String, Object> map) throws Exception {
		BoardDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			dto = dao.selectNowContent(session, map);
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
			BoardDAO dao = new BoardDAO();
			name = dao.selectNowContentTag(session, code);
		} finally {
			session.close();
		}
		return name;
	}

	@Override
	public int insertNow(BoardDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			num = dao.insertNow(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public int updateNow(BoardDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			num = dao.updateNow(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	
	
	
	
	
	
	
	// Promotion
	@Override
	public List<BoardDTO> selectAllProm(HashMap<String, Object> map) throws Exception {
		List<BoardDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			list = dao.selectAllProm(session, map);
		} finally {
			session.close();
		}
		return list;
	}


	@Override
	public int insertProm(BoardDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			num = dao.insertProm(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}


	@Override
	public BoardDTO selectPromContent(HashMap<String, Object> map) throws Exception {
		BoardDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			dto = dao.selectPromContent(session, map);
		} finally {
			session.close();
		}
		return dto;
	}


	@Override
	public int updateProm(BoardDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			num = dao.updateProm(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}
	
	
	
	
	// Delete
	@Override
	public int deleteOne(int idx) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			num = dao.deleteOne(session, idx);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}


	

	// Mywrite
	@Override
	public List<BoardDTO> selectAllMywrite(HashMap<String, Object> map) throws Exception {
		List<BoardDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			list = dao.selectAllMywrite(session, map);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<BoardDTO> searchOne(HashMap<String, Object> map) throws Exception {
		List<BoardDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			list = dao.searchOne(session, map);
		} finally {
			session.close();
		}
		return list;
	}


	
	
}
