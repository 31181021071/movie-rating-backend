package com.tanya.movie_rating.service.adminprofile;

import java.io.IOException;

import com.tanya.movie_rating.dto.adminprofile.InitMovieManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.MovieDetailDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchResultDto;

public interface AdminProfileService {

	InitMovieManagementAdminProfileResponseDto getInitMovieDetail();
	
	InitMovieManagementAdminProfileResponseDto getInitMovieManagement();
	
	MovieDetailDto getMovieDetail(int movieId);
	
	int save(MovieDetailDto dto) throws IOException;

	MovieSearchResultDto search(MovieSearchConditionDto dto);
}
