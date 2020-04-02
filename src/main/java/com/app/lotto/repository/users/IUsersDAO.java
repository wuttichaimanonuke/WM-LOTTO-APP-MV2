package com.app.lotto.repository.users;

import com.app.lotto.entity.users.Users;

public interface IUsersDAO {
	Users getUserByUsername(String username);
}
