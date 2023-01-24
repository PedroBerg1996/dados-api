package com.dados.validation;

import java.text.DecimalFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.dados.entities.Dados;

public class TaxaParcValidatorE implements ConstraintValidator<TaxaParcConstraint, Dados> {

	@Override
	public boolean isValid(Dados dados, ConstraintValidatorContext context) {
		if (dados.getTaxaParcelado() < calcTaxaParcMin(dados) || dados.getTaxaParcelado() > calcTaxaParcMax(dados)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "As taxas parcelado devem estar entre "
					+ df.format(calcTaxaParcMin(dados)) + "% e " + df.format(calcTaxaParcMax(dados)) + "%");
		}
		return true;
	}

	private static final DecimalFormat df = new DecimalFormat("0.00");

	Float taxaParcMin = 2.0F;
	Float taxaParcMax = 12.0F;

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

	public Float calcTaxaParcMin(Dados dados) {
		if (dados.getFaturamento() <= 5000) {
			return taxaParcMin;

		} else
			return taxaParcMin + taxaMinAdicional(dados);

	}

	public Float calcTaxaParcMax(Dados dados) {
		if (dados.getFaturamento() <= 5000) {
			return taxaParcMax;
		} else
			return taxaParcMax + taxaMaxAdicional(dados);
	}
}
