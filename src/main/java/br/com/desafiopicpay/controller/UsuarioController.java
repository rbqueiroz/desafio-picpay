package br.com.desafiopicpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiopicpay.DTO.UsuarioDTO;
import br.com.desafiopicpay.model.Usuario;
import br.com.desafiopicpay.service.UsuarioService;

@RestController()
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuario){
		
		Usuario newUsuario = usuarioService.salvarUsuario(usuario);
		
		return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		List<Usuario> usuarios = this.usuarioService.getAllUsusarios();
		
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}

}
