package com.service.cheer;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.member.MemberDTO;

public interface CheerService {
	public int selectCheer(int content_idx) throws Exception;
	public int insertCheer(HashMap<String, Object> map) throws Exception;
	public int deleteCheer(int content_idx) throws Exception;
}
