package br.com.quintatarde.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fornecedor extends GenericDomain{
	
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	//getters and setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
