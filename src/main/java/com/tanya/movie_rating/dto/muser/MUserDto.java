package com.tanya.movie_rating.dto.muser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MUserDto {

    private Integer id;

    private String name;

    private String email;

    private String role;

    private Boolean isEnabled;
}
