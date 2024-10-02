package com.tanya.movie_rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.movie_rating.dto.muser.MUserDto;
import com.tanya.movie_rating.dto.signup_user.SignupRequestDto;
import com.tanya.movie_rating.service.AuthService;

@RestController
public class SignupUserController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody SignupRequestDto signupRequestDto) {
		MUserDto createdUser = authService.createUser(signupRequestDto);
		if (createdUser == null) {
			return new ResponseEntity<>("User is not created, try again later", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

}
