package com.tanya.movie_rating.service.adminprofile;

import java.io.IOException;

import com.tanya.movie_rating.dto.adminprofile.InitMovieManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.MovieDetailDto;

public interface AdminProfileService {

	InitMovieManagementAdminProfileResponseDto getInitMovieDetail();
	
	InitMovieManagementAdminProfileResponseDto getInitMovieManagement();
	
	MovieDetailDto getMovieDetail(int movieId);
	
	int save(MovieDetailDto dto) throws IOException;
}
