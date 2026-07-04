package mx.com.misterjob.service;

import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.dto.UsuariosDto;

public interface UsuariosService {
	public ResponseDto getUsuarios();
	public ResponseDto getUsuarioById(Integer idUsuario, Boolean update);
	public ResponseDto getUsuarioByUsername(String usernameUsuario, Integer idUsuario);
	public ResponseDto getUsuarioByEmail(String emailUsuario, Integer idUsuario);
	public ResponseDto insertUsuario(UsuariosDto usuario);
	public ResponseDto updateUsuario(UsuariosDto usuario);
	public ResponseDto deleteUsuario(Integer idUsuario);
}
