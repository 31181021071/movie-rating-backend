package com.tanya.movie_rating.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import com.tanya.movie_rating.dto.adminprofile.DirectorSearchConditionDto;
import com.tanya.movie_rating.entity.MDirector;

@Dao
@ConfigAutowireable
public interface MDirectorDao {

	@Select
	MDirector selectById(int id);
	
	@Insert
	int insert(MDirector entity);

	@Update
	int update(MDirector entity);

	@Select
	List<MDirector> selectByCondition(DirectorSearchConditionDto condition, SelectOptions options);
	
	@Select
	int selectCountByCondition(DirectorSearchConditionDto condition);
	
	@Select
	List<MDirector> selectAll();
}
