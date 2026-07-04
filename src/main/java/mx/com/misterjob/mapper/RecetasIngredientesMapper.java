package mx.com.misterjob.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.misterjob.dto.RecetasIngredientesDto;

public class RecetasIngredientesMapper<T> implements RowMapper<RecetasIngredientesDto> {
	public RecetasIngredientesDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		RecetasIngredientesDto recetaIngrediente = new RecetasIngredientesDto();

		recetaIngrediente.setIdRecipe(rs.getInt("ID_RECIPE"));
		recetaIngrediente.setIdIngredient(rs.getInt("ID_INGREDIENT"));
		recetaIngrediente.setQuantity(rs.getByte("QUANTITY"));
		recetaIngrediente.setUnit(rs.getString("UNIT"));
		recetaIngrediente.setNotes(rs.getString("NOTES"));
		recetaIngrediente.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
		recetaIngrediente.setUpdatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
		
		return recetaIngrediente;
	}
}
