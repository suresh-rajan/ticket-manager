package com.skndy.works.ticketmager.auth.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestEntity implements Serializable {

	private static final long serialVersionUID = -5032406266154830325L;

	private String userId;
	
	private String userName;
	
	private String password;
	

}
