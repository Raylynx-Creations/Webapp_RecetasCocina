package mx.com.misterjob.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.misterjob.dto.RecetasDto;
import mx.com.misterjob.mapper.RecetasMapper;
import mx.com.misterjob.repository.RecetasRepository;

@Repository
public class RecetasRepositoryImpl implements RecetasRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<RecetasDto> getRecetas(){
		return jdbcTemplate.query("SELECT * FROM RECIPES WHERE IS_ACTIVE=1", new RecetasMapper<RecetasDto>());
	}
	
	public RecetasDto getRecetaById(Integer idReceta, Boolean update) {
		String query = "SELECT * FROM RECIPES WHERE ID_RECIPE = ?";
		if (!update) {
			query += " AND IS_ACTIVE=1";
		}
		
		return jdbcTemplate.queryForObject(query, new Object[] {idReceta}, new RecetasMapper<RecetasDto>());
	}
	
	public Integer insertReceta(RecetasDto receta) {
		return jdbcTemplate.update("INSERT INTO RECIPES VALUES (SEQ_RECIPE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] {receta.getIdUser(), receta.getTitle(), receta.getDescription(),
						receta.getInstructions(), receta.getPreparationTimeMinutes(), receta.getCookTimeMinutes(),
						receta.getPortions(), receta.getDifficulty(), receta.getImage(), receta.getVisibility(),
						Timestamp.valueOf(receta.getCreatedAt()), Timestamp.valueOf(receta.getUpdatedAt()),
						receta.getViews(), receta.getLikes(), receta.isActive()});
	}
	
	public Integer updateReceta(RecetasDto receta) {
		return jdbcTemplate.update("UPDATE RECIPES SET ID_USER=?, TITLE=?, DESCRIPTION=?, INSTRUCTIONS=?, PREPARATION_TIME_MINUTES=?, COOK_TIME_MINUTES=?, PORTIONS=?, DIFFICULTY=?, IMAGE=?, VISIBILITY=?, UPDATED_AT=?, VIEWS=?, LIKES=?, IS_ACTIVE=? WHERE ID_RECIPE=?",
				new Object[] {receta.getIdUser(), receta.getTitle(), receta.getDescription(),
						receta.getInstructions(), receta.getPreparationTimeMinutes(), receta.getCookTimeMinutes(),
						receta.getPortions(), receta.getDifficulty(), receta.getImage(), receta.getVisibility(),
						Timestamp.valueOf(receta.getUpdatedAt()), receta.getViews(), receta.getLikes(),
						receta.isActive(), receta.getIdRecipe()});
	}
	
	public Integer deleteReceta(Integer idReceta) {
		return jdbcTemplate.update("UPDATE RECIPES SET IS_ACTIVE=0 WHERE ID_RECIPE=? AND IS_ACTIVE=1", new Object[] {idReceta});
		//return jdbcTemplate.update("DELETE FROM RECIPES WHERE ID_RECIPE=?", new Object[] {idReceta});
	}
}
