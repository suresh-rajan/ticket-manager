package com.skndy.works.ticketmager.biz.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skndy.works.ticketmager.auth.model.AuthRequestEntity;
import com.skndy.works.ticketmanager.core.service.dao.user.UserDao;
import com.skndy.works.ticketmanager.core.service.model.user.User;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	public User getById(String userId) {
		return dao.getUserById(userId);
	}

	public String add(AuthRequestEntity userRequest) {
		
		User user = new User();
		
		user.setUserId(userRequest.getUserId());
		user.setUserName(userRequest.getUserName());
		user.setPassword(userRequest.getPassword());
		
		dao.addUser(user);
		return user.getUserId();
	}

}
