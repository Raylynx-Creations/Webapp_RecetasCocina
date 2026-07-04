package mx.com.misterjob.service;

import mx.com.misterjob.dto.AuditoriaDto;
import mx.com.misterjob.dto.ResponseDto;

public interface AuditoriaService {
	public ResponseDto getAuditoria();
	public ResponseDto getAuditoriaById(Integer idAuditoria);
	public ResponseDto insertAuditoria(AuditoriaDto auditoria);
}
