package mx.com.misterjob.repository;

import java.util.List;

import mx.com.misterjob.dto.AuditoriaDto;

public interface AuditoriaRepository {
	public List<AuditoriaDto> getAuditoria();
	public AuditoriaDto getAuditoriaById(Integer idAuditoria);
	public Integer insertAuditoria(AuditoriaDto auditoria);
}
