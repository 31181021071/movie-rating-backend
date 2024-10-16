package com.tanya.movie_rating.dto.adminprofile;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDetailDto {

	private int id;
	
	private String movieName;
	
	private String country;
	
	private String releaseDate;
	
	private List<String> genre;
	
	private List<String> director;
	
	private List<String> actor;
	
	private BigDecimal rating;
	
	private String isShow;
	
	private String description;
	
	private byte[] img;
	
}
