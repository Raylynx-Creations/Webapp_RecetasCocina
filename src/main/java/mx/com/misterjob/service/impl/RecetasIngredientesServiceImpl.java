package mx.com.misterjob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.misterjob.dto.RecetasIngredientesDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.repository.RecetasIngredientesRepository;
import mx.com.misterjob.service.IngredientesService;
import mx.com.misterjob.service.RecetasIngredientesService;
import mx.com.misterjob.service.RecetasService;

@Service
public class RecetasIngredientesServiceImpl implements RecetasIngredientesService {
	@Autowired
	private RecetasIngredientesRepository recetasIngredientesRepository;
	@Autowired
	private RecetasService recetasService;
	@Autowired
	private IngredientesService ingredientesService;
	
	public ResponseDto getRecetasIngredientesByIdReceta(Integer idReceta) {
		ResponseDto response = new ResponseDto();
		
		validateId(idReceta, response);
		
		if (response.getCode() == null) {
			try {
				List<RecetasIngredientesDto> recetasIngredientes = recetasIngredientesRepository.getRecetasIngredientesByIdReceta(idReceta);
				
				if(recetasIngredientes != null && !recetasIngredientes.isEmpty()) {
					response.setCode(1);
					response.addMessage("Registros de recetas-ingredientes obtenidos");
					response.setContent(recetasIngredientes);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron recetas-ingredientes");
				}
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las recetas-ingredientes, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto getRecetasIngredientesByIdIngrediente(Integer idIngrediente) {
		ResponseDto response = new ResponseDto();
		
		validateId(idIngrediente, response);
		
		if (response.getCode() == null) {
			try {
				List<RecetasIngredientesDto> recetasIngredientes = recetasIngredientesRepository.getRecetasIngredientesByIdIngrediente(idIngrediente);
				
				if(recetasIngredientes != null && !recetasIngredientes.isEmpty()) {
					response.setCode(1);
					response.addMessage("Registros de recetas-ingredientes obtenidos");
					response.setContent(recetasIngredientes);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron recetas-ingredientes");
				}
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las recetas-ingredientes, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto getRecetaIngrediente(Integer idReceta, Integer idIngrediente) {
		ResponseDto response = new ResponseDto();
		
		validateId(idReceta, response);
		validateId(idIngrediente, response);
		
		if (response.getCode() == null) {
			try {
				RecetasIngredientesDto recetaIngrediente = recetasIngredientesRepository.getRecetaIngrediente(idReceta, idIngrediente);
				
				if(recetaIngrediente != null) {
					response.setCode(1);
					response.addMessage("Registro de receta-ingrediente obtenido");
					response.setContent(recetaIngrediente);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron recetas-ingredientes");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("La receta-ingrediente con las IDs dada no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las recetas-ingredientes, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto insertRecetaIngrediente(RecetasIngredientesDto recetaIngrediente) {
		ResponseDto response = new ResponseDto();
		
		validateRecetaIngredienteFields(recetaIngrediente, response, validateId(recetaIngrediente.getIdRecipe(), response), validateId(recetaIngrediente.getIdIngredient(), response));
		
		try {
	        Integer insertResponse = recetasIngredientesRepository.insertRecetaIngrediente(recetaIngrediente);
	        
	        if(insertResponse == 1) {
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
			response.addMessage("Error al insertar las recetas-ingredientes, verifique");
		}

		return response;
	}

	public ResponseDto updateRecetaIngrediente(RecetasIngredientesDto recetaIngrediente) {
		ResponseDto response = new ResponseDto();
		
		int validIdRecipe = validateId(recetaIngrediente.getIdRecipe(), response);
		int validIdIngredient = validateId(recetaIngrediente.getIdIngredient(), response);
		validateRecetaIngredienteFields(recetaIngrediente, response, validIdRecipe, validIdIngredient);
		if (validIdRecipe == 1 && validIdIngredient == 1) {
			validateRecetaIngredienteExistence(recetaIngrediente.getIdRecipe(), recetaIngrediente.getIdIngredient(), response);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = recetasIngredientesRepository.updateRecetaIngrediente(recetaIngrediente);
		        
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
				response.addMessage("Error al actualizar las recetas-ingredientes, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto deleteRecetasIngredientesByIdReceta(Integer idReceta) {
		ResponseDto response = new ResponseDto();
		
		if (validateId(idReceta, response) == 1) {
			validateRecetaExistenceInTable(idReceta, response);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = recetasIngredientesRepository.deleteRecetasIngredientesByIdReceta(idReceta);
		        
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
				response.addMessage("Error al borrar las recetas-ingredientes, verifique");
			}
		}

		return response;
	}

	public ResponseDto deleteRecetaIngrediente(Integer idReceta, Integer idIngrediente) {
		ResponseDto response = new ResponseDto();
		
		if (validateId(idReceta, response) == 1 && validateId(idIngrediente, response) == 1) {
			validateRecetaIngredienteExistence(idReceta, idIngrediente, response);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = recetasIngredientesRepository.deleteRecetaIngrediente(idReceta, idIngrediente);
		        
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
				response.addMessage("Error al borrar las recetas-ingredientes, verifique");
			}
		}

		return response;
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
	
	private void validateRecetaIngredienteFields(RecetasIngredientesDto recetaIngrediente, ResponseDto response, int validIdRecipe, int validIdIngredient) {
		if (recetaIngrediente.getQuantity() == null || recetaIngrediente.getQuantity() < 0 || recetaIngrediente.getQuantity() > 99) {
			response.setCode(-3);
			response.addMessage("La cantidad no debe ser nula y debe estar entre 0 y 99.");
		}
		if (recetaIngrediente.getUnit() == null || recetaIngrediente.getUnit().length() > 20) {
			response.setCode(-4);
			response.addMessage("La unidad de medida no debe ser nula y no debe ser de mas de 20 caracteres.");
		}
		if (recetaIngrediente.getNotes() != null && recetaIngrediente.getNotes().length() > 100) {
			response.setCode(-5);
			response.addMessage("Las notas no deben ser de mas de 100 caracteres.");
		}
		if (recetaIngrediente.getCreatedAt() == null) {
			response.setCode(-9);
			response.addMessage("La fecha y hora de creacion no debe ser nulo.");
		}
		if (recetaIngrediente.getUpdatedAt() == null) {
			response.setCode(-11);
			response.addMessage("La fecha y hora de actualizacion no debe ser nulo.");
		}
		if (validIdRecipe == 1 && recetasService.getRecetaById(recetaIngrediente.getIdRecipe(), false).getCode() <= 0) {
			response.setCode(-14);
			response.addMessage("La receta con la ID dada no existe o esta desactivado, no se puede insertar si no existe o esta desactivado.");
		}
		if (validIdIngredient == 1 && ingredientesService.getIngredienteById(recetaIngrediente.getIdIngredient(), false).getCode() <= 0) {
			response.setCode(-14);
			response.addMessage("El ingrediente con la ID dada no existe o esta desactivado, no se puede insertar si no existe o esta desactivado.");
		}
	}
	
	private void validateRecetaExistenceInTable(Integer id, ResponseDto response) {
		if (getRecetasIngredientesByIdReceta(id).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("La receta con la ID dada no existe en recetas-ingredientes, verifique que la receta exista y este activo tambien, no se puede borrar si no existen o estan desactivados.");
		}
	}
	
	private void validateRecetaIngredienteExistence(Integer idR, Integer idI, ResponseDto response) {
		if (getRecetaIngrediente(idR, idI).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("La receta-ingredientes con las IDs dadas no existe, verifique que el ingrediente y la receta con las IDs correspondientes existan y esten activos tambien, no se puede borrar si no existen o estan desactivados.");
		}
	}
}
