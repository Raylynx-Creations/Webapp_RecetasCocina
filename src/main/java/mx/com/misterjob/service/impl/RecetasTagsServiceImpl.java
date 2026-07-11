package mx.com.misterjob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.misterjob.dto.RecetasTagsDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.entity.RecetasTagsEntity;
import mx.com.misterjob.entity.compoundIds.RecetasTagsId;
import mx.com.misterjob.repository.dao.RecetasTagsRepositoryDao;
import mx.com.misterjob.service.RecetasService;
import mx.com.misterjob.service.RecetasTagsService;
import mx.com.misterjob.service.TagsService;

@Service
public class RecetasTagsServiceImpl implements RecetasTagsService {
	@Autowired
	private RecetasTagsRepositoryDao recetasTagsRepositoryDao;
	@Autowired
	private TagsService tagsService;
	@Autowired
	private RecetasService recetasService;
	
	public ResponseDto getRecetasTagsByIdReceta(Integer idReceta) {
		ResponseDto response = new ResponseDto();
		
		validateId(idReceta, response);
		
		if (response.getCode() == null) {
			try {
				List<RecetasTagsEntity> recetasTags = recetasTagsRepositoryDao.getRecetasTagsByIdReceta(idReceta);
				
				if(recetasTags != null && !recetasTags.isEmpty()) {
					response.setCode(1);
					response.addMessage("Registros de recetas-tags obtenidos");
					response.setContent(recetasTags);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron recetas-tags");
				}
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las recetas-tags, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto getRecetasTagsByIdTag(Integer idTag) {
		ResponseDto response = new ResponseDto();
		
		validateId(idTag, response);
		
		if (response.getCode() == null) {
			try {
				List<RecetasTagsEntity> recetasTags = recetasTagsRepositoryDao.getRecetasTagsByIdTag(idTag);
				
				if(recetasTags != null && !recetasTags.isEmpty()) {
					response.setCode(1);
					response.addMessage("Registros de recetas-tags obtenidos");
					response.setContent(recetasTags);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron recetas-tags");
				}
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las recetas-tags, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto getRecetaTag(Integer idReceta, Integer idTag) {
		ResponseDto response = new ResponseDto();
		
		validateId(idReceta, response);
		validateId(idTag, response);
		
		if (response.getCode() == null) {
			try {
				RecetasTagsId id = new RecetasTagsId(idReceta, idTag);
				RecetasTagsEntity recetaTag = recetasTagsRepositoryDao.read(id);
				
				if(recetaTag != null) {
					response.setCode(1);
					response.addMessage("Registros de receta-tag obtenido");
					response.setContent(recetaTag);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvo receta-tag");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("La receta-tag con las IDs dada no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las recetas-tags, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto insertRecetaTag(RecetasTagsDto recetaTag) {
		ResponseDto response = new ResponseDto();
		
		validateRecetaTagFields(recetaTag, response, validateId(recetaTag.getIdRecipe(), response), validateId(recetaTag.getIdTag(), response));
		
		if (response.getCode() == null) {
			try {
				RecetasTagsEntity recetaTagEntidad = recetaTagDtoToEntity(recetaTag);
				
		        recetasTagsRepositoryDao.create(recetaTagEntidad);
		        response.setCode(1);
		        response.addMessage("Se insertó correctamente");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("No se pudo insertar por algun valor nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al insertar las recetas-tags, verifique");
			}
		}

		return response;
	}

	public ResponseDto deleteRecetasTagsByIdReceta(Integer idReceta) {
		ResponseDto response = new ResponseDto();
		
		if (validateId(idReceta, response) == 1) {
			validateRecetaExistenceInTable(idReceta, response);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = recetasTagsRepositoryDao.deleteRecetasTagsByIdReceta(idReceta);
		        
		        if (insertResponse > 0) {
		        	response.setCode(1);
		        	response.addMessage("Se borró correctamente");
		        } else {
		    		response.setCode(-1);
		    		response.addMessage("No se borraron registros");
		        }
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("No se pudo borrar por algun valor nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al borrar las recetas-tags, verifique");
			}
		}

		return response;
	}

	public ResponseDto deleteRecetaTag(Integer idReceta, Integer idTag) {
		ResponseDto response = new ResponseDto();
		
		if (validateId(idReceta, response) == 1 && validateId(idTag, response) == 1) {
			validateRecetaTagExistence(idReceta, idTag, response);
		}
		
		if (response.getCode() == null) {
			try {
				RecetasTagsId id = new RecetasTagsId(idReceta, idTag);
				
		        recetasTagsRepositoryDao.delete(id);
		        response.setCode(1);
		        response.addMessage("Se borró correctamente");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("No se pudo borrar por algun valor nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al borrar las recetas-tags, verifique");
			}
		}

		return response;
	}

	//Mapper
	
	private RecetasTagsEntity recetaTagDtoToEntity(RecetasTagsDto recetaTag) {
		RecetasTagsEntity recetaTagEntidad = new RecetasTagsEntity();
		recetaTagEntidad.setIdRecipe(recetaTag.getIdRecipe());
		recetaTagEntidad.setIdTag(recetaTag.getIdTag());
		recetaTagEntidad.setCreatedAt(recetaTag.getCreatedAt());
		recetaTagEntidad.setUpdatedAt(recetaTag.getUpdatedAt());
		
		return recetaTagEntidad;
	}

	//Validaciones
	
	private int validateId(Integer id, ResponseDto response) {
		if (id == null || id < 0 || id > 9999999999L) {
			response.setCode(-2);
			response.addMessage("El/Los ID(s) no deben ser nulo y estar entre 0 y 9,999,999,999.");
			return 0;
		}
		
		return 1;
	}
	
	private void validateRecetaTagFields(RecetasTagsDto recetaTag, ResponseDto response, int validIdRecipe, int validIdTag) {
		if (recetaTag.getCreatedAt() == null) {
			response.setCode(-9);
			response.addMessage("La fecha y hora de creacion no debe ser nulo.");
		}
		if (recetaTag.getUpdatedAt() == null) {
			response.setCode(-11);
			response.addMessage("La fecha y hora de actualizacion no debe ser nulo.");
		}
		if (validIdRecipe == 1 && recetasService.getRecetaById(recetaTag.getIdRecipe(), false).getCode() <= 0) {
			response.setCode(-14);
			response.addMessage("La receta con la ID dada no existe o esta desactivado, no se puede insertar si no existe.");
		}
		if (validIdTag == 1 && tagsService.getTagById(recetaTag.getIdTag(), false).getCode() <= 0) {
			response.setCode(-14);
			response.addMessage("El tag con la ID dada no existe o esta desactivado, no se puede insertar si no existe.");
		}
	}
	
	private void validateRecetaExistenceInTable(Integer id, ResponseDto response) {
		if (getRecetasTagsByIdReceta(id).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("La receta con la ID dada no existe en recetas-tags, verifique que la receta exista y este activa tambien, no se puede borrar si no existen o esta desactivado.");
		}
	}
	
	private void validateRecetaTagExistence(Integer idR, Integer idT, ResponseDto response) {
		if (getRecetaTag(idR, idT).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("La receta-tag con las IDs dadas no existe, verifique que el tag y la receta con las IDs correspondientes existan y esten activos tambien, no se puede borrar si no existen o estan desactivados.");
		}
	}
}
