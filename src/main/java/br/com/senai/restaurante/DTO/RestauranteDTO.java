package br.com.senai.restaurante.DTO;

import br.com.senai.restaurante.model.Restaurante;

public class RestauranteDTO {

	Integer idrestaurante;
	String nomeEstabelecimento;
	String responsavel;
	String cnpj;
	String contato;
	String especialidade;

	private RestauranteDTO(Restaurante restaurante) {
		this.idrestaurante = restaurante.getIdrestaurante();
		this.nomeEstabelecimento = restaurante.getNomeEstabelecimento();
		this.responsavel = restaurante.getResponsavel();
		this.cnpj = restaurante.getCnpj();
		this.contato = restaurante.getContato();
		this.especialidade = restaurante.getEspecialidade();
	}

	private RestauranteDTO() {
		
	}

	private RestauranteDTO(Integer idrestaurante, String nomeEstabelecimento, String responsavel, String cnpj,
			String contato, String especialidade) {
		super();
		this.idrestaurante = idrestaurante;
		this.nomeEstabelecimento = nomeEstabelecimento;
		this.responsavel = responsavel;
		this.cnpj = cnpj;
		this.contato = contato;
		this.especialidade = especialidade;
	}

	public Integer getIdrestaurante() {
		return idrestaurante;
	}

	public void setIdrestaurante(Integer idrestaurante) {
		this.idrestaurante = idrestaurante;
	}

	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}
