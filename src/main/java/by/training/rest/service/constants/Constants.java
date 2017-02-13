package by.training.rest.service.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hibernate.annotations.Immutable;

import by.training.rest.service.business.enums.Role;

public class Constants {
	
	public static final String DELIMITER = ";";
	public static final String COLON = ":";
	public static final String DOT = ".";
	public static final String DASH = " - ";
	
	public static final String EMPTY_NAME = "No name.";
	public static final String EMPTY_PHONE = "Add for contact.";
	public static final String EMPTY_FOTO = "http://funkyimg.com/i/2oqga.png";
	public static final Role DEFAULT_ROLE = Role.BUYER;
	
	
	public static final int EMPTY_SHOES_ID = 0;

	public static final String ERROR_JSON_IO = "{error: Get data from server error.}";
	public static final String ERROR_JSON_USER_NOT_FOUND = "{error: User not found.}";
	public static final String ERROR_JSON_REGISTER = "{error: Error registered.}";
	public static final String ERROR_JSON_REGISTER_LOGIN = "{error: Change other login.}";
	public static final String ERROR_JSON_GET_ALL = "{error: Data load error.}";
	public static final String OK_JSON_REGISTER = "{error: Ok register.}";
	
	public static final String SQL_GET_USER_BY_LOGIN = "FROM Users AS E WHERE E.id.login = :login_param";
	public static final String SQL_LOGIN_PARAM = "login_param";
	
	
	public static final String ERROR_USER_NOT_FOUND = " User not found.";
	public static final String ERROR_USER_LOGIN_BUSY = "User login busy.";
	
	public static final List<String> MANAGER_LOGINS = 
		    Collections.unmodifiableList(Arrays.asList("manager", "supervizer"));

}
