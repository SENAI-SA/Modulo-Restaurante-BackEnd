package br.com.senai.restaurante.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.senai.restaurante.model.Cardapio;

public class CardapioDTO {
	Integer idcardapio;
	String nomeItem;
	String descricao;
	Double preco;
	Integer tempoPreparo;
	String caminhoFoto;
	@JsonBackReference
	RestauranteDTO restauranteDTO;

	public CardapioDTO(Cardapio cardapio) {

		this.idcardapio = cardapio.getIdcardapio();
		this.nomeItem = cardapio.getNomeItem();
		this.descricao = cardapio.getDescricao();
		this.preco = cardapio.getPreco();
		this.tempoPreparo = cardapio.getTempoPreparo();
		this.caminhoFoto = cardapio.getCaminhoFoto();
		
		this.restauranteDTO =  new RestauranteDTO(cardapio.getRestaurante());
	}
	
	public static CardapioDTO criaCardapioSemRestaurante(Cardapio cardapio) {
		
		CardapioDTO cardapioDTO = new CardapioDTO();
		cardapioDTO.idcardapio = cardapio.getIdcardapio();
		cardapioDTO.nomeItem = cardapio.getNomeItem();
		cardapioDTO.descricao = cardapio.getDescricao();
		cardapioDTO.preco = cardapio.getPreco();
		cardapioDTO.tempoPreparo = cardapio.getTempoPreparo();
		cardapioDTO.caminhoFoto = cardapio.getCaminhoFoto();
		
		return cardapioDTO;
	}

	public CardapioDTO() {

	}

	public CardapioDTO(Integer idcardapio, String nomeItem, String descricao, Double preco, Integer tempoPreparo,
			String caminhoFoto, RestauranteDTO restauranteDTO) {
		super();
		this.idcardapio = idcardapio;
		this.nomeItem = nomeItem;
		this.descricao = descricao;
		this.preco = preco;
		this.tempoPreparo = tempoPreparo;
		this.caminhoFoto = caminhoFoto;
		this.restauranteDTO = restauranteDTO;
	}

	
	
	public RestauranteDTO getRestauranteDTO() {
		return restauranteDTO;
	}

	public void setRestauranteDTO(RestauranteDTO restauranteDTO) {
		this.restauranteDTO = restauranteDTO;
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
