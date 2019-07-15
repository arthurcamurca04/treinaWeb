package br.com.treinaweb.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.treinaweb.modelos.Usuario;
import br.com.treinaweb.repositorio.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired /* princípio da injeção de dependências - essa anotation faz com que o spring crie em tempo de execução 
	um objeto RepositorioUsuario, e o injete na Classe ServicoUsuario */
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired /* Algoritmo BCrypt - serve parar fazer um hash da senha (criptpgrafia unidirecional)*/
	private BCryptPasswordEncoder passwordEncoder;
	
	public Usuario encontrarPorEmail(String email) {
		Usuario user = repositorioUsuario.findByEmail(email);
		return user;
	}
	
	public void salvar(Usuario u) {
		u.setSenha(passwordEncoder.encode(u.getSenha()));
		repositorioUsuario.save(u);
	}
}
