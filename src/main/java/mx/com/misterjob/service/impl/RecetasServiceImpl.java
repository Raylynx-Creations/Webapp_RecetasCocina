package mx.com.misterjob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.misterjob.dto.RecetasDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.repository.RecetasRepository;
import mx.com.misterjob.service.RecetasService;
import mx.com.misterjob.service.UsuariosService;

@Service
public class RecetasServiceImpl implements RecetasService {
	@Autowired
	private RecetasRepository recetasRepository;
	@Autowired
	private UsuariosService usuariosService;
	
	public ResponseDto getRecetas() {
		ResponseDto response = new ResponseDto();
		
		try {
			List<RecetasDto> recetas = recetasRepository.getRecetas();
			
			if(recetas != null && !recetas.isEmpty()) {
				response.setCode(1);
				response.addMessage("Registros de recetas obtenidos");
				response.setContent(recetas);
			}
			else {
				response.setCode(-1);
				response.addMessage("No se obtuvieron recetas");
			}
		}
		catch (NullPointerException nullPointerException) {
			response.setCode(-10);
			response.addMessage("Algún dato viene nulo");
		}
		catch (Exception exception) {
			response.setCode(-100);
			response.addMessage("Error al consultar las recetas, verifique");
		}
		
		return response;
	}

	public ResponseDto getRecetaById(Integer idReceta, Boolean update) {
		ResponseDto response = new ResponseDto();
		
		validateId(idReceta, response);
		
		if (response.getCode() == null) {
			try {
				RecetasDto receta = recetasRepository.getRecetaById(idReceta, update);
				
				if(receta != null) {
					response.setCode(1);
					response.addMessage("Registro de receta obtenido");
					response.setContent(receta);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvo la receta");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("La receta con la ID dada no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar la receta, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto insertReceta(RecetasDto receta) {
		ResponseDto response = new ResponseDto();
		
		validateRecipeFields(receta, response);
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = recetasRepository.insertReceta(receta);
		        
		        if (insertResponse == 1) {
		        	response.setCode(1);
		        	response.addMessage("Se insertó correctamente");
		        } else {
		    		response.setCode(-1);
		    		response.addMessage("No se insertaron registros");
		        }
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("No se pudo insertar por algun valor nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al insertar las recetas, verifique");
			}
		}

		return response;
	}

	public ResponseDto updateReceta(RecetasDto receta) {
		ResponseDto response = new ResponseDto();
		
		int validId = validateId(receta.getIdRecipe(), response);
		validateRecipeFields(receta, response);
		if (validId == 1) {
			validateRecipeExistence(receta.getIdRecipe(), response, true);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer updateResponse = recetasRepository.updateReceta(receta);
		        
		        if (updateResponse == 1) {
		        	response.setCode(1);
		        	response.addMessage("Se actualizó correctamente");
		        } else {
		    		response.setCode(-1);
		    		response.addMessage("No se actualizaron registros");
		        }
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("No se pudo actualizar por algun valor nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al actualizar las recetas, verifique");
			}
		}

		return response;
	}

	public ResponseDto deleteReceta(Integer idReceta) {
		ResponseDto response = new ResponseDto();

		if (validateId(idReceta, response) == 1) {
			validateRecipeExistence(idReceta, response, false);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer deleteResponse = recetasRepository.deleteReceta(idReceta);
		        
		        if (deleteResponse == 1) {
		        	response.setCode(1);
		        	response.addMessage("Se eliminó correctamente");
		        } else {
		    		response.setCode(-1);
		    		response.addMessage("No se eliminaron registros");
		        }
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("No se pudo eliminar por algun valor nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al eliminar las recetas, verifique");
			}
		}

		return response;
	}
	
	//Validaciones
	
	private int validateId(Integer id, ResponseDto response) {
		if (id == null || id < 0 || id > 9999999999L) {
			response.setCode(-2);
			response.addMessage("El ID debe no ser nulo y estar entre 0 y 9,999,999,999.");
			return 0;
		}
		
		return 1;
	}
	
