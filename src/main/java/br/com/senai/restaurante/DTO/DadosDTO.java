package br.com.senai.restaurante.DTO;

public class DadosDTO {

	RestauranteDTO restauranteDTO;
	UsuarioDTO usuarioDTO;

	public DadosDTO() {
	}

	public DadosDTO(RestauranteDTO restauranteDTO, UsuarioDTO usuarioDTO) {
		this.restauranteDTO = restauranteDTO;
		this.usuarioDTO = usuarioDTO;
	}

	public RestauranteDTO getRestauranteDTO() {
		return restauranteDTO;
	}

	public void setRestauranteDTO(RestauranteDTO restauranteDTO) {
		this.restauranteDTO = restauranteDTO;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

}
