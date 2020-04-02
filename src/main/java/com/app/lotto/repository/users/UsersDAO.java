package com.app.lotto.repository.users;

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

import com.app.lotto.entity.users.Users;
import com.app.lotto.entity.users.UsersRowMapper;

import lombok.NonNull;

@Transactional
@Repository
@Component
@PropertySource("classpath:application.properties")
public class UsersDAO implements IUsersDAO {

	private static final Logger log = LoggerFactory.getLogger(UsersDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${database.schema}")
	private String ANALYZERLOTTERY;
	
	@Override
	public @NonNull Users getUserByUsername(@NotBlank String username) {
		StringBuilder strSql = new StringBuilder();
		strSql.append("SELECT u.* FROM "+ANALYZERLOTTERY+"USERS u WHERE u.U_USERNAME = ? AND u.U_ACTIVE = 'ACTIVE' AND ROWNUM=1");
		Users resultQuery = new Users();
		try {
			RowMapper<Users> rowMapper = new UsersRowMapper();
			resultQuery = (Users) jdbcTemplate.queryForObject(strSql.toString(), rowMapper, username);
			log.debug("Get Users By username({}).",resultQuery.getUUsername());
		} catch (Exception e) {
			log.error("(Exception ERROR) Method getUserByUsername({}) : "+e, resultQuery.getUUsername());
		}
		return resultQuery;
	}

}
