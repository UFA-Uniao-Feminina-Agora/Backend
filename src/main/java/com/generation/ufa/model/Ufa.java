package com.generation.ufa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "tb_temas")
public class Ufa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "O Atributo Descrição é obrigatório")
	private String descricao_tema;
	@NotNull(message = "O Atributo nome é obrigatório")
	private String nome_tema;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao_tema() {
		return this.getDescricao_tema();
	}

	public void setDescricao_tema(String descricao_tema) {
		this.descricao_tema = descricao_tema;
	}
	
	public String getNome_tema() {
		return this.getNome_tema();
	}

	public void setNome_tema(String nome_tema) {
		this.getNome_tema();
	}
	
	
}
