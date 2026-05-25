package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Anotações servem para alterar ou definir comportamentos

@Entity // Definindo que a classe Postagem vai se tornar uma tabela
@Table(name = "tb_postagens") // Faz uma nomenclatura mais correta
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o banco de dados deve preencher os Ids automaticamente
	private Long id;


	@NotBlank(message = "O atributo título é obrigatório!") // Impede [       ] 
	@Size(min = 5, max = 100, message = "O atributo título deve ter no minimo 5 e no máximo 100 caracteres.") // Define que título deve ter no mínimo 5 caracteres e no máximo 100
	private String titulo;

	@NotBlank(message = "O atributo texto é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve ter no minimo 10 e no máximo 1000 caracteres.")
	private String texto;

	@UpdateTimestamp // BD preenche esse campo e o atualiza
	private LocalDateTime data;
	
	@ManyToOne // Muitas Postagens podem ter apenas Um Tema
	@JsonIgnoreProperties // evita um looping de um entrar dentro do outro devido seu relacionamento
	private Tema tema;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
	
}
