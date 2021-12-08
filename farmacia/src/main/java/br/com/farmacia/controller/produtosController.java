package br.com.farmacia.controller;

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

import br.com.farmacia.model.Categoria;
import br.com.farmacia.model.Produtos;
import br.com.farmacia.repository.CategoriaRepository;
import br.com.farmacia.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class produtosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> getAll(){
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> getById(@PathVariable Long id){
		return produtosRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/busca/{nome}")
	public ResponseEntity<List<Produtos>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/busca/{nome}/{laboratorio}")
	public ResponseEntity<List<Produtos>> getByNomeAndLaboratorio(@PathVariable String nome, @PathVariable String laboratorio){
		return ResponseEntity.ok(produtosRepository.findByNomeOrLaboratorioContainingIgnoreCase(nome, laboratorio));
	}
	
	
	@PostMapping
	public ResponseEntity<Produtos> postProduto(@Valid @RequestBody Produtos produtos, Categoria categoria){		
		return categoriaRepository.findById(produtos.getCategoria().getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity<Produtos> putProduto(@Valid @RequestBody Produtos produtos){
		return produtosRepository.findById(produtos.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(produtosRepository.save(produtos));
				})
				.orElse(ResponseEntity.notFound().build());
				}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProdutos(@PathVariable Long id){
		return produtosRepository.findById(id)
				.map(resp -> {
					produtosRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	
	}
}


