package com.app.lotto.service.users;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.lotto.entity.users.Users;

public interface IUsersService {
	@NotNull Users getUsersByUserName(@NotBlank String username );
}
