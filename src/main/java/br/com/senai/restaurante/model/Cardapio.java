package br.com.senai.restaurante.model;

import br.com.senai.restaurante.DTO.CardapioDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idcardapio;
	String nomeItem;
	String descricao;
	Double preco;
	Integer tempoPreparo;
	String caminhoFoto;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurante_idrestaurante")
	Restaurante restaurante;
	
	public Cardapio(CardapioDTO cardapio) {

		this.idcardapio = cardapio.getIdcardapio();
		this.nomeItem = cardapio.getNomeItem();
		this.descricao = cardapio.getDescricao();
		this.preco = cardapio.getPreco();
		this.tempoPreparo = cardapio.getTempoPreparo();
		this.caminhoFoto = cardapio.getCaminhoFoto();
		this.restaurante = new Restaurante(cardapio.getRestauranteDTO());
		
	}
	
	public static Cardapio criaCardapioSemRestaurante(CardapioDTO cardapio) {
		
		Cardapio cardapio1 = new Cardapio();
		cardapio1.idcardapio = cardapio.getIdcardapio();
		cardapio1.nomeItem = cardapio.getNomeItem();
		cardapio1.descricao = cardapio.getDescricao();
		cardapio1.preco = cardapio.getPreco();
		cardapio1.tempoPreparo = cardapio.getTempoPreparo();
		cardapio1.caminhoFoto = cardapio.getCaminhoFoto();
		
		return cardapio1;
		
	}

	public Cardapio() {

	}

	public Cardapio(Integer idcardapio, String nomeItem, String descricao, Double preco, Integer tempoPreparo,
			String caminhoFoto, Restaurante restaurante) {
		super();
		this.idcardapio = idcardapio;
		this.nomeItem = nomeItem;
		this.descricao = descricao;
		this.preco = preco;
		this.tempoPreparo = tempoPreparo;
		this.caminhoFoto = caminhoFoto;
		this.restaurante = restaurante;
	}
	
	

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Integer getIdcardapio() {
		return idcardapio;
	}

	public void setIdcardapio(Integer idcardapio) {
		this.idcardapio = idcardapio;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(Integer tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public String getCaminhoFoto() {
		return caminhoFoto;
	}

	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}

}
