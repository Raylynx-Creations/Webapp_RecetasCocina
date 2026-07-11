package mx.com.misterjob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.dto.TagsDto;
import mx.com.misterjob.entity.TagsEntity;
import mx.com.misterjob.repository.dao.TagsRepositoryDao;
import mx.com.misterjob.service.TagsService;

@Service
public class TagsServiceImpl implements TagsService {
	@Autowired
	private TagsRepositoryDao tagsRepositoryDao;
	
	public ResponseDto getTags() {
		ResponseDto response = new ResponseDto();
		
		try {
			List<TagsEntity> tags = tagsRepositoryDao.getTags();
			
			if(tags != null && !tags.isEmpty()) {
				response.setCode(1);
				response.addMessage("Registros de tags obtenidos");
				response.setContent(tags);
			}
			else {
				response.setCode(-1);
				response.addMessage("No se obtuvieron tags");
			}
		}
		catch (NullPointerException nullPointerException) {
			response.setCode(-10);
			response.addMessage("Algún dato viene nulo");
		}
		catch (Exception exception) {
			response.setCode(-100);
			response.addMessage("Error al consultar los tags, verifique");
		}
		
		return response;
	}

	public ResponseDto getTagById(Integer idTag, Boolean update) {
		ResponseDto response = new ResponseDto();
		
		validateIdTag(idTag, response);
		
		if (response.getCode() == null) {
			try {
				TagsEntity tags = tagsRepositoryDao.getTagById(idTag, update);
				
				if(tags != null) {
					response.setCode(1);
					response.addMessage("Registro de tag obtenido");
					response.setContent(tags);
				} else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron tags");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("El tag con la ID dada no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar los tags, verifique");
			}
		}
		
		return response;
	}
	
	public ResponseDto getTagByName(String nameTag, Integer idUsuario) {
		ResponseDto response = new ResponseDto();
		
		validateName(nameTag, response);
		
		if (response.getCode() == null) {
			try {
				TagsEntity tag = tagsRepositoryDao.getTagByName(nameTag, idUsuario);
				
				if(tag != null) {
					response.setCode(1);
					response.addMessage("Registro de tag obtenido");
					response.setContent(tag);
				} else {
					response.setCode(-1);
					response.addMessage("No se obtuvo el tag");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("El tag con el nombre de usuario dado no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-20);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar el tag, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto insertTag(TagsDto tag) {
		ResponseDto response = new ResponseDto();

		validateTagFields(tag, response, null);
		
		if (response.getCode() == null) {
			try {
				TagsEntity tagEntidad = tagDtoToEntity(tag);
				
				tagsRepositoryDao.create(tagEntidad);
		        response.setCode(1);
		        response.addMessage("Se insertó correctamente");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("No se pudo insertar por algun valor nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al insertar los tags, verifique");
			}
		}

		return response;
	}

	public ResponseDto updateTag(TagsDto tag) {
		ResponseDto response = new ResponseDto();

		Integer idValido = validateIdTag(tag.getIdTag(), response);
		validateTagFields(tag, response, tag.getIdTag());
		if (idValido == 1) {
			validateTagExistence(tag.getIdTag(), response, true);
		}
		
		if (response.getCode() == null) {
			try {
				TagsEntity tagEntidad = tagDtoToEntity(tag);
				
				tagsRepositoryDao.update(tagEntidad);
		        response.setCode(1);
		        response.addMessage("Se actualizó correctamente");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("No se pudo actualizar por algun valor nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al actualizar los tags, verifique");
			}
		}

		return response;
	}

	public ResponseDto deleteTag(Integer idTag) {
		ResponseDto response = new ResponseDto();
		
		if (validateIdTag(idTag, response) == 1) {
			validateTagExistence(idTag, response, false);
		}
		
		if (response.getCode() == null) {
			try {
				//tagsRepositoryDao.delete(idTag); //Not actual deletition, logical deletition instead
		        TagsEntity tag = tagsRepositoryDao.getTagById(idTag, false);
		        tag.setActive(false);
		        tagsRepositoryDao.update(tag);
		        
		        response.setCode(1);
		        response.addMessage("Se borró correctamente");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("No se pudo borrar por algun valor nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al borrar los tags, verifique");
			}
		}

		return response;
	}

	//Mapper
	
	private TagsEntity tagDtoToEntity(TagsDto tag) {
		TagsEntity tagEntidad = new TagsEntity();
		tagEntidad.setIdTag(tag.getIdTag());
		tagEntidad.setName(tag.getName());
		tagEntidad.setCreatedAt(tag.getCreatedAt());
		tagEntidad.setUpdatedAt(tag.getUpdatedAt());
		tagEntidad.setActive(tag.isActive());
		
		return tagEntidad;
	}

	//Validaciones
	
	private int validateIdTag(Integer id, ResponseDto response) {
		if (id == null || id < 0 || id > 9999999999L) {
			response.setCode(-2);
			response.addMessage("El ID debe no ser nulo y estar entre 0 y 9,999,999,999.");
			return 0;
		}
		
		return 1;
	}
	
	private int validateName(String name, ResponseDto response) {
		if (name == null || name.length() > 30) {
			response.setCode(-3);
			response.addMessage("El nombre del tag debe no ser nulo y no tener una longitud mayor a 30 caracteres.");
			return 0;
		}
		
		return 1;
	}
	
	private void validateTagFields(TagsDto tag, ResponseDto response, Integer idUsuario) {
		if (validateName(tag.getName(), response) == 1 && getTagByName(tag.getName(), idUsuario).getCode() > 0) {
			response.setCode(-14);
			response.addMessage("El nombre del tag ya se encuentra en uso, debes escoger otro nombre diferente.");
		}
		if (tag.getCreatedAt() == null) {
			response.setCode(-9);
			response.addMessage("La fecha y hora de creacion no debe ser nulo.");
		}
		if (tag.getUpdatedAt() == null) {
			response.setCode(-11);
			response.addMessage("La fecha y hora de actualizacion no debe ser nulo.");
		}
		if (tag.isActive() == null) {
			response.setCode(-12);
			response.addMessage("Debes especificar si el tag esta activo o no, 'active' es el campo para ello, no 'isActive'.");
		}
	}
	
	private void validateTagExistence(Integer id, ResponseDto response, Boolean update) {
		if (getTagById(id, update).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("El tag con la ID dada no existe o esta desactivado, no se puede actualizar o borrar si no existe o esta desactivado.");
		}
	}
}
