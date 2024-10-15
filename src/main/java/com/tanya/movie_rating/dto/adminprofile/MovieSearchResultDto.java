package com.tanya.movie_rating.dto.adminprofile;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSearchResultDto {

	private int totalRecord;
	
	private List<MovieSearchDetailDto> movieList;
}
