package mx.com.misterjob.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.misterjob.dto.CategoriasDto;

public class CategoriasMapper<T> implements RowMapper<CategoriasDto> {
	public CategoriasDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		CategoriasDto categoria = new CategoriasDto();

		categoria.setIdCategory(rs.getInt("ID_CATEGORY"));
		categoria.setName(rs.getString("NAME"));
		categoria.setDescription(rs.getString("DESCRIPTION"));
		categoria.setIcon(rs.getBytes("ICON"));
		categoria.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
		categoria.setUpdatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
		categoria.setActive(rs.getBoolean("IS_ACTIVE"));
		
		return categoria;
	}
}
