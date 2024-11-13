package com.tanya.movie_rating.dao;

import java.math.BigDecimal;
import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import com.tanya.movie_rating.entity.MMovie;
import com.tanya.movie_rating.entity.TMovieReview;

@Dao
@ConfigAutowireable
public interface TMovieReviewDao {

	@Select
	TMovieReview selectById(int id);
	
	@Insert
	int insert(MMovie entity);

	@Update
	int update(MMovie entity);

	@Select
	List<TMovieReview> selectByMovieId(int movieId, SelectOptions options);
	
	@Select
	int selectCountByMovieId(int movieId);
	
	@Select
	BigDecimal selectRatingForMovieByMovieId(int movieId);
}
