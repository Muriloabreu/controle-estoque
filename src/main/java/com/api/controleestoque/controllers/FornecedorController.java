package com.api.controleestoque.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<List<FornecedorModel>> findAllFornecedores(){
		
		return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.findAll());
	}
	
	
	
}
