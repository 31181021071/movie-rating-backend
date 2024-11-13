package com.tanya.movie_rating.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.tanya.movie_rating.entity.MMovie;
import com.tanya.movie_rating.entity.TMovieImg;

@Dao
@ConfigAutowireable
public interface TMovieImgDao {

	@Select
	TMovieImg selectById(int id);
	
	@Insert
	int insert(MMovie entity);

	@Update
	int update(MMovie entity);

	@Select
	List<TMovieImg> selectByMovieId(int movieId);
	
	@Select
	int selectCountByMovieId(int movieId);
}
