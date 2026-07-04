package mx.com.misterjob.service;

import mx.com.misterjob.dto.IngredientesDto;
import mx.com.misterjob.dto.ResponseDto;

public interface IngredientesService {
	public ResponseDto getIngredientes();
	public ResponseDto getIngredienteById(Integer idIngrediente, Boolean update);
	public ResponseDto getIngredienteByName(String nameIngrediente, Integer idIngrediente);
	public ResponseDto insertIngrediente(IngredientesDto ingrediente);
	public ResponseDto updateIngrediente(IngredientesDto ingrediente);
	public ResponseDto deleteIngrediente(Integer idIngrediente);
}
