package com.tanya.movie_rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.movie_rating.dto.adminprofile.InitMovieManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.MovieDetailDto;
import com.tanya.movie_rating.service.adminprofile.AdminProfileService;

@RestController
@RequestMapping("/api/authen/admin-profile")
public class AdminProfileController {
	
	@Autowired
	private AdminProfileService adminProfileService;

	@GetMapping("/movie-detail/get-init")
	public ResponseEntity<?> getInitMovieDetail() {
		try {
			InitMovieManagementAdminProfileResponseDto result = adminProfileService.getInitMovieDetail();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@GetMapping("/movie-management/get-init")
	public ResponseEntity<?> getInitMovieManagement() {
		try {
			InitMovieManagementAdminProfileResponseDto result = adminProfileService.getInitMovieManagement();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/movie-detail/save")
	public ResponseEntity<?> save(@RequestBody MovieDetailDto dto) {
		try {
			int result = adminProfileService.save(dto);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/movie-detail/get-movie-detail/{movieId}")
	public ResponseEntity<?> getMovieDetail(@PathVariable int movieId) {
		try {
			MovieDetailDto result = adminProfileService.getMovieDetail(movieId);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
