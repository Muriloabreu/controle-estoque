package com.api.controleestoque.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDtos {
	
	@NotBlank
	private String nome;
	@NotBlank
    private String descricao;
	
	
	/* Construtor */
	
	public CategoriaDtos() {
		super();
	}

	public CategoriaDtos(@NotBlank String nome, @NotBlank String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	/* Métodos Acessores */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	

}
