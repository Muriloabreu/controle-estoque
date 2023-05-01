package com.api.controleestoque.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.controleestoque.dtos.ProdutoDtos;
import com.api.controleestoque.models.ProdutosModel;
import com.api.controleestoque.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/controle-estoque/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	
	
	@PostMapping
	public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDtos produtoDtos){
		
		if(produtoService.existsByNome(produtoDtos.getNome())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Nome para Produto já cadastrado!"); /* Check se existe fornecedor já cadastrado */
		}
		
		
		var produtoModel = new ProdutosModel();
		BeanUtils.copyProperties(produtoDtos, produtoModel);
		produtoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produtoModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutosModel>> getAllProdutos(){
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
	}

}
