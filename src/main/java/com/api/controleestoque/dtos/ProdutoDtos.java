package com.api.controleestoque.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoDtos {
	
	@NotBlank
	private String nome;
	@NotBlank
    private String descricao;
    @NotNull
    private Integer quantidadeMinima;
    @NotNull
    private Integer quantidadeMaxima;
    
	public ProdutoDtos() {
		super();
	}
	
	
	public ProdutoDtos(@NotBlank String nome, @NotBlank String descricao, @NotNull Integer quantidadeMinima,
			@NotNull Integer quantidadeMaxima) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeMinima = quantidadeMinima;
		this.quantidadeMaxima = quantidadeMaxima;
	}








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
	public Integer getQuantidadeMinima() {
		return quantidadeMinima;
	}
	public void setQuantidadeMinima(Integer quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
	public Integer getQuantidadeMaxima() {
		return quantidadeMaxima;
	}
	public void setQuantidadeMaxima(Integer quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}
    
    

}
