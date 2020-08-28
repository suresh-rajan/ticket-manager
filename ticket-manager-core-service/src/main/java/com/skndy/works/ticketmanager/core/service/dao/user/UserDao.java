package com.skndy.works.ticketmanager.core.service.dao.user;

import com.skndy.works.ticketmanager.core.service.model.user.User;

public interface UserDao {
	
	public User getUserById(String userId);
	
	public int addUser(User user);

}
