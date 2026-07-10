package mx.com.misterjob.repository.dao;

import java.util.List;

import mx.com.misterjob.entity.UsuariosEntity;

public interface UsuariosRepositoryDao extends Dao<UsuariosEntity, Integer> {
	public List<UsuariosEntity> getUsuarios();
	public UsuariosEntity getUsuarioById(Integer idUsuario, Boolean update);
	public UsuariosEntity getUsuarioByUsername(String usernameUsuario, Integer idUsuario);
	public UsuariosEntity getUsuarioByEmail(String emailUsuario, Integer idUsuario);
}
