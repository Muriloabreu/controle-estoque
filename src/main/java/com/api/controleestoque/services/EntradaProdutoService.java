package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import com.api.controleestoque.models.EntradaProdutoModel;
import com.api.controleestoque.models.ProdutosModel;




public interface EntradaProdutoService {
	
	List<EntradaProdutoModel> findAll();
	Optional<EntradaProdutoModel> findById(Long id);
	Optional<ProdutosModel> findByIdProduto(Long id);
	EntradaProdutoModel save(EntradaProdutoModel entProduto);
	void delete(EntradaProdutoModel entProduto);
	

}
