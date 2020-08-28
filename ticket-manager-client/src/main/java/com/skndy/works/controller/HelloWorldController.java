package com.skndy.works.controller;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skndy.works.ticketmanager.core.service.model.user.User;

@RestController
@RequestMapping("/helloworld")
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {
	
	@Autowired
	Session session;
	
	@GetMapping("/get")
	public User get() {
		
		User u = new User();
		u.setUserId("taki");
		u.setUserName("Taki Kun");
		u.setPassword("Mitshua4Taki");
		

		session.beginTransaction();
		
		session.save(u);		
		
		session.getTransaction().commit();
		return u;
	}

}
