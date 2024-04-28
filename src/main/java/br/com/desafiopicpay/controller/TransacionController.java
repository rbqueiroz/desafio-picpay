package br.com.desafiopicpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiopicpay.DTO.TransactionDTO;
import br.com.desafiopicpay.service.TransactionService;
import br.com.desafiopicpay.transaction.Transaction;

@RestController
@RequestMapping("/transactions")
public class TransacionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception{
		
		Transaction newTransaction = this.transactionService.createTransaction(transaction);
		
		return new ResponseEntity<>(newTransaction, HttpStatus.OK);
	}
	
	
}
