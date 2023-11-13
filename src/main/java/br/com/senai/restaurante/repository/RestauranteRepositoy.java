package br.com.senai.restaurante.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.restaurante.model.Restaurante;

public interface RestauranteRepositoy extends JpaRepository<Restaurante, Integer> {

	Optional<Restaurante> findByIdusuario(Long id);
}
