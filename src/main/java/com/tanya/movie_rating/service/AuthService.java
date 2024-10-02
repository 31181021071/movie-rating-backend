package com.tanya.movie_rating.service;

import com.tanya.movie_rating.dto.muser.MUserDto;
import com.tanya.movie_rating.dto.signup_user.SignupRequestDto;

public interface AuthService {

	MUserDto createUser(SignupRequestDto signupRequestDto);

}
