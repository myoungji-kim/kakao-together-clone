package com.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.board.BoardDTO;

public class BoardDAO {
	public List<BoardDTO> selectAllNow(SqlSession session, HashMap<String, Object> map){
		return session.selectList("com.config.BoardMapper.selectAllNow", map);
	}
	
	public BoardDTO selectNowContent(SqlSession session, HashMap<String, Object> map) throws Exception {
		return session.selectOne("com.config.BoardMapper.selectNowContent", map);
	}
	
	public String selectNowContentTag(SqlSession session, String code) throws Exception {
		return session.selectOne("com.config.BoardMapper.selectNowContentTag", code);
	}
	
	public int insertNow(SqlSession session, BoardDTO dto) throws Exception {
		return session.insert("com.config.BoardMapper.insertNow", dto);
	}
	
	public int updateNow(SqlSession session, BoardDTO dto) throws Exception {
		return session.update("com.config.BoardMapper.updateNow", dto);
	}
	
	

	
	
	
	
	
	
	public List<BoardDTO> selectAllProm(SqlSession session, HashMap<String, Object> map) throws Exception {
		return session.selectList("com.config.BoardMapper.selectAllProm", map);
	} 
	
	public BoardDTO selectPromContent(SqlSession session, HashMap<String, Object> map) {
		return session.selectOne("com.config.BoardMapper.selectPromContent", map);
	}
	
	public int insertProm(SqlSession session, BoardDTO dto) throws Exception {
		return session.insert("com.config.BoardMapper.insertProm", dto);
	}
	
	public int updateProm(SqlSession session, BoardDTO dto) {
		System.out.println(dto.toString());
		return session.update("com.config.BoardMapper.updateProm", dto);
	}
	
	
	public int deleteOne(SqlSession session, int idx) throws Exception {
		return session.delete("com.config.BoardMapper.deleteOne", idx);
	}

	public int countTotalProm(SqlSession session) {
		return session.selectOne("com.config.BoardMapper.countTotalProm");
	}
}
