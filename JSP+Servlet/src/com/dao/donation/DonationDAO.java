package com.dao.donation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.donation.CommentsDTO;
import com.dto.donation.MydonationDTO;
import com.dto.member.MemberDTO;

public class DonationDAO {
	public List<MydonationDTO> selectMyDonation(SqlSession session, int member_idx) throws Exception {
		return session.selectList("com.config.DonationMapper.selectMyDonation", member_idx);
	}
	
	public int insertDonation(SqlSession session, HashMap<String, Object> map) throws Exception {
		return session.insert("com.config.DonationMapper.insertDonation", map);
	}
	
	public int countComments(SqlSession session, HashMap<String, Object> map) throws Exception {
		return session.selectOne("com.config.DonationMapper.countComments", map);
	}
	
	public List<CommentsDTO> selectComments(SqlSession session, HashMap<String, Object> map) throws Exception {
		return session.selectList("com.config.DonationMapper.selectComments", map);
	}
}