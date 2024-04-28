package br.com.desafiopicpay.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.desafiopicpay.DTO.UsuarioDTO;



@Entity(name="usuarios")
@Table(name ="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String primeiroNome;
	
	private String sobreNome;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(unique = true)
	private String email;
	
	private BigDecimal saldo;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserType tipoUsuario;

	
	public Usuario(UsuarioDTO usuario) {
		this.primeiroNome = usuario.getPrimeiroNome();
		this.sobreNome = usuario.getSobreNome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.saldo = usuario.getSaldo();
		this.password = usuario.getPassword();
		this.tipoUsuario = usuario.getTipoUsuario();
	}
	
	
	
	public Usuario(Long id, String primeiroNome, String sobreNome, String cpf, String email, BigDecimal saldo,
			String password, UserType tipoUsuario) {
		super();
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.email = email;
		this.saldo = saldo;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario() {
        
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
