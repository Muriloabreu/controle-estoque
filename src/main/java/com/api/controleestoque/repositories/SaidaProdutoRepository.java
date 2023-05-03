package com.api.controleestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.controleestoque.models.SaidaProdutoModel;

public interface SaidaProdutoRepository extends JpaRepository<SaidaProdutoModel, Long>{

}
