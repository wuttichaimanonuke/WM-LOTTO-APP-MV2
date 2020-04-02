package com.app.lotto.repository.role;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.lotto.entity.role.Roles;
import com.app.lotto.entity.role.RolesRowMapper;

@Transactional
@Repository
@Component
@PropertySource("classpath:application.properties")
public class RolesDAO implements IRolesDAO {
	
	private static final Logger log = LoggerFactory.getLogger(RolesDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${database.schema}")
	private String ANALYZERLOTTERY;

	@Override
	public List<Roles> getListRoleActiveByUsername(@NotBlank String username) {
		StringBuilder strSql = new StringBuilder();
		strSql.append("SELECT r.* "
					+ "FROM "+ANALYZERLOTTERY+"ASSIGNROLESTOUSER a "
					+ "LEFT JOIN "+ANALYZERLOTTERY+"USERS u ON a.U_ID = u.U_ID "
					+ "LEFT JOIN "+ANALYZERLOTTERY+"ROLES r ON a.R_ID = r.R_ID "
					+ "WHERE u.U_USERNAME = ? AND a.ARU_ACTIVE = 'ACTIVE'");
		List<Roles> resultQuery = new ArrayList<Roles>();
		RowMapper<Roles> rowMapper = new RolesRowMapper();
		try {
			resultQuery = jdbcTemplate.query(strSql.toString(), rowMapper, username);
			log.info("(SUCCESS) Get all roles is active of user({}) from database success.", username);
		} catch (Exception e) {
			log.error("(Exception ERROR) Method getListRoleByUsername({}). : "+e, username);
		}
		return resultQuery;
	}

}
