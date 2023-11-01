package br.com.senai.restaurante.DTO;

import br.com.senai.restaurante.model.Cardapio;

public class CardapioDTO {
	Integer idcardapio;
	String nomeItem;
	String descricao;
	Double preco;
	Integer tempoPreparo;
	String caminhoFoto;

	private CardapioDTO(Cardapio cardapio) {

		this.idcardapio = cardapio.getIdcardapio();
		this.nomeItem = cardapio.getNomeItem();
		this.descricao = cardapio.getDescricao();
		this.preco = cardapio.getPreco();
		this.tempoPreparo = cardapio.getTempoPreparo();
		this.caminhoFoto = cardapio.getCaminhoFoto();
	}

	private CardapioDTO() {

	}

	private CardapioDTO(Integer idcardapio, String nomeItem, String descricao, Double preco, Integer tempoPreparo,
			String caminhoFoto) {
		super();
		this.idcardapio = idcardapio;
		this.nomeItem = nomeItem;
		this.descricao = descricao;
		this.preco = preco;
		this.tempoPreparo = tempoPreparo;
		this.caminhoFoto = caminhoFoto;
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
