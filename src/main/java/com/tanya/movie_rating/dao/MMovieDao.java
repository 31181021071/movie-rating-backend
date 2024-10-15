package com.tanya.movie_rating.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import com.tanya.movie_rating.dto.adminprofile.MovieSearchConditionDto;
import com.tanya.movie_rating.entity.MMovie;

@Dao
@ConfigAutowireable
public interface MMovieDao {

	@Select
	MMovie selectById(int id);
	
	@Insert
	int insert(MMovie entity);

	@Update
	int update(MMovie entity);

	@Select
	List<MMovie> selectByCondition(MovieSearchConditionDto condition, SelectOptions options);
	
	@Select
	int selectCountByCondition(MovieSearchConditionDto condition);
}
