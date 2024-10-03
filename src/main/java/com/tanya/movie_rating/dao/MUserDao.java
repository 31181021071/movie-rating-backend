package com.tanya.movie_rating.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.tanya.movie_rating.entity.MUser;

@Dao
@ConfigAutowireable
public interface MUserDao {

	@Select
    MUser selectByEmail(String email); 
	
	@Insert
	int insert(MUser entity);
}
