package com.tanya.movie_rating.dto.adminprofile;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSearchConditionDto {

	private String movieName;
	private String releaseDateFrom;
	private String releaseDateTo;
	private List<String> country;
	private List<String> genre;
	private List<String> director;
	private List<String> actor;
	private List<String> isShow;
	private BigDecimal ratingFrom;
	private BigDecimal ratingTo;
	private int offset;
	private int limit;
	
}
