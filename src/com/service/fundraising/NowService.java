package com.service.fundraising;

import java.util.List;

import com.dto.fundraising.NowDTO;

public interface NowService {
	public List<NowDTO> selectAllNow();
}
