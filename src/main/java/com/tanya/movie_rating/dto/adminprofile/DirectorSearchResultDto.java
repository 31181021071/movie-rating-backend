package com.tanya.movie_rating.dto.adminprofile;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectorSearchResultDto {

	private int totalRecord;
	
	private List<DirectorSearchDetailDto> directorList;
}
