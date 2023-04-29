package com.api.controleestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.controleestoque.models.ProdutosModel;

public interface ProdutoRepository extends JpaRepository<ProdutosModel, Long>{
	
	boolean existsByNome(String nome);

}
