package mx.com.misterjob.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.misterjob.dto.EmpleadosDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.dto.UsuariosDto;
import mx.com.misterjob.entity.EmpleadosEntity;
import mx.com.misterjob.entity.UsuariosEntity;
import mx.com.misterjob.repository.dao.EmpleadosRepositoryDao;
import mx.com.misterjob.repository.dao.UsuariosRepositoryDao;
import mx.com.misterjob.service.EmpleadosService;
import mx.com.misterjob.service.UsuariosService;

@Service
public class EmpleadosServiceImpl implements EmpleadosService{
	@Autowired
	private EmpleadosRepositoryDao empleadosRepositoryDao;

	public ResponseDto getEmpleadosMasculinos() {
		ResponseDto response = new ResponseDto();
		
		try {
			List<EmpleadosEntity> usuarios = empleadosRepositoryDao.getEmpleadosMasculinos();
			
			if(usuarios != null && !usuarios.isEmpty()) {
				response.setCode(1);
				response.addMessage("Registros de empleados obtenidos");
				response.setContent(usuarios);
			}
			else {
				response.setCode(-1);
				response.addMessage("No se obtuvieron empleados");
			}
		}
		catch (NullPointerException nullPointerException) {
			response.setCode(-10);
			response.addMessage("Algún dato viene nulo");
		}
		catch (Exception exception) {
			response.setCode(-100);
			response.addMessage("Error al consultar los empleados, verifique");
			exception.printStackTrace();
		}
		
		return response;
	}
	
	public ResponseDto getEmpleadosFemeninosEdad35() {
		ResponseDto response = new ResponseDto();
		
		try {
			List<EmpleadosEntity> usuarios = empleadosRepositoryDao.getEmpleadosFemeninosEdad35();
			
			if(usuarios != null && !usuarios.isEmpty()) {
				response.setCode(1);
				response.addMessage("Registros de empleados obtenidos");
				response.setContent(usuarios);
			}
			else {
				response.setCode(-1);
				response.addMessage("No se obtuvieron empleados");
			}
		}
		catch (NullPointerException nullPointerException) {
			response.setCode(-10);
			response.addMessage("Algún dato viene nulo");
		}
		catch (Exception exception) {
			response.setCode(-100);
			response.addMessage("Error al consultar los empleados, verifique");
			exception.printStackTrace();
		}
		
		return response;
	}

	public ResponseDto getEmpleadoByRfc(String rfc) {
		ResponseDto response = new ResponseDto();
		
		validateRfc(rfc, response);
		
		if (response.getCode() == null) {
			try {
				EmpleadosEntity usuario = empleadosRepositoryDao.getEmpleadoByRfc(rfc);
				
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
				exception.printStackTrace();
			}
		}
		
		return response;
	}
	
