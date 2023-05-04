package com.api.controleestoque.dtos;

import com.api.controleestoque.models.ProdutosModel;

import jakarta.validation.constraints.NotNull;

public class SaidaProdutoDtos {
	
	
	@NotNull
	private ProdutosModel produtosModel;
	@NotNull
	private Integer quantidade;
	
	
	public SaidaProdutoDtos() {
		super();
	}

	public SaidaProdutoDtos(@NotNull ProdutosModel produtosModel, @NotNull Integer quantidade) {
		super();
		this.produtosModel = produtosModel;
		this.quantidade = quantidade;
	}

	public ProdutosModel getProdutosModel() {
		return produtosModel;
	}

	public void setProdutosModel(ProdutosModel produtosModel) {
		this.produtosModel = produtosModel;
	}

	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

	


	
	
	
	

}
