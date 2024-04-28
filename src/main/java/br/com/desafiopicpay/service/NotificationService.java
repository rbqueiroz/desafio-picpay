package br.com.desafiopicpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.desafiopicpay.DTO.NotificationDTO;
import br.com.desafiopicpay.model.Usuario;

@Service
public class NotificationService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${status.notification}")
    private String statusNotification;
	
	public void sendNotification(Usuario usuario, String message) throws Exception {
		
		String email = usuario.getEmail();
		
		NotificationDTO notificationRequest = new NotificationDTO(email, message);
		
		ResponseEntity<String> notificationResponse = restTemplate.postForEntity(statusNotification, notificationRequest, String.class);
		
		if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
			System.out.println("Erro ao enviar notificação");
			throw new Exception("Serviço indisponível");
		}
	}

}
