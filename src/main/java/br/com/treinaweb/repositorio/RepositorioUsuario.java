package br.com.treinaweb.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.treinaweb.modelos.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
}
