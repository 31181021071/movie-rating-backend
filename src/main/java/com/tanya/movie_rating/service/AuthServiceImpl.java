package com.tanya.movie_rating.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tanya.movie_rating.constant.CommonConstant;
import com.tanya.movie_rating.dao.MUserDao;
import com.tanya.movie_rating.dto.muser.MUserDto;
import com.tanya.movie_rating.dto.signup_user.SignupRequestDto;
import com.tanya.movie_rating.entity.MUser;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private MUserDao mUserDao;

	@Override
	public MUserDto createUser(SignupRequestDto signupRequestDto) {
		LocalDateTime now = LocalDateTime.now();
		MUser user = new MUser();
		user.setEmail(signupRequestDto.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDto.getPassword()));
		user.setIsEnabled(CommonConstant.IS_ENABLE);
		user.setName(signupRequestDto.getName());
		user.setRole(CommonConstant.ROLE_USER);
		user.setValidFlag(CommonConstant.VALID_FLAG);
		user.setCreatedAt(now);
		user.setCreatedBy(signupRequestDto.getEmail());
		user.setUpdatedAt(now);
		user.setUpdatedBy(signupRequestDto.getEmail());
		user.setVersion(CommonConstant.VERSION);
		
		int count = mUserDao.insert(user);
		
		if (count > 0) {
			MUserDto mUserDto = new MUserDto();
			mUserDto.setEmail(signupRequestDto.getEmail());
			mUserDto.setIsEnabled(CommonConstant.IS_ENABLE);
			mUserDto.setName(signupRequestDto.getName());
			mUserDto.setRole(CommonConstant.ROLE_USER);
			return mUserDto;
		}
		return null;
	}

}
