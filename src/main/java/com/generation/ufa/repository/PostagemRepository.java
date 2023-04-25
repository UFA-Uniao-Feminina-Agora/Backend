package com.generation.ufa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.ufa.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	List<Postagem>findAllByTituloContainingIgnoreCase(@Param("titulo")String titulo);

	List<Postagem>findAllByData(LocalDateTime data);
	
}
