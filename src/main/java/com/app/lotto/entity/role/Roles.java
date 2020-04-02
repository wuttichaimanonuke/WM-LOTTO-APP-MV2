package com.app.lotto.entity.role;

import java.util.Date;

import com.app.lotto.entity.users.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Roles {
	private Integer rId;
	private String rName;
	private String rDescription;
	private String rActive;
	private Date modifyDate;
	private String modifyBy;
	private Date createDatetime;
	private String createBy;
}
