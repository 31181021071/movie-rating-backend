package com.tanya.movie_rating.service.moviedetailreview;

import com.tanya.movie_rating.dto.moviedetailreview.MovieDetailReviewInitDto;

public interface MovieDetailReviewService {

	MovieDetailReviewInitDto getInit(int movieId);
}
