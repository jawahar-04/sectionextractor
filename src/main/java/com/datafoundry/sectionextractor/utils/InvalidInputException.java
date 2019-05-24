package com.datafoundry.sectionextractor.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InvalidInputException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2677658941931063024L;

	public InvalidInputException() {
        super();
    }

    public InvalidInputException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(final String message) {
        super(message);
    }

    public InvalidInputException(final Throwable cause) {
        super(cause);
    }
}
