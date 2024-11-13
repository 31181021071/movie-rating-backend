package com.tanya.movie_rating.dto.movielist;

import java.util.List;

import com.tanya.movie_rating.entity.MCodes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitMovieListResponseDto {

	private List<MCodes> listCountry;
	
	private List<MCodes> listGenre;
}
