package com.te.cms.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.cms.response.ErrorResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse>employeeNotFoundException(StudentNotFountException s){
		
		return ResponseEntity.<ErrorResponse>ofNullable(ErrorResponse.builder()
				.message(s.getMessage())
				.httpStatus(HttpStatus.NOT_FOUND).dateTime(LocalDateTime.now()).build());
		
	}

}
