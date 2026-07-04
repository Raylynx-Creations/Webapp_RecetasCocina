package mx.com.misterjob.service;

import mx.com.misterjob.dto.RecetasDto;
import mx.com.misterjob.dto.ResponseDto;

public interface RecetasService {
	public ResponseDto getRecetas();
	public ResponseDto getRecetaById(Integer idReceta, Boolean update);
	public ResponseDto insertReceta(RecetasDto receta);
	public ResponseDto updateReceta(RecetasDto receta);
	public ResponseDto deleteReceta(Integer idReceta);
}
