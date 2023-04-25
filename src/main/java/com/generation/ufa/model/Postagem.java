package com.generation.ufa.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens")
public class Postagem {

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo título é um campo obrigatório!")
	@Size(min = 5, max = 100, message = "Titulo deve ter no minimo 05 e no máximo 100 caracteres!")
	private String titulo;
	
	@NotBlank(message = "O atributo texto é um campo obrigatório!")
	@Size(min = 5, max = 1000, message = "Texto deve ter no minimo 05 e no máximo 1000 caracteres!")
	private String texto;
	
	/*
	 @DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date date;
	*/
	
	private String link;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
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

	/*public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
*/
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
