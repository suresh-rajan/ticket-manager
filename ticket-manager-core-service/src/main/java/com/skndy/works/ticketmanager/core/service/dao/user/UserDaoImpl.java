package com.skndy.works.ticketmanager.core.service.dao.user;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skndy.works.ticketmanager.core.service.model.user.User;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	Session session;
	
	public User getUserById(String userId) {
		
		session.beginTransaction();

		Query<User> query = session.createQuery("from User where userId= :userId", User.class);
		query.setParameter("userId", userId);
		
		session.getTransaction().commit();
		return query.uniqueResult();		
	}

	public int addUser(User user) {
		session.beginTransaction();
		int id = (Integer) session.save(user);
		session.getTransaction().commit();
		return id;
	}

}
