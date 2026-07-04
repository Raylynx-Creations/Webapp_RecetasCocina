package mx.com.misterjob.repository;

import java.util.List;

import mx.com.misterjob.dto.UsuariosDto;

public interface UsuariosRepository {
	public List<UsuariosDto> getUsuarios();
	public UsuariosDto getUsuarioById(Integer idUsuario, Boolean update);
	public UsuariosDto getUsuarioByUsername(String usernameUsuario, Integer idUsuario);
	public UsuariosDto getUsuarioByEmail(String emailUsuario, Integer idUsuario);
	public Integer insertUsuario(UsuariosDto usuario);
	public Integer updateUsuario(UsuariosDto usuario);
	public Integer deleteUsuario(Integer idUsuario);
}
