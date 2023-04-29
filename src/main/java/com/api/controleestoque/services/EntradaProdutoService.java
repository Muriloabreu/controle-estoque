package com.api.controleestoque.services;

import java.util.List;
import java.util.Optional;

import com.api.controleestoque.models.ClienteModel;




public interface ClienteService {
	
	List<ClienteModel> findAll();
	Optional<ClienteModel> findById(Long id);
	ClienteModel save(ClienteModel cliente);
	void delete(ClienteModel livro);
	boolean existsByCpf(String cpf);

}
