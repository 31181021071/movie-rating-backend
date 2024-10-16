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

import com.tanya.movie_rating.dto.adminprofile.ActorDetailDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchResultDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorDetailDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorSearchResultDto;
import com.tanya.movie_rating.dto.adminprofile.InitActorManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.InitDirectorManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.InitMovieManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.MovieDetailDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchResultDto;
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
	public ResponseEntity<?> saveMovieDetail(@RequestBody MovieDetailDto dto) {
		try {
			int result = adminProfileService.saveMovieDetail(dto);
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
	
	@PostMapping("/movie-management/search")
	public ResponseEntity<?> searchMovie(@RequestBody MovieSearchConditionDto dto) {
		try {
			MovieSearchResultDto result = adminProfileService.searchMovie(dto);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/director-detail/get-init")
	public ResponseEntity<?> getInitDirectorDetail() {
		try {
			InitDirectorManagementAdminProfileResponseDto result = adminProfileService.getInitDirectorDetail();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@GetMapping("/director-management/get-init")
	public ResponseEntity<?> getInitDirectorManagement() {
		try {
			InitDirectorManagementAdminProfileResponseDto result = adminProfileService.getInitDirectorManagement();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/director-detail/save")
	public ResponseEntity<?> saveDirectorDetail(@RequestBody DirectorDetailDto dto) {
		try {
			int result = adminProfileService.saveDirectorDetail(dto);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/director-detail/get-director-detail/{movieId}")
	public ResponseEntity<?> getDirectorDetail(@PathVariable int movieId) {
		try {
			DirectorDetailDto result = adminProfileService.getDirectorDetail(movieId);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/director-management/search")
	public ResponseEntity<?> searchDirector(@RequestBody DirectorSearchConditionDto dto) {
		try {
			DirectorSearchResultDto result = adminProfileService.searchDirector(dto);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/actor-detail/get-init")
	public ResponseEntity<?> getInitActorDetail() {
		try {
			InitActorManagementAdminProfileResponseDto result = adminProfileService.getInitActorDetail();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@GetMapping("/actor-management/get-init")
	public ResponseEntity<?> getInitActorManagement() {
		try {
			InitActorManagementAdminProfileResponseDto result = adminProfileService.getInitActorManagement();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/actor-detail/save")
	public ResponseEntity<?> saveActorDetail(@RequestBody ActorDetailDto dto) {
		try {
			int result = adminProfileService.saveActorDetail(dto);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/actor-detail/get-actor-detail/{movieId}")
	public ResponseEntity<?> getActorDetail(@PathVariable int movieId) {
		try {
			ActorDetailDto result = adminProfileService.getActorDetail(movieId);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/actor-management/search")
	public ResponseEntity<?> searchActor(@RequestBody ActorSearchConditionDto dto) {
		try {
			ActorSearchResultDto result = adminProfileService.searchActor(dto);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
