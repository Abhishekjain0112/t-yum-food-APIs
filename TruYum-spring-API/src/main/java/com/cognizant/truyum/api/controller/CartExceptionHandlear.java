package com.cognizant.truyum.api.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.truyum.api.exception.CartEmptyException;
import com.cognizant.truyum.api.exception.CartNotFound;
import com.cognizant.truyum.api.exception.ErrorResponse;
import com.cognizant.truyum.api.exception.MenuItemNotFound;

@RestControllerAdvice
public class CartExceptionHandlear {

	
	
	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler({CartNotFound.class})
	public ErrorResponse handleExceptionCartNotFound(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	
	
	@ExceptionHandler({CartEmptyException.class})
	public ErrorResponse handleExceptionCartEmptyException(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),ex.getMessage(), request.getRequestURI());
	}	
	
	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler({MenuItemNotFound.class})
	public ErrorResponse handleExceptionMenuItemFound(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
	}
		
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class })
	public ErrorResponse handleExceptionValidation(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), "Please check the Validation", request.getRequestURI());
	}	

	@ExceptionHandler({Exception.class})
	public ErrorResponse handleExceptionGlobal(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), "Global Exception", request.getRequestURI());
	}		

	
	
}
