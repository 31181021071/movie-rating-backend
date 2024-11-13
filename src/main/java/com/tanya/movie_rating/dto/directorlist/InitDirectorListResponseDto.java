package com.tanya.movie_rating.dto.directorlist;

import java.util.List;

import com.tanya.movie_rating.entity.MCodes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitDirectorListResponseDto {

	private List<MCodes> listCountry;
}
