package com.dados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Dados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	private String cnpj;
	
	@NotNull
	private Float faturamento;
	
	@NotNull
	private Float taxaDebito;
	
	@NotNull
	private Float taxaCredito;
	
	@NotNull
	private Boolean rr;
	

	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public @NotNull Float getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(Float faturamento) {
		this.faturamento = faturamento;
	}

	public @NotNull Float getTaxaDebito() {
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

	public Boolean getRr() {
		return rr;
	}

	public void setRr(Boolean rr) {
		this.rr = rr;
	}
	
	
	
	
}
