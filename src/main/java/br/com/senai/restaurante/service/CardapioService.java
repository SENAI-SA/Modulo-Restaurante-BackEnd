package br.com.senai.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.restaurante.DTO.CardapioDTO;
import br.com.senai.restaurante.model.Cardapio;
import br.com.senai.restaurante.repository.CardapioRepository;

@Service
public class CardapioService {

	@Autowired
	private CardapioRepository cardapioRepository;
	@Autowired
	private RestauranteService restauranteService;

	public Cardapio salvaCardapio(CardapioDTO cardapioDTO) {
		Cardapio cardapio = new Cardapio(cardapioDTO);
		cardapio.setRestaurante(
				restauranteService.listaRestauranteID(cardapioDTO.getRestauranteDTO().getIdrestaurante()).get());
		return cardapioRepository.save(cardapio);
	}

	public List<Cardapio> listaCardapioPorRestaurante(Integer id) {
		return cardapioRepository.findByRestauranteIdrestaurante(id);
	}

	public List<Cardapio> listaCardapio() {
		return cardapioRepository.findAll();
	}

	public void excluirCardapio(Integer id) {
		cardapioRepository.deleteById(id);
	}
}
