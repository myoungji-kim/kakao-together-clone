package com.service.fundraising;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.fundraising.NowDTO;

public interface NowService {
	public List<NowDTO> selectAllNow(String sort) throws Exception;
	public List<NowDTO> selectTopicNow(Map<String, Object> map) throws Exception;
	public NowDTO selectNowContent(String idx) throws Exception;
	public String selectNowContentTag(String code) throws Exception;
	public int insertNow(NowDTO dto) throws Exception;
}
