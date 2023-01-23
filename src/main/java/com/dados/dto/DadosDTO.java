package com.dados.dto;

import java.text.NumberFormat;

import org.hibernate.validator.constraints.br.CNPJ;

import com.dados.validation.MccConstraint;
import com.dados.validation.NaoVazio;
import com.dados.validation.NaoVazioFat;

public class DadosDTO {

	private Long id;
	@CNPJ
	private String cnpj;
	@NaoVazioFat
	private Float faturamento;

	private Float taxaDebito;

	private Float taxaCredito;

	private Float taxaParcelado;
	@NaoVazio
	private Boolean rr;
	@MccConstraint
	private Integer codigoMcc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Float getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(Float faturamento) {
		this.faturamento = faturamento;
	}

	public Float getTaxaDebito() {
		return taxaDebito;
	}

	public void setTaxaDebito(Float taxaDebito) {
		this.taxaDebito = taxaDebito;
	}

	public Float getTaxaCredito() {
		return taxaCredito;
	}

	public void setTaxaCredito(Float taxaCredito) {
		this.taxaCredito = taxaCredito;
	}

	public Float getTaxaParcelado() {
		return taxaParcelado;
	}

	public void setTaxaParcelado(Float taxaParcelado) {
		this.taxaParcelado = taxaParcelado;
	}

	public Boolean getRr() {
		return rr;
	}

	public void setRr(Boolean rr) {
		this.rr = rr;
	}

	public Integer getCodigoMcc() {
		return codigoMcc;
	}

	public void setCodigoMcc(Integer codigoMcc) {
		this.codigoMcc = codigoMcc;
	}

	@Override
	public String toString() {
		return "Dados [Id = " + id + ", cnpj=" + cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "."
				+ cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12) + ", faturamento="
				+ NumberFormat.getCurrencyInstance().format(faturamento) + ", taxaDebito=" + taxaDebito + "%"
				+ ", taxaCredito=" + taxaCredito + "%" + ", taxaParcelado=" + taxaParcelado + "%" + ", rr="
				+ rrIsTrue(rr) + ", numeroMcc=" + codigoMcc + "] \n";
	}

	public String rrIsTrue(Boolean rr) {
		if (rr == true) {
			return "Possui RR";
		} else
			return "Não possui RR";
	}

}
