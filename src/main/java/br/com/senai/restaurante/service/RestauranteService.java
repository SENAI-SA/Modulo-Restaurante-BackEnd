package br.com.senai.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.restaurante.DTO.RestauranteDTO;
import br.com.senai.restaurante.model.Restaurante;
import br.com.senai.restaurante.repository.RestauranteRepositoy;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepositoy repositoyRestauranteRepositoy;

	public Restaurante salvaRestaurante(RestauranteDTO restauranteDTO) {
		Restaurante restaurante = new Restaurante(restauranteDTO);
		return repositoyRestauranteRepositoy.save(restaurante);
	}

	public List<Restaurante> listaRestaurante() {
		return repositoyRestauranteRepositoy.findAll();
	}

	public void excluirRestaurante(Integer id) {
		repositoyRestauranteRepositoy.deleteById(id);
	}
}
