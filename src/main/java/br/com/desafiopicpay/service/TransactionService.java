package br.com.desafiopicpay.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.desafiopicpay.DTO.TransactionDTO;
import br.com.desafiopicpay.model.Usuario;
import br.com.desafiopicpay.repository.TransactionRepository;
import br.com.desafiopicpay.transaction.Transaction;

@Service
public class TransactionService {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private NotificationService notificationService;
	
	@Value("${status.transaction}")
    private String statusTransaction;
	
	
	public Transaction createTransaction(TransactionDTO transaction) throws Exception {
		
		Usuario remetente = this.usuarioService.findUsuarioById(transaction.getRemetenteId());
		Usuario destinatario = this.usuarioService.findUsuarioById(transaction.getDestinatarioId());
		
		usuarioService.validarTransacao(remetente, transaction.getValor());
		
		boolean isAuthorized = this.authorizeTransaction(remetente, transaction.getValor());
		if (!isAuthorized) {
			throw new Exception("Transação não autorizada");
		}
		
		Transaction newTransaction = new Transaction(
			    null,
			    transaction.getValor(),
			    remetente,
			    destinatario,
			    LocalDateTime.now()
			);
		
		remetente.setSaldo(remetente.getSaldo().subtract(transaction.getValor()));
		destinatario.setSaldo(destinatario.getSaldo().add(transaction.getValor()));
		
		this.transactionRepository.save(newTransaction);
		this.usuarioService.salvarUsuario(remetente);
		this.usuarioService.salvarUsuario(destinatario);
		
		this.notificationService.sendNotification(remetente, "Transação realizada com sucesso");
		this.notificationService.sendNotification(destinatario, "Transação recebida com sucesso");
		
		return newTransaction;

	}
	
	public boolean authorizeTransaction(Usuario remetente, BigDecimal valor) {
		ResponseEntity<Map> authorizationResponse  = restTemplate.getForEntity(statusTransaction, Map.class);
		
		if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
			String message  = (String) authorizationResponse.getBody().get("message");
			return "Autorizado".equalsIgnoreCase(message);
		}else return false;
	}
	
}