	private void validateRecipeFields(RecetasDto receta, ResponseDto response) {
		int validId = validateId(receta.getIdUser(), response);
		
		if (receta.getTitle() == null || receta.getTitle().length() > 50) {
			response.setCode(-3);
			response.addMessage("El titulo de la receta debe no ser nulo y no tener una longitud mayor a 50 caracteres.");
		}
		if (receta.getDescription() != null && receta.getDescription().length() > 100) {
			response.setCode(-4);
			response.addMessage("La descripcion debe no tener una longitud mayor a 100 caracteres.");
		}
		if (receta.getInstructions() == null || receta.getInstructions().length() > 1000) {
			response.setCode(-5);
			response.addMessage("Las instrucciones de la receta deben no ser nulo y no tener una longitud mayor a 1,000 caracteres.");
		}
		if (receta.getPreparationTimeMinutes() == null || receta.getPreparationTimeMinutes() < 0 || receta.getPreparationTimeMinutes() > 9999) {
			response.setCode(-6);
			response.addMessage("El tiempo de preparacion de la receta no debe ser nulo y estar entre 0 y 9,999 (el equivalente a 166 horas con 39 minutos).");
		}
		if (receta.getCookTimeMinutes() == null || receta.getCookTimeMinutes() < 0 || receta.getCookTimeMinutes() > 9999) {
			response.setCode(-7);
			response.addMessage("El tiempo de cocinado de la receta no debe ser nulo y estar entre 0 y 9,999 (el equivalente a 166 horas con 39 minutos).");
		}
		if (receta.getPortions() == null || receta.getPortions() < 0 || receta.getPortions() > 99) {
			response.setCode(-8);
			response.addMessage("Las porciones de la receta no debe ser nulo y estar entre 0 y 99.");
		}
		if (receta.getDifficulty() == null || receta.getDifficulty() < 0 || receta.getDifficulty() > 9) {
			response.setCode(-12);
			response.addMessage("La dificultad de la receta no debe ser nulo y estar entre 0 y 9.");
		}
		if (receta.getVisibility() != null && (receta.getVisibility() < 0 || receta.getVisibility() > 2)) {
			response.setCode(-14);
			response.addMessage("La visibilidad de la receta debe estar 0, 1 o 2 unicamente.");
		}
		if (receta.getCreatedAt() == null) {
			response.setCode(-9);
			response.addMessage("La fecha y hora de creacion no debe ser nulo.");
		}
		if (receta.getUpdatedAt() == null) {
			response.setCode(-11);
			response.addMessage("La fecha y hora de actualizacion no debe ser nulo.");
		}
		if (receta.getViews() == null || receta.getViews() < 0 || receta.getViews() > 999999999999999999L) {
			response.setCode(-15);
			response.addMessage("Las vistas de la receta no debe ser nulo y estar entre 0 y 999,999,999,999,999,999");
		}
		if (receta.getLikes() == null || receta.getLikes() < 0 || receta.getLikes() > 999999999999999999L) {
			response.setCode(-16);
			response.addMessage("Los likes de la receta no debe ser nulo y estar entre 0 y 999,999,999,999,999,999");
		}
		if (validId == 1 && usuariosService.getUsuarioById(receta.getIdUser(), false).getCode() <= 0) {
			response.setCode(-17);
			response.addMessage("El usuario con la ID dada no existe o esta desactivado, no se puede insertar o actualizar si no existe o esta desactivado.");
		}
		if (receta.isActive() == null) {
			response.setCode(-12);
			response.addMessage("Debes especificar si la receta esta activa o no, 'active' es el campo para ello, no 'isActive'.");
		}
	}
	
	private void validateRecipeExistence(Integer id, ResponseDto response, Boolean update) {
		if (getRecetaById(id, update).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("La receta con la ID dada no existe o esta desactivado, no se puede actualizar o borrar si no existe o esta desactivado.");
		}
	}
}
