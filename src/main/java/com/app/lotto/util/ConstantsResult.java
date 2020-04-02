package com.app.lotto.util;

public final class ConstantsResult {
	/*Begin authenticate*/
	public static final String AUTHEN_SUCCESS_CODE = "00100";
	public static final String AUTHEN_SUCCESS_MSG = "Authenticate success.";
	public static final String AUTHEN_FAILED_CODE = "00400";
	public static final String AUTHEN_FAILED_MSG = "Authenticate failed.";
	/*End authenticate*/
	
	public static final String LOGIN_NOT_FOUND_CODE = "LOGI404";
	public static final String LOGIN_NOT_FOUND_MSG = "User not found.";
	public static final String LOGIN_INPUT_INVALID_CODE = "LOGI400";
	public static final String LOGIN_INPUT_INVALID_MSG = "Input data invalid.";
	
	public static final String LOGOUT_SUCCESS_CODE = "LOGO200";
	public static final String LOGOUT_SUCCESS_MSG = "Logout success.";
	public static final String LOGOUT_FAILED_CODE = "LOGO204";
	public static final String LOGOUT_FAILED_MSG = "Logout failed.";
	
	public static final String CHECK_TOKEN_IS_EXPIRE_OK_CODE = "CTIE200";
	public static final String CHECK_TOKEN_IS_EXPIRE_OK__MSG = "This token is ok.";
	public static final String CHECK_TOKEN_IS_EXPIRE_FAIL_CODE = "CTIE204";
	public static final String CHECK_TOKEN_IS_EXPIRE_FAIL_MSG = "This token is failed.";
	
	/*
	 * RoundConfigureService
	 */
	public static final String GET_CURRENT_ACTIVE_ROUNDCONFIG_OK_CODE = "GCAR200";
	public static final String GET_CURRENT_ACTIVE_ROUNDCONFIG_OK__MSG = "Ok, Cant get currect active round configuration.";
	public static final String GET_CURRENT_ACTIVE_ROUNDCONFIG_FAIL_CODE = "GUAR204";
	public static final String GET_CURRENT_ACTIVE_ROUNDCONFIG_FAIL_MSG = "Failed, Can't get currect active round configuration.";
	public static final String GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_CODE = "GUAR209";
	public static final String GET_CURRENT_ACTIVE_ROUNDCONFIG_DATAERROR_MSG = "Error, Data error.";
}