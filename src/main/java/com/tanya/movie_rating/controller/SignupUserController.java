package com.tanya.movie_rating.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.movie_rating.dto.signup_user.SignupRequestDto;
import com.tanya.movie_rating.dto.signup_user.SignupResponseDto;
import com.tanya.movie_rating.service.AuthService;

@RestController
public class SignupUserController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody SignupRequestDto signupRequestDto) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isExistEmail = authService.checkEmailExist(signupRequestDto);
		if (isExistEmail) {
			result.put("fail", "This email already been used. Please use a different email.");
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		SignupResponseDto createdUser = authService.createUser(signupRequestDto);
		if (createdUser == null) {
			result.put("fail", "User is not created, try again later.");
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(createdUser, HttpStatus.OK);
	}

}
