package com.tanya.movie_rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.movie_rating.dto.adminprofile.MovieSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchResultDto;
import com.tanya.movie_rating.dto.movielist.InitMovieListResponseDto;
import com.tanya.movie_rating.service.movielist.MovieListService;

@RestController
@RequestMapping("/api/unauthen/movie-list")
public class MovieListController {
	
	@Autowired
	private MovieListService movieListService;

	
	@GetMapping("/get-init")
	public ResponseEntity<?> getInitMovieList() {
		try {
			InitMovieListResponseDto result = movieListService.getInitMovieList();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/search")
	public ResponseEntity<?> searchMovie(@RequestBody MovieSearchConditionDto dto) {
		try {
			MovieSearchResultDto result = movieListService.searchMovie(dto);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
