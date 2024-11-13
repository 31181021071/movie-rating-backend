package com.tanya.movie_rating.service.actorlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanya.movie_rating.constant.CommonConstant;
import com.tanya.movie_rating.dao.MActorDao;
import com.tanya.movie_rating.dao.MCodesDao;
import com.tanya.movie_rating.dto.actorlist.InitActorListResponseDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchDetailDto;
import com.tanya.movie_rating.dto.adminprofile.ActorSearchResultDto;
import com.tanya.movie_rating.entity.MActor;
import com.tanya.movie_rating.entity.MCodes;
import com.tanya.movie_rating.utils.CommonUtil;

@Service
@Transactional
public class ActorListServiceImpl implements ActorListService {
	
	@Autowired
	private MCodesDao mCodesDao;
	@Autowired
	private MActorDao mActorDao;

	@Override
	public InitActorListResponseDto getInitActorList() {
		List<MCodes> listCountry = mCodesDao.selectByCodeType(CommonConstant.M_CODES_COUNTRY);
		InitActorListResponseDto result = new InitActorListResponseDto();
		result.setListCountry(listCountry);
		return result;
	}

	@Override
	public ActorSearchResultDto searchActor(ActorSearchConditionDto dto) {
		SelectOptions options = SelectOptions.get().offset(dto.getOffset()).limit(dto.getLimit());
		List<MActor> listEntity = mActorDao.selectByCondition(dto, options);
		List<ActorSearchDetailDto> listSearch = new ArrayList<ActorSearchDetailDto>();
		for (MActor entity: listEntity) {
			MCodes countryCode = mCodesDao.selectByCodeTypeAndCode(CommonConstant.M_CODES_COUNTRY, entity.getCountry());
			String birth = !Objects.isNull(entity.getBirth()) ? CommonUtil.covnertLocalDateToString(entity.getBirth(), CommonConstant.LOCAL_DATE_STRING_FORMAT) : null;
			ActorSearchDetailDto detailDto = new ActorSearchDetailDto();
			detailDto.setId(entity.getId());
			detailDto.setCountry(countryCode.getCodeName());
			detailDto.setName(entity.getName());
			detailDto.setBirth(birth);
			detailDto.setImg(entity.getImage());
			listSearch.add(detailDto);
		}
		
		int totalRecord = mActorDao.selectCountByCondition(dto);
		ActorSearchResultDto result = new ActorSearchResultDto();
		result.setTotalRecord(totalRecord);
		result.setActorList(listSearch);
		return result;
	}
}
