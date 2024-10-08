package com.tanya.movie_rating.dto.authentication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MUserDto {

	private String email;
	
	private String name;
	
	private String role;
	
	private boolean isEnable;
}
