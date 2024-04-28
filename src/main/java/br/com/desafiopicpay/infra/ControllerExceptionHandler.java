package br.com.desafiopicpay.infra;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.desafiopicpay.DTO.ExceptionDTO;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException exception) {
		ExceptionDTO exceptionDTO = new ExceptionDTO("Usuario já cadastrado", "400");
		return ResponseEntity.badRequest().body(exceptionDTO);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity threa404(EntityNotFoundException exception) {
		return ResponseEntity.badRequest().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleGeneralException(Exception exception) {
	    ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionDTO);
	}

}
