package com.tanya.movie_rating.service.directorlist;

import com.tanya.movie_rating.dto.adminprofile.DirectorSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorSearchResultDto;
import com.tanya.movie_rating.dto.directorlist.InitDirectorListResponseDto;

public interface DirectorListService {

	InitDirectorListResponseDto getInitDirectorList();

	DirectorSearchResultDto searchDirector(DirectorSearchConditionDto dto);
}
