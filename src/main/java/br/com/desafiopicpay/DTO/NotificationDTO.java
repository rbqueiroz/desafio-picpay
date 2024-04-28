package br.com.desafiopicpay.DTO;

public class NotificationDTO {
	
	public String email;
	public String mensage;
	
	public NotificationDTO(String email, String mensage) {
		super();
		this.email = email;
		this.mensage = mensage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
	
	

}
