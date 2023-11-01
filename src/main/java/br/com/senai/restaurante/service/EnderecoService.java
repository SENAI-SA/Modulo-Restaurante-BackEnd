package br.com.senai.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.restaurante.DTO.EnderecoDTO;
import br.com.senai.restaurante.model.Endereco;
import br.com.senai.restaurante.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco salvaEndereco(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco(enderecoDTO);
		return enderecoRepository.save(endereco);
	}

	public List<Endereco> listaEndereco() {
		return enderecoRepository.findAll();
	}

	public void excluirEndereco(Integer id) {
		enderecoRepository.deleteById(id);
	}
}
