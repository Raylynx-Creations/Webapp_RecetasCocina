package mx.com.misterjob.service;

import mx.com.misterjob.dto.RecetasIngredientesDto;
import mx.com.misterjob.dto.ResponseDto;

public interface RecetasIngredientesService {
	public ResponseDto getRecetasIngredientesByIdReceta(Integer idReceta);
	public ResponseDto getRecetasIngredientesByIdIngrediente(Integer idIngrediente);
	public ResponseDto getRecetaIngrediente(Integer idReceta, Integer idIngrediente);
	public ResponseDto insertRecetaIngrediente(RecetasIngredientesDto recetaIngrediente);
	public ResponseDto updateRecetaIngrediente(RecetasIngredientesDto recetaIngrediente);
	public ResponseDto deleteRecetasIngredientesByIdReceta(Integer idReceta);
	public ResponseDto deleteRecetaIngrediente(Integer idReceta, Integer idIngrediente);
}
