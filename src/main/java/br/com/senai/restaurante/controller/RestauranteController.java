package br.com.senai.restaurante.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.senai.restaurante.DTO.DadosDTO;
import br.com.senai.restaurante.DTO.RestauranteDTO;
import br.com.senai.restaurante.client.SecurityClient;
import br.com.senai.restaurante.model.Restaurante;
import br.com.senai.restaurante.service.RestauranteService;

@RestController

@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	private SecurityClient securityClient;
	
	@Autowired
	private RestauranteService restauranteService;

	@PostMapping
	public ResponseEntity<RestauranteDTO> criaRestaurante(@RequestBody DadosDTO dadosDTO) {
		Long idusuario = securityClient.CriarUsuario(dadosDTO.getUsuarioDTO());
		Restaurante restaurante = restauranteService.salvaRestaurante(dadosDTO.getRestauranteDTO(), idusuario);
		
		return ResponseEntity.ok(new RestauranteDTO(restaurante));
	}
	
	@GetMapping("/idusuario/{id}")
	public ResponseEntity<RestauranteDTO> getRestaurantePorId(@PathVariable Long id){
		Optional<Restaurante>RestauranteID =  restauranteService.RestaurantePorId(id);
		return ResponseEntity.ok(RestauranteID.map(RestauranteDTO::new).orElse(null));
	}
	
	
	@GetMapping
	public ResponseEntity<List<RestauranteDTO>> listaRestaurante() {
		List<Restaurante> restaurante = restauranteService.listaRestaurante();
		List<RestauranteDTO> restauranteDTO = restaurante.stream().map(RestauranteDTO::new).toList();
		return ResponseEntity.ok(restauranteDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RestauranteDTO> listaRestauranteID(Integer id) {
		Optional<Restaurante> restaurante = restauranteService.listaRestauranteID(id);
		Optional<RestauranteDTO> restauranteDTO = restaurante.map(RestauranteDTO::new);
		return ResponseEntity.ok(restauranteDTO.orElse(null));
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
