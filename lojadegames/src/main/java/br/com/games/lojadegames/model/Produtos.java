package br.com.games.lojadegames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	


	@NotNull(message = "O nome não pode estar vazio.")
	@Size(min =2, max = 500, message = "O nome do produto deve conter no máximo 500 caracteres.")
	private String nome;
	
	@NotNull(message = "A descrição não pode estar vazia.")
	@Size(max = 500, message = "A descrição do produto deve conter no máximo 500 caracteres.")
	private String descricao;
	
	@NotNull(message = "Digite qual console o produto é compativel.")
	@Size(min = 3, max = 255, message = "Nome do console inválido, digite novamente.")
	private String console;
	
	@Range(min = 0, message = "A quantidade de produtos não pode ser menor que 0")
	private int quantidade;
	
	@Digits(integer=3,fraction=2,message="Apenas centenas e 2 casas após o ponto.")
	private BigDecimal preco;
	
	
	private String foto;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuario usuario;
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getConsole() {
		return console;
	}


	public void setConsole(String console) {
		this.console = console;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}

