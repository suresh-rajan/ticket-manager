package com.skndy.works.ticketmager.auth.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseEntity implements Serializable {
	
	private static final long serialVersionUID = -6071994754201242656L;
	
	private String token;
}
