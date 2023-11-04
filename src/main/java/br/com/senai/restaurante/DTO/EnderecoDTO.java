package br.com.senai.restaurante.DTO;

import br.com.senai.restaurante.model.Endereco;

public class EnderecoDTO {

	Integer idendereco;
	String estado;
	String cidade;
	Integer numero;
	String bairro;
	String rua;

	public EnderecoDTO(Endereco endereco) {
		this.idendereco = endereco.getIdendereco();
		this.estado = endereco.getEstado();
		this.cidade = endereco.getCidade();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.rua = endereco.getRua();
	}

	public EnderecoDTO() {

	}

	public EnderecoDTO(Integer idendereco, String estado, String cidade, Integer numero, String bairro, String rua) {
		super();
		this.idendereco = idendereco;
		this.estado = estado;
		this.cidade = cidade;
		this.numero = numero;
		this.bairro = bairro;
		this.rua = rua;
	}

	public Integer getIdendereco() {
		return idendereco;
	}

	public void setIdendereco(Integer idendereco) {
		this.idendereco = idendereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
