package com.service.fundraising;

import java.util.List;
import java.util.Map;

import com.dto.fundraising.NowDTO;

public interface NowService {
	public List<NowDTO> selectAllNow(String sort) throws Exception;
	public List<NowDTO> selectTopicNow(Map<String, Object> map) throws Exception;
}
