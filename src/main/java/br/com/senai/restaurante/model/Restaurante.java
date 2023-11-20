package br.com.senai.restaurante.model;

import java.util.List;

import br.com.senai.restaurante.DTO.RestauranteDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Restaurante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idrestaurante;
	Long idusuario;
	String nomeEstabelecimento;
	String responsavel;
	String cnpj;
	String contato;
	String especialidade;

	@JoinColumn(name = "endereco_idendereco")
	@OneToOne(cascade = CascadeType.ALL)
	
	Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
	List<Cardapio> listaCardapio;

	public Restaurante(RestauranteDTO restaurante) {
		this.idrestaurante = restaurante.getIdrestaurante();
		this.nomeEstabelecimento = restaurante.getNomeEstabelecimento();
		this.responsavel = restaurante.getResponsavel();
		this.cnpj = restaurante.getCnpj();
		this.contato = restaurante.getContato();
		this.especialidade = restaurante.getEspecialidade();
		this.endereco = new Endereco(restaurante.getEndereco());
		this.listaCardapio = restaurante.getListaCardapio().stream().map(Cardapio::criaCardapioSemRestaurante).toList();
		this.listaCardapio.forEach((c)->c.setRestaurante(this));
		
	}

	public Restaurante() {
		super();
	}

	public Restaurante(Integer idrestaurante, String nomeEstabelecimento, String responsavel, String cnpj,
			String contato, String especialidade, List<Cardapio> listaCardapio) {
		super();
		this.idrestaurante = idrestaurante;
		this.nomeEstabelecimento = nomeEstabelecimento;
		this.responsavel = responsavel;
		this.cnpj = cnpj;
		this.contato = contato;
		this.especialidade = especialidade;
		this.listaCardapio = listaCardapio;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Cardapio> getListaCardapio() {
		return listaCardapio;
	}

	public void setListaCardapio(List<Cardapio> listaCardapio) {
		this.listaCardapio = listaCardapio;
	}

}
