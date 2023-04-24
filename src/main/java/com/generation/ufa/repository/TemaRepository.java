package com.generation.ufa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.ufa.model.Tema;

public interface TemaRepository extends JpaRepository <Tema, Long> {
	public List <Tema>findAllByNome_temaContainingIgnoreCase (@Param ("nome_tema") String nome_tema);
	
	
}
