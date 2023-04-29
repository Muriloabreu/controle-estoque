package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.controleestoque.models.ClienteModel;
import com.api.controleestoque.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public List<ClienteModel> findAll() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Optional<ClienteModel> findById(Long id) {
		
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public ClienteModel save(ClienteModel cliente) {
		
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(ClienteModel cliente) {
		
		clienteRepository.delete(cliente);
		
	}

	@Override
	public boolean existsByCpf(String cpf) {
		
		return clienteRepository.existsByCpf(cpf);
	}

}
