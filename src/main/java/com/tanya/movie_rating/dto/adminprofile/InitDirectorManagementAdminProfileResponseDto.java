package com.tanya.movie_rating.dto.adminprofile;

import java.util.List;

import com.tanya.movie_rating.entity.MCodes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitDirectorManagementAdminProfileResponseDto {

	private List<MCodes> listCountry;
}
