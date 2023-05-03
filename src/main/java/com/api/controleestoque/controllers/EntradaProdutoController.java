package com.api.controleestoque.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.controleestoque.dtos.EntradaProdutoDtos;
import com.api.controleestoque.models.CategoriaModel;
import com.api.controleestoque.models.EntradaProdutoModel;
import com.api.controleestoque.models.ProdutosModel;
import com.api.controleestoque.services.EntradaProdutoService;
import com.api.controleestoque.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/controle-estoque/entrada-produtos")
public class EntradaProdutoController {
	
	
	@Autowired
	EntradaProdutoService entradaProdutoService;
	@Autowired
	ProdutoService produtoService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveEntradaProduto(@RequestBody @Valid EntradaProdutoDtos entradaProdutoDtos){
		
				
		var entradaProdutoModel = new EntradaProdutoModel();
		BeanUtils.copyProperties(entradaProdutoDtos, entradaProdutoModel);		
		
		Optional<ProdutosModel> produtoOptional = entradaProdutoService.findByIdProduto(entradaProdutoModel.getProdutosModel().getId());
			
		var produtoModel = produtoOptional.get();
		if (produtoModel.getEstoqueAtual() == null) {

			produtoModel.setEstoqueAtual(0);
	
		}
		produtoModel.setEstoqueAtual( entradaProdutoModel.getQuantidade() + produtoModel.getEstoqueAtual() );
			
			entradaProdutoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
			
		
		return ResponseEntity.status(HttpStatus.OK).body(entradaProdutoService.save(entradaProdutoModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<EntradaProdutoModel>> getAllProdutos(){
		
		return ResponseEntity.status(HttpStatus.OK).body(entradaProdutoService.findAll());
	}

}
