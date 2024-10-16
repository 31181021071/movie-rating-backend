package com.tanya.movie_rating.service.adminprofile;

import java.io.IOException;

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

public interface AdminProfileService {

	// Movie
	InitMovieManagementAdminProfileResponseDto getInitMovieDetail();
	
	InitMovieManagementAdminProfileResponseDto getInitMovieManagement();
	
	MovieDetailDto getMovieDetail(int movieId);
	
	int saveMovieDetail(MovieDetailDto dto) throws IOException;

	MovieSearchResultDto searchMovie(MovieSearchConditionDto dto);
	
	
	// Director
	InitDirectorManagementAdminProfileResponseDto getInitDirectorDetail();

	InitDirectorManagementAdminProfileResponseDto getInitDirectorManagement();

	int saveDirectorDetail(DirectorDetailDto dto);

	DirectorDetailDto getDirectorDetail(int movieId);

	DirectorSearchResultDto searchDirector(DirectorSearchConditionDto dto);
	
	// Actor
	InitActorManagementAdminProfileResponseDto getInitActorDetail();

	InitActorManagementAdminProfileResponseDto getInitActorManagement();

	int saveActorDetail(ActorDetailDto dto);

	ActorDetailDto getActorDetail(int movieId);

	ActorSearchResultDto searchActor(ActorSearchConditionDto dto);
}
