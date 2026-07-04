package mx.com.misterjob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.misterjob.dto.RecetasCategoriasDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.repository.RecetasCategoriasRepository;
import mx.com.misterjob.service.CategoriasService;
import mx.com.misterjob.service.RecetasCategoriasService;
import mx.com.misterjob.service.RecetasService;

@Service
public class RecetasCategoriasServiceImpl implements RecetasCategoriasService {
	@Autowired
	private RecetasCategoriasRepository recetasCategoriasRepository;
	@Autowired
	private RecetasService recetasService;
	@Autowired
	private CategoriasService categoriasService;
	
	public ResponseDto getRecetasCategoriasByIdReceta(Integer idReceta) {
		ResponseDto response = new ResponseDto();
		
		validateId(idReceta, response);
		
		if (response.getCode() == null) {
			try {
				List<RecetasCategoriasDto> recetasCategorias = recetasCategoriasRepository.getRecetasCategoriasByIdReceta(idReceta);
				
				if(recetasCategorias != null && !recetasCategorias.isEmpty()) {
					response.setCode(1);
					response.addMessage("Registros de recetas-categorias obtenidos");
					response.setContent(recetasCategorias);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron recetas-categorias");
				}
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las recetas-categorias, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto getRecetasCategoriasByIdCategoria(Integer idCategoria) {
		ResponseDto response = new ResponseDto();
		
		validateId(idCategoria, response);
		
		if (response.getCode() == null) {
			try {
				List<RecetasCategoriasDto> recetasCategorias = recetasCategoriasRepository.getRecetasCategoriasByIdCategoria(idCategoria);
				
				if(recetasCategorias != null && !recetasCategorias.isEmpty()) {
					response.setCode(1);
					response.addMessage("Registros de recetas-categorias obtenidos");
					response.setContent(recetasCategorias);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron recetas-categorias");
				}
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las recetas-categorias, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto getRecetaCategoria(Integer idReceta, Integer idCategoria) {
		ResponseDto response = new ResponseDto();
		
		validateId(idReceta, response);
		validateId(idCategoria, response);
		
		if (response.getCode() == null) {
			try {
				RecetasCategoriasDto recetaCategoria = recetasCategoriasRepository.getRecetaCategoria(idReceta, idCategoria);
				
				if(recetaCategoria != null) {
					response.setCode(1);
					response.addMessage("Registros de receta-categoria obtenido");
					response.setContent(recetaCategoria);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron recetas-categorias");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("La receta-categoria con las IDs dada no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las recetas-categorias, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto insertRecetaCategoria(RecetasCategoriasDto recetaCategoria) {
		ResponseDto response = new ResponseDto();
		
		validateRecetaCategoriaFields(recetaCategoria, response, validateId(recetaCategoria.getIdRecipe(), response), validateId(recetaCategoria.getIdCategory(), response));
	
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = recetasCategoriasRepository.insertRecetaCategoria(recetaCategoria);
		        
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
				response.addMessage("Error al insertar las recetas-categorias, verifique");
			}
		}

		return response;
	}

	public ResponseDto deleteRecetasCategoriasByIdReceta(Integer idReceta) {
		ResponseDto response = new ResponseDto();
		
		if (validateId(idReceta, response) == 1) {
			validateRecetaExistenceInTable(idReceta, response);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = recetasCategoriasRepository.deleteRecetasCategoriasByIdReceta(idReceta);
		        
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
				response.addMessage("Error al borrar las recetas-categorias, verifique");
			}
		}

		return response;
	}

	public ResponseDto deleteRecetaCategoria(Integer idReceta, Integer idCategoria) {
		ResponseDto response = new ResponseDto();
		
		if (validateId(idReceta, response) == 1 && validateId(idCategoria, response) == 1) {
			validateRecetaCategoriaExistence(idReceta, idCategoria, response);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = recetasCategoriasRepository.deleteRecetaCategoria(idReceta, idCategoria);
		        
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
				response.addMessage("Error al borrar las recetas-categorias, verifique");
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
	
	private void validateRecetaCategoriaFields(RecetasCategoriasDto recetaCategoria, ResponseDto response, int validIdRecipe, int validIdCategory) {
		if (recetaCategoria.getCreatedAt() == null) {
			response.setCode(-9);
			response.addMessage("La fecha y hora de creacion no debe ser nulo.");
		}
		if (recetaCategoria.getUpdatedAt() == null) {
			response.setCode(-11);
			response.addMessage("La fecha y hora de actualizacion no debe ser nulo.");
		}
		if (validIdRecipe == 1 && recetasService.getRecetaById(recetaCategoria.getIdRecipe(), false).getCode() <= 0) {
			response.setCode(-14);
			response.addMessage("La receta con la ID dada no existe o esta desactivado, no se puede insertar si no existe o esta desactivado.");
		}
		if (validIdCategory == 1 && categoriasService.getCategoriaById(recetaCategoria.getIdCategory(), false).getCode() <= 0) {
			response.setCode(-14);
			response.addMessage("La categoria con la ID dada no existe o esta desactivado, no se puede insertar si no existe o esta desactivado.");
		}
	}
	
	private void validateRecetaExistenceInTable(Integer id, ResponseDto response) {
		if (getRecetasCategoriasByIdReceta(id).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("La receta con la ID dada no existe en recetas-categorias, verifique que la receta exista y este activo tambien, no se puede borrar si no existen o estan desactivados.");
		}
	}
	
	private void validateRecetaCategoriaExistence(Integer idR, Integer idC, ResponseDto response) {
		if (getRecetaCategoria(idR, idC).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("La receta-categoria con las IDs dadas no existe, verifique que la categoria y la receta con las IDs correspondientes existan y esten activos tambien, no se puede borrar si no existen.");
		}
	}
}
