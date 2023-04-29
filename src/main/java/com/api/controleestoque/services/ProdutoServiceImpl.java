package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.controleestoque.models.ProdutosModel;
import com.api.controleestoque.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public List<ProdutosModel> findAll() {
		
		return produtoRepository.findAll();
	}

	@Override
	public Optional<ProdutosModel> findById(Long id) {
		
		return produtoRepository.findById(id);
	}

	@Override
	@Transactional
	public ProdutosModel save(ProdutosModel produto) {
		
		return produtoRepository.save(produto);
	}

	@Override
	@Transactional
	public void delete(ProdutosModel produto) {
		
		produtoRepository.delete(produto);
		
	}

	@Override
	public boolean existsByNome(String nome) {
		
		return produtoRepository.existsByNome(nome);
	}

}
