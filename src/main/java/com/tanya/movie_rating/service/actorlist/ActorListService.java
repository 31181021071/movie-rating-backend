package com.tanya.movie_rating.service.actorlist;

import com.tanya.movie_rating.dto.actorlist.InitActorListResponseDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchResultDto;

public interface ActorListService {

	InitActorListResponseDto getInitActorList();

	ActorSearchResultDto searchActor(ActorSearchConditionDto dto);
}
