package com.app.lotto.entity.users;

import java.util.Date;

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
public class Users {
	
	private String uId;
	private String uUsername;
	private String uPassword;
	private String uDisplayName;
	private String uDiscription;
	private String uActive;
	private Date modifyDate;
	private String modifyBy;
	private Date createDatetime;
	private String createBy;

}
