package com.tanya.movie_rating.dto.signup_user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {
	
    private Integer id;

    private String name;

    private String email;

    private String role;

    private Boolean isEnabled;
}
