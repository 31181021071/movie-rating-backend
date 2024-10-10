package com.tanya.movie_rating.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanya.movie_rating.constant.CommonConstant;
import com.tanya.movie_rating.dao.MUserDao;
import com.tanya.movie_rating.dto.authentication.MUserDto;
import com.tanya.movie_rating.dto.signup_user.SignupRequestDto;
import com.tanya.movie_rating.dto.signup_user.SignupResponseDto;
import com.tanya.movie_rating.entity.MUser;

@Service
@Transactional
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private MUserDao mUserDao;
	

	@Override
	public boolean checkEmailExist(SignupRequestDto signupRequestDto) {
		MUser existUser = mUserDao.selectByEmail(signupRequestDto.getEmail());
		if (!Objects.isNull(existUser)) {
			return true;
		}
		return false;
	}

	@Override
	public SignupResponseDto createUser(SignupRequestDto signupRequestDto) {
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
			SignupResponseDto result = new SignupResponseDto();
			result.setEmail(signupRequestDto.getEmail());
			result.setIsEnabled(CommonConstant.IS_ENABLE);
			result.setName(signupRequestDto.getName());
			result.setRole(CommonConstant.ROLE_USER);
			return result;
		}
		return null;
	}

	@Override
	public MUserDto getUserInfo(String email) {
		MUser existUser = mUserDao.selectByEmail(email);
		MUserDto userInfo = new MUserDto();
		userInfo.setEmail(existUser.getEmail());
		userInfo.setEnable(existUser.getIsEnabled());
		userInfo.setName(existUser.getName());
		userInfo.setRole(existUser.getRole());
		return userInfo;
	}

}
