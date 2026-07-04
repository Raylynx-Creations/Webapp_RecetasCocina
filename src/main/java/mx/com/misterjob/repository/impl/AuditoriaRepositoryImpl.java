package mx.com.misterjob.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.misterjob.dto.AuditoriaDto;
import mx.com.misterjob.mapper.AuditoriaMapper;
import mx.com.misterjob.repository.AuditoriaRepository;

@Repository
public class AuditoriaRepositoryImpl implements AuditoriaRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<AuditoriaDto> getAuditoria() {
		return jdbcTemplate.query("SELECT * FROM \"AUDIT\" l INNER JOIN AUDIT_TABLES t ON l.ID_TABLE = t.ID_TABLE INNER JOIN AUDIT_ACTIONS a ON l.ID_ACTION = a.ID_ACTION", new AuditoriaMapper<AuditoriaDto>());
	}

	public AuditoriaDto getAuditoriaById(Integer idAuditoria) {
		return jdbcTemplate.queryForObject("SELECT * FROM \"AUDIT\" l INNER JOIN AUDIT_TABLES t ON l.ID_TABLE = t.ID_TABLE INNER JOIN AUDIT_ACTIONS a ON l.ID_ACTION = a.ID_ACTION WHERE ID_AUDIT = ?",
				new Object[] {idAuditoria}, new AuditoriaMapper<AuditoriaDto>());
	}

	public Integer insertAuditoria(AuditoriaDto auditoria) {
		return jdbcTemplate.update("INSERT INTO \"AUDIT\" VALUES (SEQ_AUDIT.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] {auditoria.getIdUser(), auditoria.getIdAction(), auditoria.getIdTable(),
						auditoria.getRecordId(), auditoria.getOldData().toString(), auditoria.getNewData().toString(),
						Timestamp.valueOf(auditoria.getMadeAt())});
	}

}
