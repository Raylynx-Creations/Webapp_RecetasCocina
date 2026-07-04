package mx.com.misterjob.repository;

import java.util.List;

import mx.com.misterjob.dto.RecetasTagsDto;

public interface RecetasTagsRepository {
	public List<RecetasTagsDto> getRecetasTagsByIdReceta(Integer idReceta);
	public List<RecetasTagsDto> getRecetasTagsByIdTag(Integer idTag);
	public RecetasTagsDto getRecetaTag(Integer idReceta, Integer idTag);
	public Integer insertRecetaTag(RecetasTagsDto recetaTag);
	public Integer deleteRecetasTagsByIdReceta(Integer idReceta);
	public Integer deleteRecetaTag(Integer idReceta, Integer idTag);
}
