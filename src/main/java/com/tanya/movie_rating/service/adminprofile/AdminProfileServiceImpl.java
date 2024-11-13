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
import org.springframework.util.StringUtils;

import com.tanya.movie_rating.constant.CommonConstant;
import com.tanya.movie_rating.dao.MActorDao;
import com.tanya.movie_rating.dao.MCodesDao;
import com.tanya.movie_rating.dao.MDirectorDao;
import com.tanya.movie_rating.dao.MMovieDao;
import com.tanya.movie_rating.dto.adminprofile.ActorDetailDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchDetailDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchResultDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorDetailDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorSearchDetailDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorSearchResultDto;
import com.tanya.movie_rating.dto.adminprofile.InitActorManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.InitDirectorManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.InitMovieManagementAdminProfileResponseDto;
import com.tanya.movie_rating.dto.adminprofile.MovieDetailDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchDetailDto;
import com.tanya.movie_rating.dto.adminprofile.MovieSearchResultDto;
import com.tanya.movie_rating.entity.MActor;
import com.tanya.movie_rating.entity.MCodes;
import com.tanya.movie_rating.entity.MDirector;
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
	@Autowired
	private MDirectorDao mDirectorDao;
	@Autowired
	private MActorDao mActorDao;

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
		List<String> directorList = Arrays.asList(movieEntity.getDirector().split(","));
		List<String> actorList = Arrays.asList(movieEntity.getActor().split(","));
		String releaseDate = !Objects.isNull(movieEntity.getReleaseDate()) ? movieEntity.getReleaseDate().toString() : null;
		MovieDetailDto dto = new MovieDetailDto();
		dto.setId(movieEntity.getId());
		dto.setCountry(movieEntity.getCountry());
		dto.setDescription(movieEntity.getDescription());
		dto.setGenre(genreList);
		dto.setActor(actorList);
		dto.setDirector(directorList);
		dto.setImg(movieEntity.getImage());
		dto.setIsShow(movieEntity.getIsShow());
		dto.setMovieName(movieEntity.getMovieName());
		dto.setRating(movieEntity.getRating());
		dto.setReleaseDate(releaseDate);
		return dto;
	}

	@Override
	public int saveMovieDetail(MovieDetailDto dto) throws IOException {
		LocalDateTime now = LocalDateTime.now();
		String genre = String.join(",", dto.getGenre());
		String director = String.join(",", dto.getDirector());
		String actor = String.join(",", dto.getActor());
		LocalDate releaseDate = StringUtils.hasText(dto.getReleaseDate()) ? CommonUtil.convertStringToLocalDate(dto.getReleaseDate(), CommonConstant.LOCAL_DATE_FORMAT) : null;
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
		entity.setDirector(director);
		entity.setActor(actor);
		
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
			listSearch.add(detailDto);
		}
		
		int totalRecord = mMovieDao.selectCountByCondition(dto);
		MovieSearchResultDto result = new MovieSearchResultDto();
		result.setTotalRecord(totalRecord);
		result.setMovieList(listSearch);
		return result;
	}

	@Override
	public InitDirectorManagementAdminProfileResponseDto getInitDirectorDetail() {
		List<MCodes> listCountry = mCodesDao.selectByCodeType(CommonConstant.M_CODES_COUNTRY);
		InitDirectorManagementAdminProfileResponseDto result = new InitDirectorManagementAdminProfileResponseDto();
		result.setListCountry(listCountry);
		return result;
	}

	@Override
	public InitDirectorManagementAdminProfileResponseDto getInitDirectorManagement() {
		List<MCodes> listCountry = mCodesDao.selectByCodeType(CommonConstant.M_CODES_COUNTRY);
		InitDirectorManagementAdminProfileResponseDto result = new InitDirectorManagementAdminProfileResponseDto();
		result.setListCountry(listCountry);
		return result;
	}

	@Override
	public int saveDirectorDetail(DirectorDetailDto dto) {
		LocalDateTime now = LocalDateTime.now();
		LocalDate birth = StringUtils.hasText(dto.getBirth()) ? CommonUtil.convertStringToLocalDate(dto.getBirth(), CommonConstant.LOCAL_DATE_FORMAT) : null;
		MDirector entity = new MDirector();
		if (0 != dto.getId()) {
			entity = mDirectorDao.selectById(dto.getId());
		}
		entity.setCountry(dto.getCountry());
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setImage(dto.getImg());
		entity.setBirth(birth);
		
		entity.setUpdatedAt(now);
		entity.setUpdatedBy(CommonConstant.ADMIN);
		entity.setValidFlag(CommonConstant.VALID_FLAG);
		
		if (0 != dto.getId()) {
			mDirectorDao.update(entity);
		} else {
			entity.setCreatedAt(now);
			entity.setCreatedBy(CommonConstant.ADMIN);
			entity.setVersion(CommonConstant.VERSION);
			mDirectorDao.insert(entity);
		}
		return 1;
	}

	@Override
	public DirectorDetailDto getDirectorDetail(int movieId) {
		MDirector entity = mDirectorDao.selectById(movieId);
		String birth = !Objects.isNull(entity.getBirth()) ? entity.getBirth().toString() : null;
		DirectorDetailDto dto = new DirectorDetailDto();
		dto.setId(entity.getId());
		dto.setCountry(entity.getCountry());
		dto.setDescription(entity.getDescription());
		dto.setImg(entity.getImage());
		dto.setName(entity.getName());
		dto.setBirth(birth);
		return dto;
	}

	@Override
	public DirectorSearchResultDto searchDirector(DirectorSearchConditionDto dto) {
		SelectOptions options = SelectOptions.get().offset(dto.getOffset()).limit(dto.getLimit());
		List<MDirector> listEntity = mDirectorDao.selectByCondition(dto, options);
		List<DirectorSearchDetailDto> listSearch = new ArrayList<DirectorSearchDetailDto>();
		for (MDirector entity: listEntity) {
			MCodes countryCode = mCodesDao.selectByCodeTypeAndCode(CommonConstant.M_CODES_COUNTRY, entity.getCountry());
			String birth = !Objects.isNull(entity.getBirth()) ? CommonUtil.covnertLocalDateToString(entity.getBirth(), CommonConstant.LOCAL_DATE_STRING_FORMAT) : null;
			DirectorSearchDetailDto detailDto = new DirectorSearchDetailDto();
			detailDto.setId(entity.getId());
			detailDto.setCountry(countryCode.getCodeName());
			detailDto.setName(entity.getName());
			detailDto.setBirth(birth);
			listSearch.add(detailDto);
		}
		
		int totalRecord = mDirectorDao.selectCountByCondition(dto);
		DirectorSearchResultDto result = new DirectorSearchResultDto();
		result.setTotalRecord(totalRecord);
		result.setDirectorList(listSearch);
		return result;
	}

	@Override
	public InitActorManagementAdminProfileResponseDto getInitActorDetail() {
		List<MCodes> listCountry = mCodesDao.selectByCodeType(CommonConstant.M_CODES_COUNTRY);
		InitActorManagementAdminProfileResponseDto result = new InitActorManagementAdminProfileResponseDto();
		result.setListCountry(listCountry);
		return result;
	}

	@Override
	public InitActorManagementAdminProfileResponseDto getInitActorManagement() {
		List<MCodes> listCountry = mCodesDao.selectByCodeType(CommonConstant.M_CODES_COUNTRY);
		InitActorManagementAdminProfileResponseDto result = new InitActorManagementAdminProfileResponseDto();
		result.setListCountry(listCountry);
		return result;
	}

	@Override
	public int saveActorDetail(ActorDetailDto dto) {
		LocalDateTime now = LocalDateTime.now();
		LocalDate birth = StringUtils.hasText(dto.getBirth()) ? CommonUtil.convertStringToLocalDate(dto.getBirth(), CommonConstant.LOCAL_DATE_FORMAT) : null;
		MActor entity = new MActor();
		if (0 != dto.getId()) {
			entity = mActorDao.selectById(dto.getId());
		}
		entity.setCountry(dto.getCountry());
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setImage(dto.getImg());
		entity.setBirth(birth);
		
		entity.setUpdatedAt(now);
		entity.setUpdatedBy(CommonConstant.ADMIN);
		entity.setValidFlag(CommonConstant.VALID_FLAG);
		
		if (0 != dto.getId()) {
			mActorDao.update(entity);
		} else {
			entity.setCreatedAt(now);
			entity.setCreatedBy(CommonConstant.ADMIN);
			entity.setVersion(CommonConstant.VERSION);
			mActorDao.insert(entity);
		}
		return 1;
	}

	@Override
	public ActorDetailDto getActorDetail(int movieId) {
		MActor entity = mActorDao.selectById(movieId);
		String birth = !Objects.isNull(entity.getBirth()) ? entity.getBirth().toString() : null;
		ActorDetailDto dto = new ActorDetailDto();
		dto.setId(entity.getId());
		dto.setCountry(entity.getCountry());
		dto.setDescription(entity.getDescription());
		dto.setImg(entity.getImage());
		dto.setName(entity.getName());
		dto.setBirth(birth);
		return dto;
	}

	@Override
	public ActorSearchResultDto searchActor(ActorSearchConditionDto dto) {
		SelectOptions options = SelectOptions.get().offset(dto.getOffset()).limit(dto.getLimit());
		List<MActor> listEntity = mActorDao.selectByCondition(dto, options);
		List<ActorSearchDetailDto> listSearch = new ArrayList<ActorSearchDetailDto>();
		for (MActor entity: listEntity) {
			MCodes countryCode = mCodesDao.selectByCodeTypeAndCode(CommonConstant.M_CODES_COUNTRY, entity.getCountry());
			String birth = !Objects.isNull(entity.getBirth()) ? CommonUtil.covnertLocalDateToString(entity.getBirth(), CommonConstant.LOCAL_DATE_STRING_FORMAT) : null;
			ActorSearchDetailDto detailDto = new ActorSearchDetailDto();
			detailDto.setId(entity.getId());
			detailDto.setCountry(countryCode.getCodeName());
			detailDto.setName(entity.getName());
			detailDto.setBirth(birth);
			listSearch.add(detailDto);
		}
		
		int totalRecord = mActorDao.selectCountByCondition(dto);
		ActorSearchResultDto result = new ActorSearchResultDto();
		result.setTotalRecord(totalRecord);
		result.setActorList(listSearch);
		return result;
	}
}
