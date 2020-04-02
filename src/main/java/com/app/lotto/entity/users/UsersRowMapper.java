package com.app.lotto.entity.users;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users entity = new Users();
		entity.setUId(rs.getString("U_ID"));
		entity.setUUsername(rs.getString("U_USERNAME"));
		entity.setUPassword(rs.getString("U_PASSWORD"));
		entity.setUDisplayName(rs.getString("U_DISPLAYNAME"));
		entity.setUDiscription(rs.getString("U_DESCRIPTION"));
		entity.setUActive(rs.getString("U_ACTIVE"));
		entity.setModifyDate(rs.getDate("MODIFYDATE"));
		entity.setModifyBy(rs.getString("MODIFYBY"));
		entity.setCreateDatetime(rs.getDate("CREATEDATETIME"));
		entity.setCreateBy(rs.getString("CREATEBY"));
		return entity;
	}

}
