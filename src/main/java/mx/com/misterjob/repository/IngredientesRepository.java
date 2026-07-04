package mx.com.misterjob.repository;

import java.util.List;

import mx.com.misterjob.dto.IngredientesDto;

public interface IngredientesRepository {
	public List<IngredientesDto> getIngredientes();
	public IngredientesDto getIngredienteById(Integer idIngrediente, Boolean update);
	public IngredientesDto getIngredienteByName(String nameIngrediente, Integer idIngrediente);
	public Integer insertIngrediente(IngredientesDto ingrediente);
	public Integer updateIngrediente(IngredientesDto ingrediente);
	public Integer deleteIngrediente(Integer idIngrediente);
}
