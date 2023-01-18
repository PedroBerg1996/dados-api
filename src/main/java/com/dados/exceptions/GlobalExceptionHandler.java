package com.dados.exceptions;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	public ErrorMessage  methodArgumentNotValidException() {
		ErrorMessage message = new ErrorMessage(
				new Date(),
				HttpStatus.FORBIDDEN.value(),
				HttpStatus.FORBIDDEN.getReasonPhrase(),
				"CNPJ inválido",
				"/dados");
		return message;
		
	}
		

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage  nullPointerException() {
		ErrorMessage message = new ErrorMessage(
				new Date(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				"Os campos não podem estar vazios",
				"/dados");
		return message;	
		
	}
	
}
	
	



	

	


