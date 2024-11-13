package com.tanya.movie_rating.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import com.tanya.movie_rating.dto.adminprofile.ActorSearchConditionDto;
import com.tanya.movie_rating.entity.MActor;

@Dao
@ConfigAutowireable
public interface MActorDao {

	@Select
	MActor selectById(int id);
	
	@Insert
	int insert(MActor entity);

	@Update
	int update(MActor entity);

	@Select
	List<MActor> selectByCondition(ActorSearchConditionDto condition, SelectOptions options);
	
	@Select
	int selectCountByCondition(ActorSearchConditionDto condition);
	
	@Select
	List<MActor> selectAll();
}
