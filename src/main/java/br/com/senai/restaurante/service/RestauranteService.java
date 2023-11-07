package br.com.senai.restaurante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.restaurante.DTO.RestauranteDTO;
import br.com.senai.restaurante.model.Restaurante;
import br.com.senai.restaurante.repository.RestauranteRepositoy;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepositoy restauranteRepositoy;

	public Restaurante salvaRestaurante(RestauranteDTO restauranteDTO) {
		Restaurante restaurante = new Restaurante(restauranteDTO);
		return restauranteRepositoy.save(restaurante);
	}

	public List<Restaurante> listaRestaurante() {
		return restauranteRepositoy.findAll();
	}

	public void excluirRestaurante(Integer id) {
		restauranteRepositoy.deleteById(id);  
	}
	
	public Optional<Restaurante>  listaRestauranteID(Integer id) {
		return restauranteRepositoy.findById(id);
	}
	
}
