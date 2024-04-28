package br.com.desafiopicpay.DTO;

import java.math.BigDecimal;

import br.com.desafiopicpay.model.UserType;

public class UsuarioDTO {

	private String primeiroNome;

	private String sobreNome;

	private String cpf;

	private BigDecimal saldo;

	private String email;
	
	private String password;
	
	private UserType tipoUsuario;

	public UsuarioDTO(String primeiroNome, String sobreNome, String cpf, BigDecimal saldo, String email,
			String password, UserType tipoUsuario) {
		super();
		this.primeiroNome = primeiroNome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.saldo = saldo;
		this.email = email;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(UserType tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	

}
