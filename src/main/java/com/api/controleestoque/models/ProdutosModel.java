package com.api.controleestoque.models;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUTOS")
public class ProdutosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Integer quantidadeMinima;
    @Column(nullable = false)
    private Integer quantidadeMaxima;
    @Column(nullable = false)
    private Integer estoqueAtual;
    @Column(nullable = false)
    private LocalDateTime dataRegistro;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private CategoriaModel categoria;
	
    /* Construtor */
    
    public ProdutosModel() {
		super();
	}

	public ProdutosModel(Long id, String nome, String descricao, Integer quantidadeMinima, Integer quantidadeMaxima,
			Integer estoqueAtual ,LocalDateTime dataRegistro) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeMinima = quantidadeMinima;
		this.quantidadeMaxima = quantidadeMaxima;
		this.estoqueAtual = estoqueAtual;
		this.dataRegistro = dataRegistro;
	}
	
	/* Métodos Acessores */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		
		if (estoqueAtual < quantidadeMinima) {
			
			System.out.println( "Estoque esta critico! ");
		}	
		
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(Integer quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	public Integer getQuantidadeMaxima() {
		
		if(estoqueAtual > quantidadeMaxima) {
			
			System.out.println("Estoque está maior que o permitido");
		}
		
		return quantidadeMaxima;
	}

	public void setQuantidadeMaxima(Integer quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}
	
	public Integer getEstoqueAtual() {
		
		Integer estoqueInicial = 0;
		
		return estoqueInicial;
	}
	
	public void setEstoqueAtual(Integer estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	@Override
	public String toString() {
		return "ProdutosModel [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", quantidadeMinima="
				+ quantidadeMinima + ", quantidadeMaxima=" + quantidadeMaxima + ", estoqueAtual=" + estoqueAtual
				+ ", dataRegistro=" + dataRegistro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataRegistro, descricao, estoqueAtual, id, nome, quantidadeMaxima, quantidadeMinima);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutosModel other = (ProdutosModel) obj;
		return Objects.equals(dataRegistro, other.dataRegistro) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(estoqueAtual, other.estoqueAtual) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(quantidadeMaxima, other.quantidadeMaxima)
				&& Objects.equals(quantidadeMinima, other.quantidadeMinima);
	}

	
    
    
    
   
    
    
    
    
	

}
