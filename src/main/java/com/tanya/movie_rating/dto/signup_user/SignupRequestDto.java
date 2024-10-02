package com.tanya.movie_rating.dto.signup_user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {

    private String name;

    private String email;

    private String password;
}
