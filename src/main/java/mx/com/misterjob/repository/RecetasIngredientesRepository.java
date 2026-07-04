package mx.com.misterjob.repository;

import java.util.List;

import mx.com.misterjob.dto.RecetasIngredientesDto;

public interface RecetasIngredientesRepository {
	public List<RecetasIngredientesDto> getRecetasIngredientesByIdReceta(Integer idReceta);
	public List<RecetasIngredientesDto> getRecetasIngredientesByIdIngrediente(Integer idIngrediente);
	public RecetasIngredientesDto getRecetaIngrediente(Integer idReceta, Integer idIngrediente);
	public Integer insertRecetaIngrediente(RecetasIngredientesDto recetaIngrediente);
	public Integer updateRecetaIngrediente(RecetasIngredientesDto recetaIngrediente);
	public Integer deleteRecetasIngredientesByIdReceta(Integer idReceta);
	public Integer deleteRecetaIngrediente(Integer idReceta, Integer idIngrediente);
}
