package br.com.senai.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.restaurante.model.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Integer>{
	
	
		List<Cardapio> findByRestauranteIdrestaurante(Integer id);

}
