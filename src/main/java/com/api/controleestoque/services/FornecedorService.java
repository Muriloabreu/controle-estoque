package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import com.api.controleestoque.models.FornecedorModel;

public interface FornecedorService {

	List<FornecedorModel> findAll();
	Optional<FornecedorModel> findById(Long id);
	FornecedorModel save(FornecedorModel fornecedor);
	void delete(FornecedorModel fornecedor);
	boolean existsByCpf(String cpf);
}
