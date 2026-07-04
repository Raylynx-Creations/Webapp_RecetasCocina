package mx.com.misterjob.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.misterjob.dto.RecetasTagsDto;

public class RecetasTagsMapper<T> implements RowMapper<RecetasTagsDto> {
	public RecetasTagsDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		RecetasTagsDto recetaTag = new RecetasTagsDto();

		recetaTag.setIdRecipe(rs.getInt("ID_RECIPE"));
		recetaTag.setIdTag(rs.getInt("ID_TAG"));
		recetaTag.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
		recetaTag.setUpdatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
		
		return recetaTag;
	}
}
