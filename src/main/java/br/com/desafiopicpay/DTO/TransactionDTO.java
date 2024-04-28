package br.com.desafiopicpay.DTO;

import java.math.BigDecimal;

public class TransactionDTO {
	
	private BigDecimal valor;
	
	private Long remetenteId;
	
	private Long destinatarioId;

	public TransactionDTO(BigDecimal valor, Long remetenteId, Long destinatarioId) {
		super();
		this.valor = valor;
		this.remetenteId = remetenteId;
		this.destinatarioId = destinatarioId;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getRemetenteId() {
		return remetenteId;
	}

	public void setRemetenteId(Long remetenteId) {
		this.remetenteId = remetenteId;
	}

	public Long getDestinatarioId() {
		return destinatarioId;
	}

	public void setDestinatarioId(Long destinatarioId) {
		this.destinatarioId = destinatarioId;
	}
	

}
