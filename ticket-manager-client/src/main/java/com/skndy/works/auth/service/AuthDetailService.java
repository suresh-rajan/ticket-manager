package com.skndy.works.auth.service;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.skndy.works.ticketmager.biz.service.user.UserService;
import com.skndy.works.ticketmanager.core.service.model.user.User;

@Service
public class AuthDetailService implements UserDetailsService {

	@Autowired
	UserService service;

	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = service.getById(userId);

		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException("User not found with id: " + userId);
		}
			
		return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(),
				new ArrayList<>());
	}

}
