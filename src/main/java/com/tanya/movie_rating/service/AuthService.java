package com.tanya.movie_rating.service;

import com.tanya.movie_rating.dto.signup_user.SignupRequestDto;
import com.tanya.movie_rating.dto.signup_user.SignupResponseDto;

public interface AuthService {

	SignupResponseDto createUser(SignupRequestDto signupRequestDto);

}
