package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.controleestoque.models.FornecedorModel;
import com.api.controleestoque.repositories.FornecedorRepository;

import jakarta.transaction.Transactional;

public class FornecedorServiceImpl implements FornecedorService{

	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Override
	public List<FornecedorModel> findAll() {
		
		return fornecedorRepository.findAll();
	}

	@Override
	public Optional<FornecedorModel> findById(Long id) {
		
		return fornecedorRepository.findById(id);
	}

	@Override
	@Transactional
	public FornecedorModel save(FornecedorModel fornecedor) {
		
		return fornecedorRepository.save(fornecedor);
	}

	@Override
	@Transactional
	public void delete(FornecedorModel fornecedor) {
		
		fornecedorRepository.delete(fornecedor);
		
	}

	@Override
	public boolean existsByCpf(String nome) {
		
		return fornecedorRepository.existsByNome(nome);
	}

}
