package com.tanya.movie_rating.dto.adminprofile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorSearchDetailDto {

	private int id;
	
	private String name;
	
	private String country;
	
	private String birth;
	
	private byte[] img;
}
