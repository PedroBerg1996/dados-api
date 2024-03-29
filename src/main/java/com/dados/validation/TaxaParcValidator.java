package com.dados.validation;

import java.text.DecimalFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.dados.dto.DadosDTO;

public class TaxaParcValidator implements ConstraintValidator<TaxaParcConstraint, DadosDTO> {

	@Override
	public boolean isValid(DadosDTO dados, ConstraintValidatorContext context) {
		if (dados.getTaxaParcelado() < calcTaxaParcMin(dados) || dados.getTaxaParcelado() > calcTaxaParcMax(dados)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "As taxas parcelado devem estar entre "
					+ df.format(calcTaxaParcMin(dados)) + "% e " + df.format(calcTaxaParcMax(dados)) + "%");
		}
		return true;
	}

	private static final DecimalFormat df = new DecimalFormat("0.00");

	Float taxaParcMin = 2.0F;
	Float taxaParcMax = 12.0F;

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

	public Float calcTaxaParcMin(DadosDTO dados) {
		if (dados.getFaturamento() <= 5000) {
			return taxaParcMin;

		} else
			return taxaParcMin + taxaMinAdicional(dados);

	}

	public Float calcTaxaParcMax(DadosDTO dados) {
		if (dados.getFaturamento() <= 5000) {
			return taxaParcMax;
		} else
			return taxaParcMax + taxaMaxAdicional(dados);
	}
}
