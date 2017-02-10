package by.training.rest.service.business.exceptions;

import java.util.Arrays;

public class GoodShoesUserException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public GoodShoesUserException() {
		super();
	}

	public GoodShoesUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public GoodShoesUserException(String message) {
		super(message);
	}

	public GoodShoesUserException(Throwable cause) {
		super(cause);
	}

}
