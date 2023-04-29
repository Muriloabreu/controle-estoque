package com.api.controleestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.controleestoque.models.FornecedorModel;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {

	boolean existsByNome(String nome);
	boolean existsByCnpj(String cnpj);
}
