package com.dados.dto;

import java.text.NumberFormat;

public class ResponseDTO {
	private Long id;

	private String cnpj;

	private Float faturamento;

	private String taxaDebito;

	private String taxaCredito;

	private String taxaParcelado;

	private Boolean rr;

	private Integer codigoMcc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/"
				+ cnpj.substring(8, 12) + "-" + cnpj.substring(12);
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getFaturamento() {
		return NumberFormat.getCurrencyInstance().format(faturamento);
	}

	public void setFaturamento(Float faturamento) {
		this.faturamento = faturamento;
	}

	public String getTaxaDebito() {
		return taxaDebito + "%";
	}

	public void setTaxaDebito(String taxaDebito) {
		this.taxaDebito = taxaDebito;
	}

	public String getTaxaCredito() {
		return taxaCredito + "%";
	}

	public void setTaxaCredito(String taxaCredito) {
		this.taxaCredito = taxaCredito;
	}

	public String getTaxaParcelado() {
		return taxaParcelado + "%";
	}

	public void setTaxaParcelado(String taxaParcelado) {
		this.taxaParcelado = taxaParcelado;
	}

	public String getRr() {
		if (rr == true) {
			return "Possui RR";
		} else
			return "Não possui RR";

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
