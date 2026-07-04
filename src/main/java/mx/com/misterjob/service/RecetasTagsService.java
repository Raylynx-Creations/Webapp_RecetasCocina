package mx.com.misterjob.service;

import mx.com.misterjob.dto.RecetasTagsDto;
import mx.com.misterjob.dto.ResponseDto;

public interface RecetasTagsService {
	public ResponseDto getRecetasTagsByIdReceta(Integer idReceta);
	public ResponseDto getRecetasTagsByIdTag(Integer idTag);
	public ResponseDto getRecetaTag(Integer idReceta, Integer idTag);
	public ResponseDto insertRecetaTag(RecetasTagsDto recetaTag);
	public ResponseDto deleteRecetasTagsByIdReceta(Integer idReceta);
	public ResponseDto deleteRecetaTag(Integer idReceta, Integer idTag);
}
