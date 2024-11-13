package com.tanya.movie_rating.dto.moviedetailreview;

import java.util.List;

import com.tanya.movie_rating.dto.adminprofile.ActorDetailDto;
import com.tanya.movie_rating.dto.adminprofile.MovieDetailDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDetailReviewInitDto {

	private MovieDetailDto movieDetail;
	
	private List<MovieImgDto> listImg;
	
	private List<ActorDetailDto> listActor;
	
	private List<MovieReviewDto> listReview;
}
