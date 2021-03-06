package br.com.games.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.games.lojadegames.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	public List <Produtos> findAllByNomeContainingIgnoreCase(String Nome);
}
