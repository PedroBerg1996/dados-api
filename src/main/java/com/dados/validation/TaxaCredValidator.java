package com.dados.validation;

import java.text.DecimalFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.dados.dto.DadosDTO;

public class TaxaCredValidator implements ConstraintValidator<TaxaCredConstraint, DadosDTO> {

	@Override
	public boolean isValid(DadosDTO dados, ConstraintValidatorContext context) {
		if (dados.getTaxaCredito() < calcTaxaCredMin(dados) || dados.getTaxaCredito() > calcTaxaCredMax(dados)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "As taxas credito devem estar entre "
					+ df.format(calcTaxaCredMin(dados)) + "% e " + df.format(calcTaxaCredMax(dados)) + "%");

		}
		return true;
	}

	Float taxaCredMin = 1.5F;
	Float taxaCredMax = 6.5F;

	private static final DecimalFormat df = new DecimalFormat("0.00");

	public Float taxaMinAdicional(DadosDTO dados) {
		Float multiplicador = (dados.getFaturamento() / 5000);
		Float adicionalTaxaMin = (float) (Math.floor(multiplicador) * 0.2F);
		return adicionalTaxaMin;
	}

	public Float taxaMaxAdicional(DadosDTO dados) {
		Float multiplicador = (dados.getFaturamento() / 5000);
		Float adicionalTaxaMax = (float) (Math.floor(multiplicador) * 0.1F);
		return adicionalTaxaMax;

	}

	public Float calcTaxaCredMin(DadosDTO dados) {
		if (dados.getFaturamento() <= 5000) {
			return taxaCredMin;

		} else
			return taxaCredMin + taxaMinAdicional(dados);

	}

	public Float calcTaxaCredMax(DadosDTO dados) {
		if (dados.getFaturamento() <= 5000) {
			return taxaCredMax;
		} else
			return taxaCredMax + taxaMaxAdicional(dados);
	}

}
