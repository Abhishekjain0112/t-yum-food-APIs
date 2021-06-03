package com.cognizant.truyum.api.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.truyum.api.exception.ErrorResponse;
import com.cognizant.truyum.api.exception.MenuItemNotFound;

@RestControllerAdvice
public class MenuItemExceptionHandlear {

	
	
	
	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler({MenuItemNotFound.class})
	public ErrorResponse handleExceptionMenuItemNotFound(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
	}
	
	
	
}
