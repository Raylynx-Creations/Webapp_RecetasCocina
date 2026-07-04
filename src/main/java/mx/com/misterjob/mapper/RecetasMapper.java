package mx.com.misterjob.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.misterjob.dto.RecetasDto;

public class RecetasMapper<T> implements RowMapper<RecetasDto> {
	public RecetasDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		RecetasDto receta = new RecetasDto();
		
		receta.setIdRecipe(rs.getInt("ID_RECIPE"));
		receta.setIdUser(rs.getInt("ID_USER"));
		receta.setTitle(rs.getString("TITLE"));
		receta.setDescription(rs.getString("DESCRIPTION"));
		receta.setInstructions(rs.getString("INSTRUCTIONS"));
		receta.setPreparationTimeMinutes(rs.getShort("PREPARATION_TIME_MINUTES"));
		receta.setCookTimeMinutes(rs.getShort("COOK_TIME_MINUTES"));
		receta.setPortions(rs.getByte("PORTIONS"));
		receta.setDifficulty(rs.getByte("DIFFICULTY"));
		receta.setImage(rs.getBytes("IMAGE"));
		receta.setVisibility(rs.getByte("VISIBILITY"));
		receta.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
		receta.setUpdatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
		receta.setViews(rs.getLong("VIEWS"));
		receta.setLikes(rs.getLong("LIKES"));
		receta.setActive(rs.getBoolean("IS_ACTIVE"));
		
		return receta;
	}
}
