package br.com.senai.restaurante.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.restaurante.DTO.UsuarioDTO;

@FeignClient("security")
public interface SecurityClient  {
	
	@PostMapping("/auth/register")
	public void CriarUsuario(UsuarioDTO usuaDto );
	
	
}
