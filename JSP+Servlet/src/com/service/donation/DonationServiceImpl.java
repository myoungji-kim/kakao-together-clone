package com.service.donation;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.cheer.CheerDAO;
import com.dao.donation.DonationDAO;
import com.dto.donation.CommentsDTO;
import com.dto.donation.MydonationDTO;

public class DonationServiceImpl implements DonationService {
	
	@Override
	public List<MydonationDTO> selectMyDonation(int member_idx) throws Exception {
		List<MydonationDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			DonationDAO dao = new DonationDAO();
			list = dao.selectMyDonation(session, member_idx);
		} finally {
			session.close();
		}
		return list;
	}
	
	@Override
	public int insertDonation(HashMap<String, Object> map) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			DonationDAO dao = new DonationDAO();
			num = dao.insertDonation(session, map);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public List<CommentsDTO> selectComments(HashMap<String, Object> map) throws Exception {
		List<CommentsDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			DonationDAO dao = new DonationDAO();
			list = dao.selectComments(session, map);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int countComments(HashMap<String, Object> map) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			DonationDAO dao = new DonationDAO();
			num = dao.countComments(session, map);
		} finally {
			session.close();
		}
		return num;
	}

}
