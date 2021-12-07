package br.com.games.lojadegames.repository;

import br.com.games.lojadegames.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
