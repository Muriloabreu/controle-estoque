package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.controleestoque.models.EntradaProdutoModel;
import com.api.controleestoque.repositories.EntradaProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class EntradaProdutoServiceImpl implements EntradaProdutoService {

	@Autowired
	EntradaProdutoRepository entradaProdutoRepository;
	
	@Override
	public List<EntradaProdutoModel> findAll() {
		
		return entradaProdutoRepository.findAll();
	}

	@Override
	public Optional<EntradaProdutoModel> findById(Long id) {
		
		return entradaProdutoRepository.findById(id);
	}

	@Override
	@Transactional
	public EntradaProdutoModel save(EntradaProdutoModel cliente) {
		
		return entradaProdutoRepository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(EntradaProdutoModel cliente) {
		
		entradaProdutoRepository.delete(cliente);
		
	}

	

}
