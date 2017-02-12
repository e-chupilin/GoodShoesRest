package by.training.rest.service.constants;

public class Constants {
	
	public static final String DELIMITER = ";";
	public static final String COLON = ":";
	public static final String DOT = ".";
	public static final String DASH = " - ";
	
	public static final String EMPTY_LOGIN = "";
	public static final String EMPTY_EMAIL = "";
	public static final String EMPTY_PASSWORD = "";
	
	
	public static final int EMPTY_SHOES_ID = 0;

	public static final String ERROR_JSON_IO = "{error: Get data from server error.}";
	public static final String ERROR_JSON_USER_NOT_FOUND = "{error: User not found.}";
	
	public static final String SQL_GET_USER_BY_LOGIN = "FROM Users AS E WHERE E.id.login = :login_param";
	public static final String SQL_LOGIN_PARAM = "login_param";
	
	
	public static final String ERROR_USER_NOT_FOUND = " User not found.";
	public static final String ERROR_USER_LOGIN_BUSY = "User login busy.";

}
