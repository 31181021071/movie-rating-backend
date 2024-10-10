package com.tanya.movie_rating.dto.adminprofile;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDetailDto {

	private int id;
	
	private String movieName;
	
	private String country;
	
	private int releaseYear;
	
	private List<String> genre;
	
	private double rating;
	
	private String isShow;
	
	private String description;
	
	private byte[] img;
	
}