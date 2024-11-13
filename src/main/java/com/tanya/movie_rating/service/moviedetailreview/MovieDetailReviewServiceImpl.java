package com.tanya.movie_rating.service.moviedetailreview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanya.movie_rating.dao.MActorDao;
import com.tanya.movie_rating.dao.MMovieDao;
import com.tanya.movie_rating.dao.MUserDao;
import com.tanya.movie_rating.dao.TMovieImgDao;
import com.tanya.movie_rating.dao.TMovieReviewDao;
import com.tanya.movie_rating.dto.adminprofile.ActorDetailDto;
import com.tanya.movie_rating.dto.adminprofile.MovieDetailDto;
import com.tanya.movie_rating.dto.moviedetailreview.MovieDetailReviewInitDto;
import com.tanya.movie_rating.dto.moviedetailreview.MovieImgDto;
import com.tanya.movie_rating.dto.moviedetailreview.MovieReviewDto;
import com.tanya.movie_rating.entity.MActor;
import com.tanya.movie_rating.entity.MMovie;
import com.tanya.movie_rating.entity.MUser;
import com.tanya.movie_rating.entity.TMovieImg;
import com.tanya.movie_rating.entity.TMovieReview;

import io.jsonwebtoken.lang.Arrays;

@Service
public class MovieDetailReviewServiceImpl implements MovieDetailReviewService {
	
	@Autowired
	private MMovieDao mMovieDao;
	@Autowired
	private TMovieImgDao tMovieImgDao;
	@Autowired
	private TMovieReviewDao tMovieReviewDao;
	@Autowired
	private MActorDao mActorDao;
	@Autowired
	private MUserDao mUserDao;
	

	@Override
	public MovieDetailReviewInitDto getInit(int movieId) {
		MovieDetailReviewInitDto result = new MovieDetailReviewInitDto();
		MMovie movieDetail = mMovieDao.selectById(movieId);
		List<String> directorList = Arrays.asList(movieDetail.getDirector().split(","));
		List<String> genreList = Arrays.asList(movieDetail.getGenre().split(","));
		String releaseDate = !Objects.isNull(movieDetail.getReleaseDate()) ? movieDetail.getReleaseDate().toString() : null;
		BigDecimal movieRating = tMovieReviewDao.selectRatingForMovieByMovieId(movieId);
		MovieDetailDto detailDto = new MovieDetailDto();
		detailDto.setId(movieId);
		detailDto.setCountry(movieDetail.getCountry());
		detailDto.setDescription(movieDetail.getDescription());
		detailDto.setDirector(directorList);
		detailDto.setGenre(genreList);
		detailDto.setMovieName(movieDetail.getMovieName());
		detailDto.setReleaseDate(releaseDate);
		detailDto.setRating(movieRating);
		detailDto.setImg(movieDetail.getImage());
		result.setMovieDetail(detailDto);
		
		List<TMovieImg> listImgEntity = tMovieImgDao.selectByMovieId(movieId);
		List<MovieImgDto> listImg = new ArrayList<MovieImgDto>();
		for (TMovieImg imgEntity: listImgEntity) {
			MovieImgDto imgDto = new MovieImgDto();
			imgDto.setId(imgEntity.getId());
			imgDto.setImg(imgEntity.getImgByte());
			imgDto.setImgName(imgEntity.getImgName());
			imgDto.setMovieId(imgEntity.getMovieId());
			listImg.add(imgDto);
		}
		result.setListImg(listImg);
		
		List<String> actorIdList = Arrays.asList(movieDetail.getActor().split(","));
		List<ActorDetailDto> listActor = new ArrayList<ActorDetailDto>();
		for (String actorId: actorIdList) {
			MActor actorEntity = mActorDao.selectById(Integer.parseInt(actorId));
			ActorDetailDto actorDto = new ActorDetailDto();
			actorDto.setId(actorEntity.getId());
			actorDto.setName(actorEntity.getName());
			actorDto.setImg(actorEntity.getImage());
			listActor.add(actorDto);
		}
		result.setListActor(listActor);
		
		SelectOptions options = SelectOptions.get().offset(0).limit(40);
		List<TMovieReview> reviewEntityList = tMovieReviewDao.selectByMovieId(movieId, options);
		List<MovieReviewDto> listReview = new ArrayList<MovieReviewDto>();
		for (TMovieReview reviewEntity: reviewEntityList) {
			MUser user = mUserDao.selectById(reviewEntity.getUserId());
			MovieReviewDto reviewDto = new MovieReviewDto();
			reviewDto.setId(reviewEntity.getId());
			reviewDto.setMovieId(movieId);
			reviewDto.setUserId(reviewEntity.getUserId());
			reviewDto.setRating(reviewEntity.getRating());
			reviewDto.setReview(reviewEntity.getReview());
			reviewDto.setUserName(user.getName());
			listReview.add(reviewDto);
		}
		result.setListReview(listReview);
		
		return result;
	}

}
