package com.dados.validation;

import java.util.ArrayList;
import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MccValidator implements ConstraintValidator<MccConstraint, Integer> {

	@Override
	public boolean isValid(Integer CodigoMcc, ConstraintValidatorContext context) {
		if (blacklist.contains(CodigoMcc) || CodigoMcc == null) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "MCC inválido");
		} else
			return true;
	}

	ArrayList<Integer> blacklist = new ArrayList<>(Arrays.asList(1731, 3219, 3246, 3357, 3388, 3441, 3505, 3520, 3579,
			3640, 3771, 4131, 4215, 4468, 5046, 5072, 5139, 5169, 5231, 5261, 5541, 5571, 5651, 5655, 5697, 5699, 5713,
			5732, 5733, 5931, 5943, 5967, 5971, 5973, 5993, 5994, 5995, 5998, 7217, 7276, 7297, 7299));

}
