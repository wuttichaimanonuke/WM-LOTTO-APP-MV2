package com.app.lotto.entity.role;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class RolesRowMapper implements RowMapper<Roles> {

	@Override
	public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
		Roles entity = new Roles();
		entity.setRId(rs.getInt("R_ID"));
		entity.setRName(rs.getString("R_NAME"));
		entity.setRDescription(rs.getString("R_DESCRIPTION"));
		entity.setRActive(rs.getString("R_ACTIVE"));
		entity.setModifyDate(rs.getDate("MODIFYDATE"));
		entity.setModifyBy(rs.getString("MODIFYBY"));
		entity.setCreateDatetime(rs.getDate("CREATEDATETIME"));
		entity.setCreateBy(rs.getString("CREATEBY"));
		return entity;
	}

}
