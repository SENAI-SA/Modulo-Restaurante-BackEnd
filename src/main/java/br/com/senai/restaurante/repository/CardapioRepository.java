package br.com.senai.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.restaurante.model.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Integer>{

}
