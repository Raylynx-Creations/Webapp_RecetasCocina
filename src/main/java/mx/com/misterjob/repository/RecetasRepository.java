package mx.com.misterjob.repository;

import java.util.List;

import mx.com.misterjob.dto.RecetasDto;

public interface RecetasRepository {
	public List<RecetasDto> getRecetas();
	public RecetasDto getRecetaById(Integer idReceta, Boolean update);
	public Integer insertReceta(RecetasDto receta);
	public Integer updateReceta(RecetasDto receta);
	public Integer deleteReceta(Integer idReceta);
}
