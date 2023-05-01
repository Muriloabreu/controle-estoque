package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.controleestoque.models.CategoriaModel;
import com.api.controleestoque.repositories.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public List<CategoriaModel> findAll() {
		
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<CategoriaModel> findById(Long id) {
		
		return categoriaRepository.findById(id);
	}

	@Override
	@Transactional
	public CategoriaModel save(CategoriaModel categoria) {
		
		return categoriaRepository.save(categoria);
	}

	@Override
	@Transactional
	public void delete(CategoriaModel categoria) {
		
		categoriaRepository.delete(categoria);
		
	}

	@Override
	public boolean existsByNome(String nome) {
		
		return categoriaRepository.existsByNome(nome);
	}

}
