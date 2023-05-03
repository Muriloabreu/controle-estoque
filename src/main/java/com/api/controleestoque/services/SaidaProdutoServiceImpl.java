package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.controleestoque.models.ProdutosModel;
import com.api.controleestoque.models.SaidaProdutoModel;
import com.api.controleestoque.repositories.ProdutoRepository;
import com.api.controleestoque.repositories.SaidaProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class SaidaProdutoServiceImpl implements SaidaProdutoService{
	
	
	@Autowired
	SaidaProdutoRepository saidaProdutoRepository;
	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public List<SaidaProdutoModel> findAll() {
		
		return saidaProdutoRepository.findAll();
	}

	@Override
	public Optional<SaidaProdutoModel> findById(Long id) {
		
		
		return saidaProdutoRepository.findById(id);
	}

	@Override
	public Optional<ProdutosModel> findByIdProduto(Long id) {
		
		return produtoRepository.findById(id);
	}

	@Override
	@Transactional
	public SaidaProdutoModel save(SaidaProdutoModel saiProduto) {
		
		
		return saidaProdutoRepository.save(saiProduto);
	}

	@Override
	@Transactional
	public void delete(SaidaProdutoModel saiProduto) {
		
		saidaProdutoRepository.delete(saiProduto);
	}

}
