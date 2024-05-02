package com.masai.user.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<MyErrors> notFoundException(UserNotFoundException be, WebRequest webReq) {

		MyErrors red = new MyErrors();
		red.setTimeStamp(LocalDateTime.now());
		red.setMsg(be.getMessage());
		red.setDetails(webReq.getDescription(false));

		return new ResponseEntity<MyErrors>(red, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrors> userException(UserException be, WebRequest webReq) {

		MyErrors red = new MyErrors();
		red.setTimeStamp(LocalDateTime.now());
		red.setMsg(be.getMessage());
		red.setDetails(webReq.getDescription(false));

		return new ResponseEntity<MyErrors>(red, HttpStatus.BAD_REQUEST);
	}

}
