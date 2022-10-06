package com.dev.models;

import java.math.BigDecimal;

public class Seguro {

	private String cobertura;
	private BigDecimal valorFranquia;

	public Seguro(String cobertura, BigDecimal valorFranquia) {
		super();
		this.cobertura = cobertura;
		this.valorFranquia = valorFranquia;
	}

	public Seguro() {
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public BigDecimal getValorFranquia() {
		return valorFranquia;
	}

	public void setValorFranquia(BigDecimal valorFranquia) {
		this.valorFranquia = valorFranquia;
	}

	@Override
	public String toString() {
		return "Seguro{" +
				"cobertura='" + cobertura + '\'' +
				", valorFranquia=" + valorFranquia +
				'}';
	}
}
