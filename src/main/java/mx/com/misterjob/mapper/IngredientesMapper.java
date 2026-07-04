package mx.com.misterjob.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.misterjob.dto.IngredientesDto;

public class IngredientesMapper<T> implements RowMapper<IngredientesDto> {
	public IngredientesDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		IngredientesDto ingrediente = new IngredientesDto();

		ingrediente.setIdIngredient(rs.getInt("ID_INGREDIENT"));
		ingrediente.setName(rs.getString("NAME"));
		ingrediente.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
		ingrediente.setUpdatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
		ingrediente.setActive(rs.getBoolean("IS_ACTIVE"));
		
		return ingrediente;
	}
}
