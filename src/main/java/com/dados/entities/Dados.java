package com.dados.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dados.validation.TaxaCredConstraint;
import com.dados.validation.TaxaDebConstraint;
import com.dados.validation.TaxaParcConstraint;

@TaxaCredConstraint
@TaxaParcConstraint
@TaxaDebConstraint
@Entity
public class Dados {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String cnpj;

	private Float faturamento;

	private Float taxaDebito;

	private Float taxaCredito;

	private Float taxaParcelado;

	private Boolean rr;

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
}
