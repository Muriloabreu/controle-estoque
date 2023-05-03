package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;


import com.api.controleestoque.models.ProdutosModel;
import com.api.controleestoque.models.SaidaProdutoModel;

public interface SaidaProdutoService {
	
	List<SaidaProdutoModel> findAll();
	Optional<SaidaProdutoModel> findById(Long id);
	Optional<ProdutosModel> findByIdProduto(Long id);
	SaidaProdutoModel save(SaidaProdutoModel saiProduto);
	void delete(SaidaProdutoModel saiProduto);

}
