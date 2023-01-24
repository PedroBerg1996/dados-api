package com.dados.validation;

import java.text.DecimalFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.dados.entities.Dados;

public class TaxaDebValidatorE implements ConstraintValidator<TaxaDebConstraint, Dados> {

	@Override
	public boolean isValid(Dados dados, ConstraintValidatorContext context) {
		if (dados.getTaxaDebito() < calcTaxaDebMin(dados) || dados.getTaxaDebito() > calcTaxaDebMax(dados)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "As taxas debito devem estar entre "
					+ df.format(calcTaxaDebMin(dados)) + "% e " + df.format(calcTaxaDebMax(dados)) + "%");
		}
		return true;
	}

	Float taxaDebMin = 1.0F;
	Float taxaDebMax = 7.0F;

	private static final DecimalFormat df = new DecimalFormat("0.00");

	public Float taxaMinAdicional(Dados dados) {
		Float multiplicador = (dados.getFaturamento() / 5000);
		Float adicionalTaxaMin = (float) (Math.floor(multiplicador) * 0.2F);
		return adicionalTaxaMin;
	}

	public Float taxaMaxAdicional(Dados dados) {
		Float multiplicador = (dados.getFaturamento() / 5000);
		Float adicionalTaxaMax = (float) (Math.floor(multiplicador) * 0.1F);
		return adicionalTaxaMax;

	}

	public Float calcTaxaDebMin(Dados dados) {
		if (dados.getFaturamento() <= 5000) {
			return taxaDebMin;

		} else
			return taxaDebMin + taxaMinAdicional(dados);

	}

	public Float calcTaxaDebMax(Dados dados) {
		if (dados.getFaturamento() <= 5000) {
			return taxaDebMax;
		} else
			return taxaDebMax + taxaMaxAdicional(dados);
	}

}
