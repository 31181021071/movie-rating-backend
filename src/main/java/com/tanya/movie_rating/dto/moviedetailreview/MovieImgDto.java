package com.tanya.movie_rating.dto.moviedetailreview;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieImgDto {

	private int id;
	
	private int movieId;
	
	private String imgName;
	
	private byte[] img;
}
