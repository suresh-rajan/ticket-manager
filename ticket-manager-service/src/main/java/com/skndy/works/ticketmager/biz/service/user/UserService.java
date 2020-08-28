package com.skndy.works.ticketmager.biz.service.user;

import com.skndy.works.ticketmager.auth.model.AuthRequestEntity;
import com.skndy.works.ticketmanager.core.service.model.user.User;

public interface UserService {

	public User getById(String userId);
	
	public String add(AuthRequestEntity user);
}
