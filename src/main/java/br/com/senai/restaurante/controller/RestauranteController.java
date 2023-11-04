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
import br.com.senai.restaurante.DTO.RestauranteDTO;
import br.com.senai.restaurante.model.Restaurante;
import br.com.senai.restaurante.service.RestauranteService;

@RestController

@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;

	@PostMapping
	public ResponseEntity<RestauranteDTO> criaRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
		Restaurante restaurante = restauranteService.salvaRestaurante(restauranteDTO);
		return ResponseEntity.ok(new RestauranteDTO(restaurante));
	}

	@GetMapping
	public ResponseEntity<List<RestauranteDTO>> listaRestaurante() {
		List<Restaurante> restaurante = restauranteService.listaRestaurante();
		List<RestauranteDTO> restauranteDTO = restaurante.stream().map(RestauranteDTO::new).toList();
		return ResponseEntity.ok(restauranteDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirRestaurante(@PathVariable Integer id) {
		restauranteService.excluirRestaurante(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping
	public ResponseEntity<RestauranteDTO> atualizaRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
		Restaurante restauranteAtualizado = restauranteService.salvaRestaurante(restauranteDTO);
		return ResponseEntity.ok(new RestauranteDTO(restauranteAtualizado));
	}

}
