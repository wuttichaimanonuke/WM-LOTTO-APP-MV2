package com.app.lotto.service.users;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lotto.entity.users.Users;
import com.app.lotto.repository.users.IUsersDAO;

@Service
public class UsersService implements IUsersService {

	private static final Logger log = LoggerFactory.getLogger(UsersService.class);
	
	@Autowired
	private IUsersDAO usersDAO;
	
	@Override
	public Users getUsersByUserName(@NotBlank String username) {
		log.info("(SERVICE) Service getUsersByUserName begin.");
		@NotNull Users users = new Users();
		users = usersDAO.getUserByUsername(username);
		log.info("(SERVICE) Service getUsersByUserName end.");
		return users;
	}

}
