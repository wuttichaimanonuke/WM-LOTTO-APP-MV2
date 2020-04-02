package com.app.lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.lotto.entity.jwt.JwtRequest;
import com.app.lotto.entity.jwt.JwtResponse;
import com.app.lotto.entity.users.Users;
import com.app.lotto.jwtconfig.JwtTokenUtil;
import com.app.lotto.service.jwtservice.JwtUserDetailsService;
import com.app.lotto.service.users.IUsersService;
import com.app.lotto.util.ConstantsResult;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private IUsersService usersService;

	private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationController.class);
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		log.info("======Service: /authenticate work!!!======");
		log.info("======authenticationRequest username = {} / password = {}", authenticationRequest.getUsername(), authenticationRequest.getPassword());
		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		log.info("======00======");
		Users users = new Users();
		users = usersService.getUsersByUserName(authenticationRequest.getUsername());
		log.info("user.password = {}",users.getUPassword());
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> resultObject = new HashMap<String, Object>();
		UserDetails userDetails = null; 
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (encoder.matches(authenticationRequest.getPassword(), users.getUPassword())) {
			log.info("(SUCCESS)");
			result.put("resultCode", ConstantsResult.AUTHEN_SUCCESS_CODE);
			result.put("resultMessage", ConstantsResult.AUTHEN_SUCCESS_MSG);
			userDetails = new User(authenticationRequest.getUsername(), users.getUPassword(),new ArrayList<>());
			resultObject.put("token", jwtTokenUtil.generateToken(userDetails));
			result.put("resultObject", resultObject);
		} else {
			log.info("(FAIL)");
			result.put("resultCode", ConstantsResult.AUTHEN_FAILED_CODE);
			result.put("resultMessage", ConstantsResult.AUTHEN_FAILED_MSG);
			result.put("resultObject", null);
		}
//		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//		final String token = jwtTokenUtil.generateToken(userDetails);
//		return ResponseEntity.ok(new JwtResponse(token));
		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return false;
	}
	
	private void authenticate(String username, String password) throws Exception {
		log.info("======authenticate begin======");
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			log.info("======authenticate 111======");
		} catch (DisabledException e) {
			log.info("======authenticate 222======");
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			log.info("======authenticate 333======");
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		log.info("======authenticate end======");
	}

}
