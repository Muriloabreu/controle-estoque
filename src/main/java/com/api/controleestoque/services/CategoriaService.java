package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import com.api.controleestoque.models.CategoriaModel;

;

public interface CategoriaService {
	
	List<CategoriaModel> findAll();
	Optional<CategoriaModel> findById(Long id);
	CategoriaModel save(CategoriaModel categoria);
	void delete(CategoriaModel categoria);
	boolean existsByNome(String nome);
	

}
