package com.tanya.movie_rating.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.tanya.movie_rating.entity.MCodes;

@Dao
@ConfigAutowireable
public interface MCodesDao {

	@Select
	List<MCodes> selectByCodeType(String codeType);
}
