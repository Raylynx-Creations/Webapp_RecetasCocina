package mx.com.misterjob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.misterjob.dto.IngredientesDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.repository.IngredientesRepository;
import mx.com.misterjob.service.IngredientesService;

@Service
public class IngredientesServiceImpl implements IngredientesService {
	@Autowired
	private IngredientesRepository ingredientesRepository;
	
	public ResponseDto getIngredientes() {
		ResponseDto response = new ResponseDto();
		
		try {
			List<IngredientesDto> ingredientes = ingredientesRepository.getIngredientes();
			
			if(ingredientes != null && !ingredientes.isEmpty()) {
				response.setCode(1);
				response.addMessage("Registros de ingredientes obtenidos");
				response.setContent(ingredientes);
			}
			else {
				response.setCode(-1);
				response.addMessage("No se obtuvieron ingredientes");
			}
		}
		catch (NullPointerException nullPointerException) {
			response.setCode(-10);
			response.addMessage("Algún dato viene nulo");
		}
		catch (Exception exception) {
			response.setCode(-100);
			response.addMessage("Error al consultar los ingredientes, verifique");
		}
		
		return response;
	}

	public ResponseDto getIngredienteById(Integer idIngrediente, Boolean update) {
		ResponseDto response = new ResponseDto();
		
		validateIdIngrediente(idIngrediente, response);
		
		if (response.getCode() == null) {
			try {
				IngredientesDto ingrediente = ingredientesRepository.getIngredienteById(idIngrediente, update);
				
				if(ingrediente != null) {
					response.setCode(1);
					response.addMessage("Registros de ingrediente obtenido");
					response.setContent(ingrediente);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron ingredientes");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("El ingrediente con la ID dada no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar los ingredientes, verifique");
			}
		}
		
		return response;
	}
	
	public ResponseDto getIngredienteByName(String nameIngrediente, Integer idIngrediente) {
		ResponseDto response = new ResponseDto();
		
		validateName(nameIngrediente, response);
		
		if (response.getCode() == null) {
			try {
				IngredientesDto ingrediente = ingredientesRepository.getIngredienteByName(nameIngrediente, idIngrediente);
				
				if(ingrediente != null) {
					response.setCode(1);
					response.addMessage("Registros de ingrediente obtenido");
					response.setContent(ingrediente);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron ingredientes");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("El ingrediente con el nombre dado no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar los ingredientes, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto insertIngrediente(IngredientesDto ingrediente) {
		ResponseDto response = new ResponseDto();
		
		validateIngredienteFields(ingrediente, response, null);
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = ingredientesRepository.insertIngrediente(ingrediente);
		        
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
				response.addMessage("Error al insertar los ingredientes, verifique");
			}
		}

		return response;
	}

	public ResponseDto updateIngrediente(IngredientesDto ingrediente) {
		ResponseDto response = new ResponseDto();
		
		int validId = validateIdIngrediente(ingrediente.getIdIngredient(), response);
		validateIngredienteFields(ingrediente, response, ingrediente.getIdIngredient());
		if (validId == 1) {
			validateIngredienteExistence(ingrediente.getIdIngredient(), response, true);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = ingredientesRepository.updateIngrediente(ingrediente);
		        
		        if (insertResponse == 1) {
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
				response.addMessage("Error al actualizar los ingredientes, verifique");
			}
		}

		return response;
	}

	public ResponseDto deleteIngrediente(Integer idIngrediente) {
		ResponseDto response = new ResponseDto();
		
		if (validateIdIngrediente(idIngrediente, response) == 1) {
			validateIngredienteExistence(idIngrediente, response, false);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = ingredientesRepository.deleteIngrediente(idIngrediente);
		        
		        if (insertResponse == 1) {
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
				response.addMessage("Error al borrar los ingredientes, verifique");
			}
		}

		return response;
	}

	//Validaciones
	
	private int validateIdIngrediente(Integer id, ResponseDto response) {
		if (id == null || id < 0 || id > 9999999999L) {
			response.setCode(-2);
			response.addMessage("El ID debe no ser nulo y estar entre 0 y 9,999,999,999.");
			return 0;
		}
		
		return 1;
	}
	
	private int validateName(String name, ResponseDto response) {
		if (name == null || name.length() > 50) {
			response.setCode(-3);
			response.addMessage("El nombre del ingrediente debe no ser nulo y no tener una longitud mayor a 50 caracteres.");
			return 0;
		}
		
		return 1;
	}
	
	private void validateIngredienteFields(IngredientesDto ingrediente, ResponseDto response, Integer idIngrediente) {
		if (validateName(ingrediente.getName(), response) == 1 && getIngredienteByName(ingrediente.getName(), idIngrediente).getCode() > 0) {
			response.setCode(-14);
			response.addMessage("El nombre del ingrediente ya se encuentra en uso, debes escoger otro nombre diferente.");
		}
		if (ingrediente.getCreatedAt() == null) {
			response.setCode(-9);
			response.addMessage("La fecha y hora de creacion no debe ser nulo.");
		}
		if (ingrediente.getUpdatedAt() == null) {
			response.setCode(-11);
			response.addMessage("La fecha y hora de actualizacion no debe ser nulo.");
		}
		if (ingrediente.isActive() == null) {
			response.setCode(-12);
			response.addMessage("Debes especificar si el ingrediente esta activo o no, 'active' es el campo para ello, no 'isActive'.");
		}
	}
	
	private void validateIngredienteExistence(Integer id, ResponseDto response, Boolean update) {
		if (getIngredienteById(id, update).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("El ingrediente con la ID dada no existe o esta desactivado, no se puede actualizar o borrar si no existe o esta desactivado.");
		}
	}
}
