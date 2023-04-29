package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import com.api.controleestoque.models.ProdutosModel;



public interface ProdutoService {
	
	List<ProdutosModel> findAll();
	Optional<ProdutosModel> findById(Long id);
	ProdutosModel save(ProdutosModel produto);
	void delete(ProdutosModel produto);
	boolean existsByNome(String nome);

}
