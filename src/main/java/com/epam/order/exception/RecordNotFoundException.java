package com.epam.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7223602686672728005L;

	public RecordNotFoundException(String exception) {
	        super(exception);
	    }
}
