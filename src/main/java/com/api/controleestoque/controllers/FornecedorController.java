package com.api.controleestoque.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.controleestoque.dtos.FornecedorDtos;
import com.api.controleestoque.models.FornecedorModel;
import com.api.controleestoque.services.FornecedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/controle-estoque/fornecedores")
public class FornecedorController {

	@Autowired
	FornecedorService fornecedorService;
	
	@PostMapping
	public ResponseEntity<Object> saveFornecedor(@RequestBody @Valid FornecedorDtos fornecedorDtos){
		
		if(fornecedorService.existsByCnpj(fornecedorDtos.getCnpj())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CNPJ para Fornecedor já cadastrado!"); /* Check se existe fornecedor já cadastrado */
		}
		if( fornecedorService.existsByNome(fornecedorDtos.getNome())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Nome para Fornecedor já cadastrado!");
		}
		
		var fornecedorModel = new FornecedorModel();
		BeanUtils.copyProperties(fornecedorDtos, fornecedorModel);
		fornecedorModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		
		return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.save(fornecedorModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<FornecedorModel>> getAllFornecedores(){
		
		return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneFornecedor(@PathVariable(value = "id") Long id){
		
		Optional<FornecedorModel> fornecedorOptional = fornecedorService.findById(id);
		if (!fornecedorOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado. ");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFornecedor(@PathVariable(value = "id") Long id) {

		Optional<FornecedorModel> fornecedorOptional = fornecedorService.findById(id);
		if (!fornecedorOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado. ");
		}

		fornecedorService.delete(fornecedorOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Fornecedor deletado com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateConsumo(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid FornecedorDtos fornecedorDtos) {

		Optional<FornecedorModel> fornecedorOptional = fornecedorService.findById(id);
		if (!fornecedorOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado. ");
		}
		
		var fornecedorModel = fornecedorOptional.get();
		fornecedorModel.setNome(fornecedorDtos.getNome());
		fornecedorModel.setCnpj(fornecedorDtos.getCnpj());
		
		
				
		return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.save(fornecedorModel));
	

	}
	
	
	
}
