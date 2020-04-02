package com.app.lotto.repository.role;

import java.util.List;

import com.app.lotto.entity.role.Roles;

public interface IRolesDAO {
	List<Roles> getListRoleActiveByUsername (String username);
}
