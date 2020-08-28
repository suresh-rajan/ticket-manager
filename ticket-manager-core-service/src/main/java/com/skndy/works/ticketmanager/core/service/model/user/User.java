package com.skndy.works.ticketmanager.core.service.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_detail")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name ="user_id")
	private String userId;
	
	@Column(name ="user_name")
	private String userName;
	
	@Column(name ="password")
	private String password;
	
	@Column(name ="user_roll")
	private int roll;
	
	
	

}
