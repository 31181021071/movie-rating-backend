package com.tanya.movie_rating.service.directorlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanya.movie_rating.constant.CommonConstant;
import com.tanya.movie_rating.dao.MCodesDao;
import com.tanya.movie_rating.dao.MDirectorDao;
import com.tanya.movie_rating.dto.adminprofile.DirectorSearchConditionDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorSearchDetailDto;
import com.tanya.movie_rating.dto.adminprofile.DirectorSearchResultDto;
import com.tanya.movie_rating.dto.directorlist.InitDirectorListResponseDto;
import com.tanya.movie_rating.entity.MCodes;
import com.tanya.movie_rating.entity.MDirector;
import com.tanya.movie_rating.utils.CommonUtil;

@Service
@Transactional
public class DirectorListServiceImpl implements DirectorListService {
	
	@Autowired
	private MCodesDao mCodesDao;
	@Autowired
	private MDirectorDao mDirectorDao;

	@Override
	public InitDirectorListResponseDto getInitDirectorList() {
		List<MCodes> listCountry = mCodesDao.selectByCodeType(CommonConstant.M_CODES_COUNTRY);
		InitDirectorListResponseDto result = new InitDirectorListResponseDto();
		result.setListCountry(listCountry);
		return result;
	}

	@Override
	public DirectorSearchResultDto searchDirector(DirectorSearchConditionDto dto) {
		SelectOptions options = SelectOptions.get().offset(dto.getOffset()).limit(dto.getLimit());
		List<MDirector> listEntity = mDirectorDao.selectByCondition(dto, options);
		List<DirectorSearchDetailDto> listSearch = new ArrayList<DirectorSearchDetailDto>();
		for (MDirector entity: listEntity) {
			MCodes countryCode = mCodesDao.selectByCodeTypeAndCode(CommonConstant.M_CODES_COUNTRY, entity.getCountry());
			String birth = !Objects.isNull(entity.getBirth()) ? CommonUtil.covnertLocalDateToString(entity.getBirth(), CommonConstant.LOCAL_DATE_STRING_FORMAT) : null;
			DirectorSearchDetailDto detailDto = new DirectorSearchDetailDto();
			detailDto.setId(entity.getId());
			detailDto.setCountry(countryCode.getCodeName());
			detailDto.setName(entity.getName());
			detailDto.setBirth(birth);
			detailDto.setImg(entity.getImage());
			listSearch.add(detailDto);
		}
		
		int totalRecord = mDirectorDao.selectCountByCondition(dto);
		DirectorSearchResultDto result = new DirectorSearchResultDto();
		result.setTotalRecord(totalRecord);
		result.setDirectorList(listSearch);
		return result;
	}
}
