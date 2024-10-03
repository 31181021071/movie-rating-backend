package com.tanya.movie_rating.service.jwt;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tanya.movie_rating.dao.MUserDao;
import com.tanya.movie_rating.entity.MUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private MUserDao mUserDao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		MUser user = mUserDao.selectByEmail(email);
		if (Objects.isNull(user)) {
			throw new  UsernameNotFoundException("User not found");
		}
		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}

}
