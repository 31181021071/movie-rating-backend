package com.tanya.movie_rating.dto.moviedetailreview;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieReviewDto {

	private int id;
	
	private int movieId;
	
	private int userId;
	
	private String userName;
	
	private String review;
	
	private BigDecimal rating;
}
