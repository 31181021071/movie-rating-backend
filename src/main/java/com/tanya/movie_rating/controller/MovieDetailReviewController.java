package com.tanya.movie_rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanya.movie_rating.dto.moviedetailreview.MovieDetailReviewInitDto;
import com.tanya.movie_rating.service.moviedetailreview.MovieDetailReviewService;

@RestController
@RequestMapping("/api/unauthen/movie-detail-review")
public class MovieDetailReviewController {
	
	@Autowired
	private MovieDetailReviewService movieDetailReviewService;

	@GetMapping("/get-init/{movieId}")
	public MovieDetailReviewInitDto getInit(@PathVariable int movieId) {
		MovieDetailReviewInitDto result = movieDetailReviewService.getInit(movieId);
		return result;
	}
}
