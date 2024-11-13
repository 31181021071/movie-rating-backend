package com.tanya.movie_rating.dto.actorlist;

import java.util.List;

import com.tanya.movie_rating.entity.MCodes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitActorListResponseDto {

	private List<MCodes> listCountry;
}
