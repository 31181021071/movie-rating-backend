package com.tanya.movie_rating.service.adminprofile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import com.tanya.movie_rating.dto.adminprofile.InitMovieManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.MovieDetailDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchDetailDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchResultDto;
import com.tanya.movie_rating.entity.MCodes;
import com.tanya.movie_rating.entity.MMovie;
import com.tanya.movie_rating.utils.CommonUtil;

import io.jsonwebtoken.lang.Arrays;

@Service
@Transactional
public class AdminProfileServiceImpl implements AdminProfileService {
	
	@Autowired
	private MCodesDao mCodesDao;
	@Autowired
	private MMovieDao mMovieDao;

	@Override
	public InitMovieManagementAdminProfileResponseDto getInitMovieDetail() {
		List<MCodes> listCountry = mCodesDao.selectByCodeType(CommonConstant.M_CODES_COUNTRY);
		List<MCodes> listGenre = mCodesDao.selectByCodeType(CommonConstant.M_CODES_GENRE);
		InitMovieManagementAdminProfileResponseDto result = new InitMovieManagementAdminProfileResponseDto();
		result.setListCountry(listCountry);
		result.setListGenre(listGenre);
		return result;
	}
	
	@Override
	public InitMovieManagementAdminProfileResponseDto getInitMovieManagement() {
		List<MCodes> listCountry = mCodesDao.selectByCodeType(CommonConstant.M_CODES_COUNTRY);
		List<MCodes> listGenre = mCodesDao.selectByCodeType(CommonConstant.M_CODES_GENRE);
		InitMovieManagementAdminProfileResponseDto result = new InitMovieManagementAdminProfileResponseDto();
		result.setListCountry(listCountry);
		result.setListGenre(listGenre);
		return result;
	}

	@Override
	public MovieDetailDto getMovieDetail(int movieId) {
		MMovie movieEntity = mMovieDao.selectById(movieId);
		List<String> genreList = Arrays.asList(movieEntity.getGenre().split(","));
		MovieDetailDto dto = new MovieDetailDto();
		dto.setId(movieEntity.getId());
		dto.setCountry(movieEntity.getCountry());
		dto.setDescription(movieEntity.getDescription());
		dto.setGenre(genreList);
		dto.setImg(movieEntity.getImage());
		dto.setIsShow(movieEntity.getIsShow());
		dto.setMovieName(movieEntity.getMovieName());
		dto.setRating(movieEntity.getRating());
		dto.setReleaseDate(movieEntity.getReleaseDate().toString());
		return dto;
	}

	@Override
	public int save(MovieDetailDto dto) throws IOException {
		LocalDateTime now = LocalDateTime.now();
		String genre = String.join(",", dto.getGenre());
		LocalDate releaseDate = CommonUtil.convertStringToLocalDate(dto.getReleaseDate(), CommonConstant.LOCAL_DATE_FORMAT);
		MMovie entity = new MMovie();
		if (0 != dto.getId()) {
			entity = mMovieDao.selectById(dto.getId());
		}
		BigDecimal rating = Objects.isNull(dto.getRating()) ? BigDecimal.ZERO : dto.getRating();
		entity.setCountry(dto.getCountry());
		entity.setDescription(dto.getDescription());
		entity.setGenre(genre);
		entity.setImage(dto.getImg());
		entity.setIsShow(dto.getIsShow());
		entity.setMovieName(dto.getMovieName());
		entity.setRating(rating);
		entity.setReleaseDate(releaseDate);
		
		entity.setUpdatedAt(now);
		entity.setUpdatedBy(CommonConstant.ADMIN);
		entity.setValidFlag(CommonConstant.VALID_FLAG);
		
		if (0 != dto.getId()) {
			mMovieDao.update(entity);
		} else {
			entity.setCreatedAt(now);
			entity.setCreatedBy(CommonConstant.ADMIN);
			entity.setVersion(CommonConstant.VERSION);
			mMovieDao.insert(entity);
		}
		return 1;
	}

	@Override
	public MovieSearchResultDto search(MovieSearchConditionDto dto) {
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
			String releaseDate = CommonUtil.covnertLocalDateToString(entity.getReleaseDate(), CommonConstant.LOCAL_DATE_STRING_FORMAT);
			MovieSearchDetailDto detailDto = new MovieSearchDetailDto();
			detailDto.setId(entity.getId());
			detailDto.setCountry(countryCode.getCodeName());
			detailDto.setGenre(genre);
			detailDto.setIsShow(entity.getIsShow());
			detailDto.setMovieName(entity.getMovieName());
			detailDto.setRating(entity.getRating());
			detailDto.setReleaseDate(releaseDate);
			listSearch.add(detailDto);
		}
		
		int totalRecord = mMovieDao.selectCountByCondition(dto);
		MovieSearchResultDto result = new MovieSearchResultDto();
		result.setTotalRecord(totalRecord);
		result.setMovieList(listSearch);
		return result;
	}
}
