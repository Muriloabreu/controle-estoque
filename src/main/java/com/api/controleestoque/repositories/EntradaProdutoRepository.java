package com.api.controleestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.controleestoque.models.EntradaProdutoModel;

@Repository
public interface EntradaProdutoRepository extends JpaRepository<EntradaProdutoModel, Long> {

	
}
