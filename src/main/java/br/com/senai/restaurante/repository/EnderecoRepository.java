package br.com.senai.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.restaurante.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
