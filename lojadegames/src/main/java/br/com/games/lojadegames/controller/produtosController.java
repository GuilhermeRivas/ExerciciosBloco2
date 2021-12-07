package br.com.games.lojadegames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.games.lojadegames.model.Categoria;
import br.com.games.lojadegames.model.Produtos;
import br.com.games.lojadegames.repository.CategoriaRepository;
import br.com.games.lojadegames.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class produtosController {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> getAll(){
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Produtos> getByID(@PathVariable Long id){
		return produtosRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity <List<Produtos>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Produtos> postProduto(@Valid @RequestBody Produtos produto, Categoria categoria){
		//return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produto));
		
		
		return categoriaRepository.findById(produto.getCategoria().getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produto)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity<?> putProdutos(@Valid @RequestBody Produtos produto)
	{
		return produtosRepository.findById(produto.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produto)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteProdutos(@PathVariable Long id)
	{
		return produtosRepository.findById(id)
		.map(resp -> {
		produtosRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		})
		.orElse(ResponseEntity.notFound().build());
	}
	
}
