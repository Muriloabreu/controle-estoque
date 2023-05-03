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

import com.api.controleestoque.dtos.EntradaProdutoDtos;
import com.api.controleestoque.dtos.ProdutoDtos;
import com.api.controleestoque.models.EntradaProdutoModel;
import com.api.controleestoque.models.ProdutosModel;
import com.api.controleestoque.services.EntradaProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/controle-estoque/entrada-produtos")
public class EntradaProdutoController {
	
	
	@Autowired
	EntradaProdutoService entradaProdutoService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveEntradaProduto(@RequestBody @Valid EntradaProdutoDtos entradaProdutoDtos){
		
				
		var entradaProdutoModel = new EntradaProdutoModel();
		BeanUtils.copyProperties(entradaProdutoDtos, entradaProdutoModel);		
		
		entradaProdutoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		
		
		if (entradaProdutoModel.getProdutosModel().getEstoqueAtual() == null) {

			entradaProdutoModel.getProdutosModel().setEstoqueAtual(0);
	
		}
			
			entradaProdutoModel.getProdutosModel().setEstoqueAtual(entradaProdutoModel.getProdutosModel().getEstoqueAtual() + entradaProdutoModel.getQuantidade());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(entradaProdutoService.save(entradaProdutoModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<EntradaProdutoModel>> getAllProdutos(){
		
		return ResponseEntity.status(HttpStatus.OK).body(entradaProdutoService.findAll());
	}

}
