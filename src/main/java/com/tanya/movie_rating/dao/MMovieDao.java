package com.tanya.movie_rating.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.tanya.movie_rating.entity.MMovie;

@Dao
@ConfigAutowireable
public interface MMovieDao {

	@Select
	MMovie selectById(int id);
	
	@Insert
	int insert(MMovie entity);
}
