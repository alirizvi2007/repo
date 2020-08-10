package com.epam.order.exception;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class ErrorResponse {
	public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
 
    @Getter
    @Setter
    private String message;
 
    @Getter
    @Setter
    private List<String> details;

}
