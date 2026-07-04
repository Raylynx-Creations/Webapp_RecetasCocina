package mx.com.misterjob.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.misterjob.dto.RecetasCategoriasDto;

public class RecetasCategoriasMapper<T> implements RowMapper<RecetasCategoriasDto> {
	public RecetasCategoriasDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		RecetasCategoriasDto recetaCategoria = new RecetasCategoriasDto();

		recetaCategoria.setIdRecipe(rs.getInt("ID_RECIPE"));
		recetaCategoria.setIdCategory(rs.getInt("ID_CATEGORY"));
		recetaCategoria.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
		recetaCategoria.setUpdatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
		
		return recetaCategoria;
	}
}
