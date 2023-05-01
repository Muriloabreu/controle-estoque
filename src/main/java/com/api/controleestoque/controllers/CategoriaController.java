package com.api.controleestoque.controllers;


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

import com.api.controleestoque.dtos.CategoriaDtos;
import com.api.controleestoque.models.CategoriaModel;
import com.api.controleestoque.services.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/controle-estoque/categorias")
public class CategoriaController {
		
	@Autowired	
	CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<Object> saveCategoria(@RequestBody @Valid CategoriaDtos categoriaDtos){
		
		if(categoriaService.existsByNome(categoriaDtos.getNome())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Nome para Categoria já cadastrado!"); /* Check se existe fornecedor já cadastrado */
		}
				
		var categoriaModel = new CategoriaModel();
		BeanUtils.copyProperties(categoriaDtos, categoriaModel);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(categoriaModel));		
		
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAllCategorias(){
		
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCategoria(@PathVariable(value = "id") Long id){
		
		Optional<CategoriaModel> categoriaOptional = categoriaService.findById(id);
		if (!categoriaOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrado. ");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCategoria(@PathVariable(value = "id") Long id) {

		Optional<CategoriaModel> categoriaOptional = categoriaService.findById(id);
		if (!categoriaOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrado. ");
		}

		categoriaService.delete(categoriaOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Categoria deletado com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateConsumo(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid CategoriaDtos categoriaDtos) {

		Optional<CategoriaModel> categoriaOptional = categoriaService.findById(id);
		if (!categoriaOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrado. ");
		}
		
		var categoriaModel = categoriaOptional.get();
		categoriaModel.setNome(categoriaDtos.getNome());
		categoriaModel.setDescricao(categoriaDtos.getDescricao());		
		
				
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(categoriaModel));
	

	}

}
