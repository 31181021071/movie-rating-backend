package com.tanya.movie_rating.dto.adminprofile;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorSearchConditionDto {

	private String name;
	private String birthFrom;
	private String birthTo;
	private List<String> country;
	private int offset;
	private int limit;
	
}
