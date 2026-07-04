package mx.com.misterjob.service;

import mx.com.misterjob.dto.RecetasCategoriasDto;
import mx.com.misterjob.dto.ResponseDto;

public interface RecetasCategoriasService {
	public ResponseDto getRecetasCategoriasByIdReceta(Integer idReceta);
	public ResponseDto getRecetasCategoriasByIdCategoria(Integer idCategoria);
	public ResponseDto getRecetaCategoria(Integer idReceta, Integer idCategoria);
	public ResponseDto insertRecetaCategoria(RecetasCategoriasDto recetaCategoria);
	public ResponseDto deleteRecetasCategoriasByIdReceta(Integer idReceta);
	public ResponseDto deleteRecetaCategoria(Integer idReceta, Integer idCategoria);
}
