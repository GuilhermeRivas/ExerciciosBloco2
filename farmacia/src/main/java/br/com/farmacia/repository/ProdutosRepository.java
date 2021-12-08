package br.com.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.farmacia.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	public List <Produtos> findByNomeOrLaboratorioContainingIgnoreCase(String Nome, String Laboratorio);

	public List <Produtos> findAllByNomeContainingIgnoreCase(String Nome);


}
