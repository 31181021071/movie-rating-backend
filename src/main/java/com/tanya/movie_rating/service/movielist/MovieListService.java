package com.tanya.movie_rating.service.movielist;

import com.tanya.movie_rating.dto.adminprofile.MovieSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchResultDto;
import com.tanya.movie_rating.dto.movielist.InitMovieListResponseDto;

public interface MovieListService {
	
	InitMovieListResponseDto getInitMovieList();

	MovieSearchResultDto searchMovie(MovieSearchConditionDto dto);
}
