package com.cloudsrcsoft.reportes.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cloudsrcsoft.reportes.exception.BusinessException;
import com.cloudsrcsoft.reportes.exception.ErrorDetails;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<ErrorDetails> businessExceptionHandler(BusinessException ex,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
