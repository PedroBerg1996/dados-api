package com.dados.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;




public class NaoVazioValidator implements ConstraintValidator<NaoVazio, Boolean> {

	@Override
	public boolean isValid(Boolean dados, ConstraintValidatorContext context) {
		if (dados != null) {
		return true;
	}else throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "O campo RR não pode estar vazio");

	}
}
