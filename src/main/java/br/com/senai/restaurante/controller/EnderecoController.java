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
import br.com.senai.restaurante.DTO.EnderecoDTO;
import br.com.senai.restaurante.model.Endereco;
import br.com.senai.restaurante.service.EnderecoService;

@RestController

@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@PostMapping
	public ResponseEntity<EnderecoDTO> criaEndereco(@RequestBody EnderecoDTO enderecoDTO) {
		Endereco endereco = enderecoService.salvaEndereco(enderecoDTO);
		return ResponseEntity.ok(new EnderecoDTO(endereco));
	}

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> listaEndereco() {
		List<Endereco> endereco = enderecoService.listaEndereco();
		List<EnderecoDTO> enderecoDTO = endereco.stream().map(EnderecoDTO::new).toList();
		return ResponseEntity.ok(enderecoDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirEndereco(@PathVariable Integer id) {
		enderecoService.excluirEndereco(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping
	public ResponseEntity<EnderecoDTO> atualizaEndereco(@RequestBody EnderecoDTO enderecoDTO) {
		Endereco enderecoAtualizado = enderecoService.salvaEndereco(enderecoDTO);
		return ResponseEntity.ok(new EnderecoDTO(enderecoAtualizado));
	}

}
