package mx.com.misterjob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.misterjob.dto.AuditoriaDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.dto.UsuariosDto;
import mx.com.misterjob.repository.UsuariosRepository;
import mx.com.misterjob.service.AuditoriaService;
import mx.com.misterjob.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService{
	@Autowired
	private UsuariosRepository usuariosRepository;
	@Autowired
	private AuditoriaService auditoriaService;

	public ResponseDto getUsuarios() {
		ResponseDto response = new ResponseDto();
		
		try {
			List<UsuariosDto> usuarios = usuariosRepository.getUsuarios();
			
			if(usuarios != null && !usuarios.isEmpty()) {
				response.setCode(1);
				response.addMessage("Registros de usuarios obtenidos");
				response.setContent(usuarios);
			}
			else {
				response.setCode(-1);
				response.addMessage("No se obtuvieron usuarios");
			}
		}
		catch (NullPointerException nullPointerException) {
			response.setCode(-10);
			response.addMessage("Algún dato viene nulo");
		}
		catch (Exception exception) {
			response.setCode(-100);
			response.addMessage("Error al consultar los usuarios, verifique");
		}
		
		return response;
	}

	public ResponseDto getUsuarioById(Integer idUsuario, Boolean update) {
		ResponseDto response = new ResponseDto();
		
		validateIdUser(idUsuario, response);
		
		if (response.getCode() == null) {
			try {
				UsuariosDto usuario = usuariosRepository.getUsuarioById(idUsuario, update);
				
				if(usuario != null) {
					response.setCode(1);
					response.addMessage("Registro de usuario obtenido");
					response.setContent(usuario);
				} else {
					response.setCode(-1);
					response.addMessage("No se obtuvo el usuario");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("El usuario con la ID dada no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-20);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar el usuario, verifique");
			}
		}
		
		return response;
	}
	
	public ResponseDto getUsuarioByUsername(String usernameUsuario, Integer idUsuario) {
		ResponseDto response = new ResponseDto();
		
		validateUsername(usernameUsuario, response);
		
		if (response.getCode() == null) {
			try {
				UsuariosDto usuario = usuariosRepository.getUsuarioByUsername(usernameUsuario, idUsuario);
				
				if(usuario != null) {
					response.setCode(1);
					response.addMessage("Registro de usuario obtenido");
					response.setContent(usuario);
				} else {
					response.setCode(-1);
					response.addMessage("No se obtuvo el usuario");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("El usuario con el nombre de usuario dado no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-20);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar el usuario, verifique");
			}
		}
		
		return response;
	}
	
	public ResponseDto getUsuarioByEmail(String emailUsuario, Integer idUsuario) {
		ResponseDto response = new ResponseDto();
		
		validateEmail(emailUsuario, response);
		
		if (response.getCode() == null) {
			try {
				UsuariosDto usuario = usuariosRepository.getUsuarioByEmail(emailUsuario, idUsuario);
				
				if(usuario != null) {
					response.setCode(1);
					response.addMessage("Registro de usuario obtenido");
					response.setContent(usuario);
				} else {
					response.setCode(-1);
					response.addMessage("No se obtuvo el usuario");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("El usuario con el nombre de usuario dado no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-20);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar el usuario, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto insertUsuario(UsuariosDto usuario) {
		ResponseDto response = new ResponseDto();
		
		validateUserFields(usuario, response, null);
		
		if (response.getCode() == null) {
			try {
		        Integer insertResponse = usuariosRepository.insertUsuario(usuario);
		        
		        if(insertResponse == 1) {
		        	response.setCode(1);
		        	response.addMessage("Se insertó correctamente");
		        	
		        	/*AuditoriaDto auditoria = new AuditoriaDto();
		        	auditoria.setIdUser(1);
		        	auditoria.setIdAction((byte) 1);
		        	auditoria.setIdTable((byte) 1);
		        	auditoria.setRecordId(recordId); //Todo all this, find a way.
		        	auditoria.setNewData(newData);
		        	auditoria.setOldData(null);
		        	auditoria.setMadeAt(madeAt);
		        	
		        	auditoriaService.insertAuditoria(auditoria);*/
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
				response.addMessage("Error al insertar los usuarios, verifique");
			}
		}

		return response;
	}

	public ResponseDto updateUsuario(UsuariosDto usuario) {
		ResponseDto response = new ResponseDto();
		
		Integer idValido = validateIdUser(usuario.getIdUser(), response);
		validateUserFields(usuario, response, usuario.getIdUser());
		if (idValido == 1) {
			validateUserExistence(usuario.getIdUser(), response, true);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer updateResponse = usuariosRepository.updateUsuario(usuario);
		        
		        if(updateResponse == 1) {
		        	response.setCode(1);
		        	response.addMessage("Se actualizó correctamente");
		        	//Auditoria Service
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
				response.addMessage("Error al actualizar los usuarios, verifique");
			}
		}

		return response;
	}

	public ResponseDto deleteUsuario(Integer idUsuario) {
		ResponseDto response = new ResponseDto();
		
		if (validateIdUser(idUsuario, response) == 1) {
			validateUserExistence(idUsuario, response, false);
		}
		
		if (response.getCode() == null) {
			try {
		        Integer deleteResponse = usuariosRepository.deleteUsuario(idUsuario);
		        
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
				response.addMessage("Error al eliminar los usuarios, verifique");
			}
		}

		return response;
	}
	
	//Validaciones
	
	private int validateIdUser(Integer id, ResponseDto response) {
		if (id == null || id < 0 || id > 9999999999L) {
			response.setCode(-2);
			response.addMessage("El ID debe no ser nulo y estar entre 0 y 9,999,999,999.");
			return 0;
		}
		
		return 1;
	}
	
	private int validateUsername(String username, ResponseDto response) {
		if (username == null || username.length() > 30) {
			response.setCode(-3);
			response.addMessage("El nombre de usuario debe no ser nulo y no tener una longitud mayor a 30 caracteres.");
			return 0;
		}
		
		return 1;
	}
	
	private int validateEmail(String email, ResponseDto response) {
		if (email == null || email.length() > 50) {
			response.setCode(-4);
			response.addMessage("El email debe no ser nulo y no tener una longitud mayor a 50 caracteres.");
			return 0;
		}
		
		return 1;
	}
	
	private void validateUserFields(UsuariosDto usuario, ResponseDto response, Integer idUsuario) {
		if (validateUsername(usuario.getUsername(), response) == 1 && getUsuarioByUsername(usuario.getUsername(), idUsuario).getCode() > 0) {
			response.setCode(-14);
			response.addMessage("El nombre de usuario ya se encuentra en uso, debes escoger otro nombre de usuario diferente.");
		}
		if (validateEmail(usuario.getEmail(), response) == 1 && getUsuarioByEmail(usuario.getEmail(), idUsuario).getCode() > 0) {
			response.setCode(-15);
			response.addMessage("El email ya se encuentra en uso, debes escoger otro email diferente.");
		}
		if (usuario.getPasswordHash() == null || usuario.getPasswordHash().length() > 70) {
			response.setCode(-5);
			response.addMessage("El password hash debe no ser nulo y no tener una longitud mayor a 70 caracteres.");
		}
		if (usuario.getDisplayName() != null && usuario.getDisplayName().length() > 30) {
			response.setCode(-6);
			response.addMessage("El nombre a mostrar debe no tener una longitud mayor a 30 caracteres, no es lo mismo el nombre de usuario del nombre a mostrar.");
		}
		if (usuario.getBio() != null && usuario.getBio().length() > 300) {
			response.setCode(-7);
			response.addMessage("La bio debe no tener una longitud mayor a 300 caracteres.");
		}
		if (usuario.getRole() == null || usuario.getRole() < 0 || usuario.getRole() > 2) {
			response.setCode(-8);
			response.addMessage("El rol de usuario debe no ser nulo y ser 0, 1 o 2 unicamente.");
		}
		if (usuario.getCreatedAt() == null) {
			response.setCode(-9);
			response.addMessage("La fecha y hora de creacion no debe ser nulo.");
		}
		if (usuario.getUpdatedAt() == null) {
			response.setCode(-11);
			response.addMessage("La fecha y hora de actualizacion no debe ser nulo.");
		}
		if (usuario.isActive() == null) {
			response.setCode(-12);
			response.addMessage("Debes especificar si el usuario esta activo o no, 'active' es el campo para ello, no 'isActive'.");
		}
	}
	
	private void validateUserExistence(Integer id, ResponseDto response, Boolean update) {
		if (getUsuarioById(id, update).getCode() <= 0) {
			response.setCode(-13);
			response.addMessage("El usuario con la ID dada no existe o esta desactivado, no se puede actualizar o borrar si no existe o esta desactivado.");
		}
	}
}
