package com.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.board.BoardDTO;

public interface BoardService {
	// Count
	public int countTotalProm(HashMap<String, Object> map) throws Exception;
	
	// Now
	public List<BoardDTO> selectAllNow(HashMap<String, Object> map) throws Exception;
	public BoardDTO selectNowContent(HashMap<String, Object> map) throws Exception;
	public String selectContentTag(String code) throws Exception;
	public int insertNow(BoardDTO dto) throws Exception;
	public int updateNow(BoardDTO dto) throws Exception;
	
	// Epil
	public int insertEpil(BoardDTO dto) throws Exception;
	public List<BoardDTO> selectAllEpil(HashMap<String, Object> map) throws Exception;
	public BoardDTO selectEpilContent(HashMap<String, Object> map) throws Exception;
	public int updateEpil(BoardDTO dto) throws Exception;
	
	// Prom
	public List<BoardDTO> selectAllProm(HashMap<String, Object> map) throws Exception;
	public BoardDTO selectPromContent(HashMap<String, Object> map) throws Exception;
	public int insertProm(BoardDTO dto) throws Exception;
	public int updateProm(BoardDTO dto) throws Exception;
	
	
	// Delete
	public int deleteOne(int idx) throws Exception;
	
	
	// Mywrite
	public int countTotalMywrite(HashMap<String, Object> map) throws Exception;
	public List<BoardDTO> selectAllMywrite(HashMap<String, Object> map) throws Exception;
	
	
	// Search
	public List<BoardDTO> searchOne(HashMap<String, Object> map) throws Exception;
}
