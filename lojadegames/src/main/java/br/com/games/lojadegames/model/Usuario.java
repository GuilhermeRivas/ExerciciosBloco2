package br.com.games.lojadegames.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotBlank(message = "Úsuario deve ser preenchido.")
	@Size(max = 255, message = "Usuário não pode ultrapassar 255 caracteres.")
	private String usuario;
	
	@NotBlank(message = "Nome deve ser preenchido.")
	@Size(min = 5, max = 255, message = "O nome deve conter entre 5 e 255 caracteres.")
	private String nome;
	
	
	@NotBlank
	@Size(min = 8, max = 30, message = "A senha deve conter no mínimo 8 caracteres e no máximo 30.")
	private String senha;
	
	private String foto;
	
	@Past(message = "A data deve estar no passado.")
	private Instant data_nascimento;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Produtos> postagem;
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Instant getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Instant data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	
	
	
}
