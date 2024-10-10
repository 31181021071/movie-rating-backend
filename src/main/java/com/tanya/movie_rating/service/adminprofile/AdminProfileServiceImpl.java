package com.tanya.movie_rating.service.adminprofile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanya.movie_rating.constant.CommonConstant;
import com.tanya.movie_rating.dao.MCodesDao;
import com.tanya.movie_rating.dao.MMovieDao;
import com.tanya.movie_rating.dto.adminprofile.InitMovieManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.MovieDetailDto;
import com.tanya.movie_rating.entity.MCodes;
import com.tanya.movie_rating.entity.MMovie;

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
		String isShow = movieEntity.getIsShow() == true ? "1" : "2";
		MovieDetailDto dto = new MovieDetailDto();
		dto.setId(movieEntity.getId());
		dto.setCountry(movieEntity.getCountry());
		dto.setDescription(movieEntity.getDescription());
		dto.setGenre(genreList);
		dto.setImg(movieEntity.getImage());
		dto.setIsShow(isShow);
		dto.setMovieName(movieEntity.getMovieName());
		dto.setRating(movieEntity.getRating());
		dto.setReleaseYear(movieEntity.getReleaseYear());
		return dto;
	}

	@Override
	public int save(MovieDetailDto dto) throws IOException {
		LocalDateTime now = LocalDateTime.now();
		String genre = String.join(",", dto.getGenre());
		boolean isShow = "1".equalsIgnoreCase(dto.getIsShow()) ? true : false;
		MMovie entity = new MMovie();
		if (0 != dto.getId()) {
			entity = mMovieDao.selectById(dto.getId());
		}
		entity.setCountry(dto.getCountry());
		entity.setDescription(dto.getDescription());
		entity.setGenre(genre);
		entity.setImage(dto.getImg());
		entity.setIsShow(isShow);
		entity.setMovieName(dto.getMovieName());
		entity.setRating(dto.getRating());
		entity.setReleaseYear(dto.getReleaseYear());
		
		entity.setCreatedAt(now);
		entity.setCreatedBy(CommonConstant.ADMIN);
		entity.setUpdatedAt(now);
		entity.setUpdatedBy(CommonConstant.ADMIN);
		entity.setValidFlag(CommonConstant.VALID_FLAG);
		entity.setVersion(CommonConstant.VERSION);
		
		mMovieDao.insert(entity);
		return 1;
	}
}
