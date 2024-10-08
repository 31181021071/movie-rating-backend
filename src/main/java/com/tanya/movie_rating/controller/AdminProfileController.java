package com.tanya.movie_rating.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.movie_rating.dto.adminprofile.InitAdminProfileResponseDto;

@RestController
@RequestMapping("/api/authen/admin-profile")
public class AdminProfileController {

	@GetMapping("/init")
	public InitAdminProfileResponseDto getInit() {
		return null;
		
	}
}
