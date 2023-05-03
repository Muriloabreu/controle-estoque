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


import com.api.controleestoque.dtos.SaidaProdutoDtos;
import com.api.controleestoque.models.ProdutosModel;
import com.api.controleestoque.models.SaidaProdutoModel;
import com.api.controleestoque.services.ProdutoService;
import com.api.controleestoque.services.SaidaProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/controle-estoque/saida-produtos")
public class SaidaProdutoController {
	
	@Autowired
	SaidaProdutoService saidaProdutoService;
	@Autowired
	ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<Object> saveSaidaProduto(@RequestBody @Valid SaidaProdutoDtos saidaProdutoDtos){
		
				
		var saidaProdutoModel = new SaidaProdutoModel();
		BeanUtils.copyProperties(saidaProdutoDtos, saidaProdutoModel);		
		
		Optional<ProdutosModel> produtoOptional = saidaProdutoService.findByIdProduto(saidaProdutoModel.getProdutosModel().getId());
			
		var produtoModel = produtoOptional.get();
		if (produtoModel.getEstoqueAtual() >  0) {
			
			produtoModel.setEstoqueAtual( saidaProdutoModel.getQuantidade() - produtoModel.getEstoqueAtual() );
			
			saidaProdutoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
				
			
			return ResponseEntity.status(HttpStatus.OK).body(saidaProdutoService.save(saidaProdutoModel));			
	
		}
				
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Estoque zerado! Não será possivel continuar ");
	}
	
	@GetMapping
	public ResponseEntity<List<SaidaProdutoModel>> getAllSaidasProdutos(){
		
		return ResponseEntity.status(HttpStatus.OK).body(saidaProdutoService.findAll());
	}

}
