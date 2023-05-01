package com.api.controleestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.controleestoque.models.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
	
	boolean existsByNome(String nome);

}
