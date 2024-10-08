package com.tanya.movie_rating.service.adminprofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanya.movie_rating.dao.MCodesDao;
import com.tanya.movie_rating.dto.adminprofile.InitAdminProfileResponseDto;
import com.tanya.movie_rating.entity.MCodes;

@Service
public class AdminProfileServiceImpl implements AdminProfileService {
	
	@Autowired
	private MCodesDao mCodesDao;

	@Override
	public InitAdminProfileResponseDto getInit() {
		List<MCodes> listCountry = mCodesDao.selectByCodeType("0000000001");
		InitAdminProfileResponseDto result = new InitAdminProfileResponseDto();
		result.setListCountry(listCountry);
		return result;
	}

}
