package br.com.senai.restaurante.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.senai.restaurante.model.Restaurante;

public class RestauranteDTO {

	Integer idrestaurante;
	String nomeEstabelecimento;
	String responsavel;
	String cnpj;
	String contato;
	String especialidade;
	EnderecoDTO endereco;
	@JsonManagedReference
	List<CardapioDTO> listaCardapio;

	public RestauranteDTO(Restaurante restaurante) {
		this.idrestaurante = restaurante.getIdrestaurante();
		this.nomeEstabelecimento = restaurante.getNomeEstabelecimento();
		this.responsavel = restaurante.getResponsavel();
		this.cnpj = restaurante.getCnpj();
		this.contato = restaurante.getContato();
		this.especialidade = restaurante.getEspecialidade();
		this.endereco = new EnderecoDTO(restaurante.getEndereco());
		if (restaurante.getListaCardapio() != null) {
			this.listaCardapio = restaurante.getListaCardapio().stream().map(CardapioDTO::criaCardapioSemRestaurante)
					.toList();
			this.listaCardapio.forEach((c) -> c.setRestauranteDTO(this));
		}

	}

	public RestauranteDTO() {

	}

	public RestauranteDTO(Integer idrestaurante, String nomeEstabelecimento, String responsavel, String cnpj,
			String contato, String especialidade, EnderecoDTO endereco, List<CardapioDTO> listaCardapio) {
		super();
		this.idrestaurante = idrestaurante;
		this.nomeEstabelecimento = nomeEstabelecimento;
		this.responsavel = responsavel;
		this.cnpj = cnpj;
		this.contato = contato;
		this.especialidade = especialidade;
		this.endereco = endereco;
		this.listaCardapio = listaCardapio;
	}

	public List<CardapioDTO> getListaCardapio() {
		return listaCardapio;
	}

	public void setListaCardapio(List<CardapioDTO> listaCardapio) {
		this.listaCardapio = listaCardapio;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
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
