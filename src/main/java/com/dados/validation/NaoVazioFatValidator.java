package com.dados.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NaoVazioFatValidator implements ConstraintValidator<NaoVazioFat, Float> {

	

	@Override
	public boolean isValid(Float dados, ConstraintValidatorContext context) {
		if (dados != null) {
			return true;
		}else throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "O campo faturamento não pode estar vazio");

		}
}
