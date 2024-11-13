package com.tanya.movie_rating.dto.adminprofile;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSearchDetailDto {

	private int id;
	
	private String movieName;
	
	private String country;
	
	private String releaseDate;
	
	private String genre;
	
	private BigDecimal rating;
	
	private String isShow;
	
	private byte[] img;
}
