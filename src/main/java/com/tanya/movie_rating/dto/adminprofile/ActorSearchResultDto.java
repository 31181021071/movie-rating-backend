package com.tanya.movie_rating.dto.adminprofile;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorSearchResultDto {

	private int totalRecord;
	
	private List<ActorSearchDetailDto> actorList;
}
