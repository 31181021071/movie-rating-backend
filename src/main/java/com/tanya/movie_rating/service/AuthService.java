package com.tanya.movie_rating.service;

import com.tanya.movie_rating.dto.authentication.MUserDto;
import com.tanya.movie_rating.dto.signup_user.SignupRequestDto;
import com.tanya.movie_rating.dto.signup_user.SignupResponseDto;

public interface AuthService {
	
	boolean checkEmailExist(SignupRequestDto signupRequestDto);

	SignupResponseDto createUser(SignupRequestDto signupRequestDto);
	
	MUserDto getUserInfo(String email);

}
