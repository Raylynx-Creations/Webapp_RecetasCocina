package mx.com.misterjob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.misterjob.dto.AuditoriaDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.repository.AuditoriaRepository;
import mx.com.misterjob.service.AuditoriaService;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {
	@Autowired
	private AuditoriaRepository auditoriaRepository;

	public ResponseDto getAuditoria() {
		ResponseDto response = new ResponseDto();
		
		try {
			List<AuditoriaDto> auditoria = auditoriaRepository.getAuditoria();
			
			if(auditoria != null && !auditoria.isEmpty()) {
				response.setCode(1);
				response.addMessage("Registros de auditoria obtenidos");
				response.setContent(auditoria);
			}
			else {
				response.setCode(-1);
				response.addMessage("No se obtuvieron auditoria");
			}
		}
		catch (NullPointerException nullPointerException) {
			response.setCode(-10);
			response.addMessage("Algún dato viene nulo");
		}
		catch (Exception exception) {
			response.setCode(-100);
			response.addMessage("Error al consultar la auditoria, verifique");
		}
		
		return response;
	}

	public ResponseDto getAuditoriaById(Integer idAuditoria) {
		ResponseDto response = new ResponseDto();
		
		validateIdAuditoria(idAuditoria, response);
		
		if (response.getCode() == null) {
			try {
				AuditoriaDto auditoria = auditoriaRepository.getAuditoriaById(idAuditoria);
				
				if(auditoria != null) {
					response.setCode(1);
					response.addMessage("Registro de auditoria obtenido");
					response.setContent(auditoria);
				}
				else {
					response.setCode(-1);
					response.addMessage("No se obtuvieron auditoria");
				}
			}
			catch (EmptyResultDataAccessException emptyResultDataAccessException) {
				response.setCode(-10);
				response.addMessage("La auditoria con la ID dada no existe");
			}
			catch (NullPointerException nullPointerException) {
				response.setCode(-10);
				response.addMessage("Algún dato viene nulo");
			}
			catch (Exception exception) {
				response.setCode(-100);
				response.addMessage("Error al consultar la auditoria, verifique");
			}
		}
		
		return response;
	}

	public ResponseDto insertAuditoria(AuditoriaDto auditoria) {
		ResponseDto response = new ResponseDto();
		
		try {
	        Integer insertResponse = auditoriaRepository.insertAuditoria(auditoria);
	        
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
			response.addMessage("Error al insertar la auditoria, verifique");
		}

		return response;
	}

	//Validaciones
	
	private void validateIdAuditoria(Integer id, ResponseDto response) {
		if (id == null || id < 0 || id > 999999999999999999L) {
			response.setCode(-2);
			response.addMessage("El ID debe no ser nulo y estar entre 0 y 999,999,999,999,999,999.");
		}
	}
}
