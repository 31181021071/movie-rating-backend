package com.tanya.movie_rating.service.movielist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanya.movie_rating.constant.CommonConstant;
import com.tanya.movie_rating.dao.MCodesDao;
import com.tanya.movie_rating.dao.MMovieDao;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchDetailDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchResultDto;
import com.tanya.movie_rating.dto.movielist.InitMovieListResponseDto;
import com.tanya.movie_rating.entity.MCodes;
import com.tanya.movie_rating.entity.MMovie;
import com.tanya.movie_rating.utils.CommonUtil;

import io.jsonwebtoken.lang.Arrays;

@Service
@Transactional
public class MovieListServiceImpl implements MovieListService {
	
	@Autowired
	private MCodesDao mCodesDao;
	@Autowired
	private MMovieDao mMovieDao;
	
	@Override
	public InitMovieListResponseDto getInitMovieList() {
		List<MCodes> listCountry = mCodesDao.selectByCodeType(CommonConstant.M_CODES_COUNTRY);
		List<MCodes> listGenre = mCodesDao.selectByCodeType(CommonConstant.M_CODES_GENRE);
		InitMovieListResponseDto result = new InitMovieListResponseDto();
		result.setListCountry(listCountry);
		result.setListGenre(listGenre);
		return result;
	}

	@Override
	public MovieSearchResultDto searchMovie(MovieSearchConditionDto dto) {
		SelectOptions options = SelectOptions.get().offset(dto.getOffset()).limit(dto.getLimit());
		List<MMovie> listEntity = mMovieDao.selectByCondition(dto, options);
		List<MovieSearchDetailDto> listSearch = new ArrayList<MovieSearchDetailDto>();
		for (MMovie entity: listEntity) {
			MCodes countryCode = mCodesDao.selectByCodeTypeAndCode(CommonConstant.M_CODES_COUNTRY, entity.getCountry());
			List<String> genreList = Arrays.asList(entity.getGenre().split(","));
			List<String> genreStringList = new ArrayList<String>();
			for(String genre: genreList) {
				MCodes genreCode = mCodesDao.selectByCodeTypeAndCode(CommonConstant.M_CODES_GENRE, genre);
				genreStringList.add(genreCode.getCodeName());
			}
			String genre = String.join(",", genreStringList);
			String releaseDate = !Objects.isNull(entity.getReleaseDate()) ? CommonUtil.covnertLocalDateToString(entity.getReleaseDate(), CommonConstant.LOCAL_DATE_STRING_FORMAT) : null;
			MovieSearchDetailDto detailDto = new MovieSearchDetailDto();
			detailDto.setId(entity.getId());
			detailDto.setCountry(countryCode.getCodeName());
			detailDto.setGenre(genre);
			detailDto.setIsShow(entity.getIsShow());
			detailDto.setMovieName(entity.getMovieName());
			detailDto.setRating(entity.getRating());
			detailDto.setReleaseDate(releaseDate);
			detailDto.setImg(entity.getImage());
			listSearch.add(detailDto);
		}
		
		int totalRecord = mMovieDao.selectCountByCondition(dto);
		MovieSearchResultDto result = new MovieSearchResultDto();
		result.setTotalRecord(totalRecord);
		result.setMovieList(listSearch);
		return result;
	}
}
