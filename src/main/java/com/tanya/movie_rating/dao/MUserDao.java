package com.tanya.movie_rating.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

import com.tanya.movie_rating.entity.MUser;

@Dao
public interface MUserDao {

	@Select
    MUser selectByEmail(String email); 
	
	@Insert
	int insert(MUser entity);
}
