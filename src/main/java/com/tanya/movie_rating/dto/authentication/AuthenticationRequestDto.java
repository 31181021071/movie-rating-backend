package com.tanya.movie_rating.dto.authentication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestDto {

	private String email;
	
	private String password;
}
