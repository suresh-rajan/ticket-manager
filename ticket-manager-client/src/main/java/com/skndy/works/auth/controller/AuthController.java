package com.skndy.works.auth.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skndy.works.auth.utill.JwtTokenUtil;
import com.skndy.works.ticketmager.auth.model.AuthRequestEntity;
import com.skndy.works.ticketmager.auth.model.AuthResponseEntity;
import com.skndy.works.ticketmager.biz.service.user.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService authDetailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequestEntity authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUserId(), authenticationRequest.getPassword());

		final UserDetails userDetails = authDetailService.loadUserByUsername(authenticationRequest.getUserId());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthResponseEntity(token));
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody AuthRequestEntity authenticationRequest) {
		
		if(Objects.nonNull(userService.getById(authenticationRequest.getUserId()))) {
			return ResponseEntity.ok(new AuthRequestEntity("", "",""));
		}
		
		String password = passwordEncoder.encode(authenticationRequest.getPassword());
		authenticationRequest.setPassword(password);
		
		userService.add(authenticationRequest);

		return ResponseEntity.ok(new AuthRequestEntity(authenticationRequest.getUserId(), "",""));

	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
