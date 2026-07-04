package mx.com.misterjob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.misterjob.dto.CategoriasDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.repository.CategoriasRepository;
import mx.com.misterjob.service.CategoriasService;

@Service
public class CategoriasServiceImpl implements CategoriasService {
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	public ResponseDto getCategorias() {
		ResponseDto response = new ResponseDto();
		
		try {
			List<CategoriasDto> categorias = categoriasRepository.getCategorias();
			
			if(categorias != null && !categorias.isEmpty()) {
				response.setCode(1);
				response.addMessage("Registros de categorias obtenidos");
				response.setContent(categorias);
			}
			else {
				response.setCode(-1);
				response.addMessage("No se obtuvieron categorias");
			}
		}
		catch (NullPointerException nullPointerException) {
			response.setCode(-10);
			response.addMessage("Algún dato viene nulo");
		}
		catch (Exception exception) {
			response.setCode(-100);
			response.addMessage("Error al consultar las categorias, verifique");
		}
		
		return response;
	}

	public ResponseDto getCategoriaById(Integer idCategoria, Boolean update) {
		ResponseDto response = new ResponseDto();
		
		validateIdCategoria(idCategoria, response);
		
		if (response.getCode() == null) {
			try {
				CategoriasDto categoria = categoriasRepository.getCategoriaById(idCategoria, update);
				
				if(categoria != null) {
					response.setCode(1);
					response.addMessage("Registro de categoria obtenido");
					response.setContent(categoria);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron categorias");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("La categoria con la ID dada no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las categorias, verifique");
			}
		}
		
		return response;
	}
	
	public ResponseDto getCategoriaByName(String nameCategoria, Integer idCategoria) {
		ResponseDto response = new ResponseDto();
		
		validateIdCategoria(idCategoria, response);
		
		if (response.getCode() == null) {
			try {
				CategoriasDto categoria = categoriasRepository.getCategoriaByName(nameCategoria, idCategoria);
				
				if(categoria != null) {
					response.setCode(1);
					response.addMessage("Registro de categoria obtenido");
					response.setContent(categoria);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron categorias");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("La categoria con el nombre dado no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar las categorias, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto insertCategoria(CategoriasDto categoria) {
		ResponseDto response = new ResponseDto();
		
		validateCategoriaFields(categoria, response, null);
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = categoriasRepository.insertCategoria(categoria);
		        
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
				response.addMessage("Error al insertar las categorias, verifique");
			}
		}

		return response;
	}

	public ResponseDto updateCategoria(CategoriasDto categoria) {
		ResponseDto response = new ResponseDto();
		
		int validId = validateIdCategoria(categoria.getIdCategory(), response);
		validateCategoriaFields(categoria, response, categoria.getIdCategory());
		if (validId == 1) {
			validateCategoriaExistence(categoria.getIdCategory(), response, true);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = categoriasRepository.updateCategoria(categoria);
		        
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
				response.addMessage("Error al actualizar las categorias, verifique");
			}
		}

		return response;
	}

	public ResponseDto deleteCategoria(Integer idCategoria) {
		ResponseDto response = new ResponseDto();
		
		if (validateIdCategoria(idCategoria, response) == 1) {
			validateCategoriaExistence(idCategoria, response, false);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = categoriasRepository.deleteCategoria(idCategoria);
		        
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
				response.addMessage("Error al borrar las categorias, verifique");
			}
		}

		return response;
	}

	//Validaciones
	
	private int validateIdCategoria(Integer id, ResponseDto response) {
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
			response.addMessage("El nombre de la categoria debe no ser nulo y no tener una longitud mayor a 30 caracteres.");
			return 0;
		}
		
		return 1;
	}
	
	private void validateCategoriaFields(CategoriasDto categoria, ResponseDto response, Integer idCategoria) {
		if (validateName(categoria.getName(), response) == 1 && getCategoriaByName(categoria.getName(), idCategoria).getCode() > 0) {
			response.setCode(-14);
			response.addMessage("El nombre de la categoria ya se encuentra en uso, debes escoger otro nombre diferente.");
		}
		if (categoria.getDescription() == null || categoria.getDescription().length() > 100) {
			response.setCode(-4);
			response.addMessage("La descripcion de la categoria debe no ser nulo y no tener una longitud mayor a 30 caracteres.");
		}
		if (categoria.getCreatedAt() == null) {
			response.setCode(-9);
			response.addMessage("La fecha y hora de creacion no debe ser nulo.");
		}
		if (categoria.getUpdatedAt() == null) {
			response.setCode(-11);
			response.addMessage("La fecha y hora de actualizacion no debe ser nulo.");
		}
		if (categoria.isActive() == null) {
			response.setCode(-12);
			response.addMessage("Debes especificar si la categoria esta activa o no, 'active' es el campo para ello, no 'isActive'.");
		}
	}
	
	private void validateCategoriaExistence(Integer id, ResponseDto response, Boolean update) {
		if (getCategoriaById(id, update).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("El ingrediente con la ID dada no existe o esta desactivado, no se puede actualizar o borrar si no existe o esta desactivado.");
		}
	}
}
