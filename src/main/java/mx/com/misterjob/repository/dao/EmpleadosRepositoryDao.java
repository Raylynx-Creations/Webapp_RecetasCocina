package mx.com.misterjob.repository.dao;

import java.util.List;

import mx.com.misterjob.entity.EmpleadosEntity;

public interface EmpleadosRepositoryDao extends Dao<EmpleadosEntity, Integer> {
	public List<EmpleadosEntity> getEmpleadosMasculinos();
	public List<EmpleadosEntity> getEmpleadosFemeninosEdad35();
	public EmpleadosEntity getEmpleadoByRfc(String rfcEmpleado);
	public EmpleadosEntity getEmpleadoByNombre(String nombre);
	public EmpleadosEntity getEmpleadoById(Integer id, Boolean activo);
}