	public ResponseDto insertEmpleado(EmpleadosDto empleado) {
		ResponseDto response = new ResponseDto();
		
		if (validateNombre(empleado.getNombreCompleto(), response) == 1) {
			validateExistence(empleado.getNombreCompleto(), response);
		}
		validateFields(empleado, response);
		
		if (response.getCode() == null) {
			try {
				EmpleadosEntity usuarioEntidad = empleadosDtoToEntity(empleado);
				
		        empleadosRepositoryDao.create(usuarioEntidad);
		        response.setCode(1);
	        	response.addMessage("Se insertó correctamente");
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

	public ResponseDto updateEmpleado(EmpleadosDto usuario) {
		ResponseDto response = new ResponseDto();
		
		if (validateId(usuario.getIdEmpleado(), response) == 1) {
			EmpleadosEntity empleado = empleadosRepositoryDao.getEmpleadoById(usuario.getIdEmpleado(), true);
			
			if (empleado == null) {
				response.setCode(-30);
				response.addMessage("El empleado con la ID dada no existe o esta dado de baja, no puede actualizar su informacion! Verifique que sea el ID correcto y que este activo.");
			}
		}
		validateNombre(usuario.getNombreCompleto(), response);
		validateFields(usuario, response);
		
		if (response.getCode() == null) {
			try {
				EmpleadosEntity usuarioEntidad = empleadosDtoToEntity(usuario);
				
		        empleadosRepositoryDao.update(usuarioEntidad);
	        	response.setCode(1);
	        	response.addMessage("Se actualizó correctamente");
	        	//Auditoria Service
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

	public ResponseDto deleteEmpleado(Integer idEmpleado) {
		ResponseDto response = new ResponseDto();
		
		validateId(idEmpleado, response);
		
		if (response.getCode() == null) {
			try {
				EmpleadosEntity empleado = empleadosRepositoryDao.getEmpleadoById(idEmpleado, false);
				
				if (empleado != null) {
					empleadosRepositoryDao.delete(idEmpleado);
					response.setCode(1);
			        response.addMessage("Empleado eliminado correctamente");
				} else {
					response.setCode(-20);
			        response.addMessage("Imposible eliminar Empleado, el ID suplementado no existe o sigue laborando (Activo)...! ");
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
	
	//Mapper
	
	private EmpleadosEntity empleadosDtoToEntity(EmpleadosDto empleado) {
		EmpleadosEntity empleadoEntidad = new EmpleadosEntity();
		empleadoEntidad.setIdEmpleado(empleado.getIdEmpleado());
		empleadoEntidad.setNombreCompleto(empleado.getNombreCompleto());
		empleadoEntidad.setRfc(empleado.getRfc());
		empleadoEntidad.setCurp(empleado.getCurp());
		empleadoEntidad.setEdad(empleado.getEdad());
		empleadoEntidad.setSexo(empleado.getSexo());
		empleadoEntidad.setDireccion(empleado.getDireccion());
		empleadoEntidad.setNss(empleado.getNss());
		empleadoEntidad.setTelefono(empleado.getTelefono());
		empleadoEntidad.setActivo(empleado.getActivo());
		
		return empleadoEntidad;
	}
	
	//Validaciones
	
	private int validateId(Integer id, ResponseDto response) {
		if (id == null || id < 0 || id > 99999999999L) {
			response.setCode(-2);
			response.addMessage("El ID debe no ser nulo y estar entre 0 y 99,999,999,999.");
			return 0;
		}
		
		return 1;
	}
	
	private void validateFields(EmpleadosDto empleado, ResponseDto response) {
		validateRfc(empleado.getRfc(), response);
		validateCurp(empleado.getCurp(), response);
		if (empleado.getEdad() != null && (empleado.getEdad() < 0 || empleado.getEdad() > 100)) {
			response.setCode(-6);
			response.addMessage("La edad debe ser un npumero entre 0 y 100.");
		}
		if (empleado.getSexo() != null && !(empleado.getSexo().equals("F") || empleado.getSexo().equals("M"))) {
			response.setCode(-7);
			response.addMessage("El sexo solo puede ser F o M, solo un caracter.");
		}
		if (empleado.getDireccion() != null && empleado.getDireccion().length() > 100) {
			response.setCode(-8);
			response.addMessage("La direccion debe no ser mayor a 100 caracteres.");
		}
		validateNss(empleado.getNss(), response);
		if (empleado.getActivo() == null) {
			response.setCode(-10);
			response.addMessage("El estado activo no debe ser nulo y debe ser un booleano, true o false.");
		}
	}
	
	private int validateNombre(String nombre, ResponseDto response) {
		if (nombre == null || nombre.length() > 100) {
			response.setCode(-3);
			response.addMessage("El nombre completo debe no ser nulo y no ser mayor a 100 caracteres.");
			return 0;
		}
		
		return 1;
	}
	
	private int validateRfc(String rfc, ResponseDto response) {
		if (rfc == null || rfc.length() != 13) {
			response.setCode(-4);
			response.addMessage("El RFC debe no ser nulo y ser exactamente 13 caracteres.");
			return 0;
		} else if (!rfc.toUpperCase().matches("^[A-ZÑ&]{3,4}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])[A-Z0-9]{3}$")) {
			response.setCode(-21);
			response.addMessage("El RFC no tiene la estructura correcta, verifique su RFC.");
			return 0;
		}
		
		return 1;
	}
	
	private int validateCurp(String curp, ResponseDto response) {
		if (curp == null || curp.length() != 18) {
			response.setCode(-5);
			response.addMessage("La CURP debe no ser nulo y ser exactamente 18 caracteres.");
			return 0;
		} else if (!curp.toUpperCase().matches("[A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d]\\d")){
			response.setCode(-22);
			response.addMessage("La CURP no tiene la estructura correcta, verifique su CURP.");
			return 0;
		}
		
		return 1;
	}
	
	private int validateNss(String nss, ResponseDto response) {
		if (nss == null || nss.length() != 10) {
			response.setCode(-9);
			response.addMessage("El NSS no cuenta con la estrutura adecuada, debe ser 10 digitos exactamente.");
			return 0;
		} else if (!nss.matches("\\d+")) {
			response.setCode(-23);
			response.addMessage("El NSS debe ser numerico unicamente.");
			return 0;
		}
		
		return 1;
	}
	
	private int validateExistence(String nombre, ResponseDto response) {
		EmpleadosEntity empleado = empleadosRepositoryDao.getEmpleadoByNombre(nombre);
		
		if (empleado != null) {
			response.setCode(-1);
			response.addMessage("El empleado con nombre " + nombre + " ya existe.");
			return 0;
		}
		
		return 1;
	}
}
