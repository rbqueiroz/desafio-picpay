package br.com.desafiopicpay.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiopicpay.DTO.UsuarioDTO;
import br.com.desafiopicpay.model.UserType;
import br.com.desafiopicpay.model.Usuario;
import br.com.desafiopicpay.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void validarTransacao(Usuario remetente, BigDecimal valor) throws Exception {

		if (remetente.getTipoUsuario() != UserType.COMUM) {
			throw new Exception("Logista não está autorizado a realizar transações");
		}

		if (remetente.getSaldo().compareTo(valor) < 0) {
			throw new Exception("Saldo insuficiente");
		}

	}

	public Usuario findUsuarioById(Long id) throws Exception {
		return this.usuarioRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
	}

	public Usuario salvarUsuario(UsuarioDTO usuario) {
		Usuario newUsuario = new Usuario(usuario);
		this.salvarUsuario(newUsuario);
		return newUsuario;
	}

	public void salvarUsuario(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}

	public List<Usuario> getAllUsusarios() {
		return this.usuarioRepository.findAll();
	}

}
