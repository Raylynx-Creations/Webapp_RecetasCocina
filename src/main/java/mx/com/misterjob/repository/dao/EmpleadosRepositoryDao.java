package mx.com.misterjob.repository.dao;

import java.util.List;

import mx.com.misterjob.entity.UsuariosEntity;

public interface EmpleadosRepositoryDao extends Dao<UsuariosEntity, Integer> {
	public List<UsuariosEntity> getEmpleadosMasculinos();
	public List<UsuariosEntity> getEmpleadosFemeninosEdad35();
	public UsuariosEntity getEmpleadoByRfc(String rfcEmpleado);
}
