package mx.com.misterjob.mapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.misterjob.dto.AuditoriaDto;

public class AuditoriaMapper<T> implements RowMapper<AuditoriaDto> {
	public AuditoriaDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		AuditoriaDto auditoria = new AuditoriaDto();
		ObjectMapper mapper = new ObjectMapper();

		auditoria.setIdAudit(rs.getLong("ID_AUDIT"));
		auditoria.setIdUser(rs.getInt("ID_USER"));
		auditoria.setIdAction(rs.getByte("ID_ACTION"));
		auditoria.setActionDescription(rs.getString("DESCRIPTION"));
		auditoria.setIdTable(rs.getByte("ID_TABLE"));
		auditoria.setTableName(rs.getString("NAME"));
		auditoria.setRecordId(rs.getInt("RECORD_ID"));
		
		try {
			auditoria.setOldData(mapper.readTree(rs.getClob("OLD_DATA").toString()));
		} catch (JsonProcessingException e) {
			auditoria.setOldData(null);
			e.printStackTrace();
		} catch (IOException e) {
			auditoria.setOldData(null);
			e.printStackTrace();
		}
		try {
			auditoria.setNewData(mapper.readTree(rs.getClob("NEW_DATA").toString()));
		} catch (JsonProcessingException e) {
			auditoria.setNewData(null);
			e.printStackTrace();
		} catch (IOException e) {
			auditoria.setNewData(null);
			e.printStackTrace();
		}
		
		auditoria.setMadeAt(rs.getTimestamp("MADE_AT").toLocalDateTime());
		
		return auditoria;
	}
}
