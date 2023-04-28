package com.api.controleestoque.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CLIENTES")
public class ClienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false,  length = 100)
	private String sobreNome;
	@Column(nullable = false, unique = true, length = 20)
	private String cpf;
	@Column(nullable = false,  length = 100)
	private String telefone;
	@Column(nullable = false, length = 15)
	private String cep;
	@Column(nullable = false, length = 100)
	private String logradouro;
	@Column(nullable = false, length = 200)
	private String complemento;
	@Column(nullable = false, length = 100)
	private String bairro;
	@Column(nullable = false, length = 100)
	private String localidade;
	@Column(nullable = false, length = 5)
	private String uf;
	
	/*Construtor*/
	
	public ClienteModel() {
		super();
	}

	
	public ClienteModel(Long id, String nome, String sobreNome, String cpf, String telefone, String cep,
			String logradouro, String complemento, String bairro, String localidade, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}



	/*Métodos Acessores*/

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

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getLocalidade() {
		return localidade;
	}


	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	@Override
	public String toString() {
		return "ClienteModel [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", cpf=" + cpf + ", telefone="
				+ telefone + ", cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, complemento, cpf, id, localidade, logradouro, nome, sobreNome, telefone, uf);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteModel other = (ClienteModel) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(id, other.id) && Objects.equals(localidade, other.localidade)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(nome, other.nome)
				&& Objects.equals(sobreNome, other.sobreNome) && Objects.equals(telefone, other.telefone)
				&& Objects.equals(uf, other.uf);
	}

	
	
	
	
	
	
	
	
	

}
