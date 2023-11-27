package br.com.senai.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.senai.restaurante.DTO.CardapioDTO;
import br.com.senai.restaurante.model.Cardapio;
import br.com.senai.restaurante.service.CardapioService;
import br.com.senai.restaurante.service.RestauranteService;

@RestController

@RequestMapping("/cardapio")
public class CardapioController {

	@Autowired
	private CardapioService cardapioService;

	@Autowired
	private RestauranteService restauranteService;
	
	
	@PostMapping
	public ResponseEntity<CardapioDTO> criaCardapio(@RequestBody CardapioDTO cardapioDTO) {
		Cardapio cardapio = cardapioService.salvaCardapio(cardapioDTO);
		
		return ResponseEntity.ok(new CardapioDTO(cardapio));
	}

	@GetMapping
	public ResponseEntity<List<CardapioDTO>> listaCardapio() {
		List<Cardapio> cardapio = cardapioService.listaCardapio();
		List<CardapioDTO> cardapioDTO = cardapio.stream().map(CardapioDTO::new).toList();
		return ResponseEntity.ok(cardapioDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<CardapioDTO>> listaCardapioPorRestaurante(@PathVariable Integer id){
		List<Cardapio> cardapio = cardapioService.listaCardapioPorRestaurante(id);
		List<CardapioDTO> cardapioDTO = cardapio.stream().map(CardapioDTO::new).toList();
		return ResponseEntity.ok(cardapioDTO);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirCardapio(@PathVariable Integer id) {
		cardapioService.excluirCardapio(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping
	public ResponseEntity<CardapioDTO> atualizaCardapio(@RequestBody CardapioDTO cardapioDTO) {
		Cardapio cardapioAtualizado = cardapioService.salvaCardapio(cardapioDTO);
		cardapioAtualizado.setRestaurante(restauranteService.listaRestauranteID(cardapioAtualizado.getRestaurante().getIdrestaurante()).get());
		return ResponseEntity.ok(new CardapioDTO(cardapioAtualizado));
	}
}
