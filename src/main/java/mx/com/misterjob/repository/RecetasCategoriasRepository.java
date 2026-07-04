package mx.com.misterjob.repository;

import java.util.List;

import mx.com.misterjob.dto.RecetasCategoriasDto;

public interface RecetasCategoriasRepository {
	public List<RecetasCategoriasDto> getRecetasCategoriasByIdReceta(Integer idReceta);
	public List<RecetasCategoriasDto> getRecetasCategoriasByIdCategoria(Integer idCategoria);
	public RecetasCategoriasDto getRecetaCategoria(Integer idReceta, Integer idCategoria);
	public Integer insertRecetaCategoria(RecetasCategoriasDto recetaCategoria);
	public Integer deleteRecetasCategoriasByIdReceta(Integer idReceta);
	public Integer deleteRecetaCategoria(Integer idReceta, Integer idCategoria);
}
