package mx.com.misterjob.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.misterjob.dto.RecetasIngredientesDto;
import mx.com.misterjob.mapper.RecetasIngredientesMapper;
import mx.com.misterjob.repository.RecetasIngredientesRepository;

@Repository
public class RecetasIngredientesRepositoryImpl implements RecetasIngredientesRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<RecetasIngredientesDto> getRecetasIngredientesByIdReceta(Integer idReceta) {
		return jdbcTemplate.query("SELECT * FROM RECIPE_INGREDIENTS WHERE ID_RECIPE = ?", new Object[] {idReceta},
				new RecetasIngredientesMapper<RecetasIngredientesDto>());
	}

	public List<RecetasIngredientesDto> getRecetasIngredientesByIdIngrediente(Integer idIngrediente) {
		return jdbcTemplate.query("SELECT * FROM RECIPE_INGREDIENTS WHERE ID_INGREDIENT = ?", new Object[] {idIngrediente},
				new RecetasIngredientesMapper<RecetasIngredientesDto>());
	}

	public RecetasIngredientesDto getRecetaIngrediente(Integer idReceta, Integer idIngrediente) {
		return jdbcTemplate.queryForObject("SELECT * FROM RECIPE_INGREDIENTS WHERE ID_RECIPE = ? AND ID_INGREDIENT = ?",
				new Object[] {idReceta, idIngrediente}, new RecetasIngredientesMapper<RecetasIngredientesDto>());
	}

	public Integer insertRecetaIngrediente(RecetasIngredientesDto recetaIngrediente) {
		return jdbcTemplate.update("INSERT INTO RECIPE_INGREDIENTS VALUES (?, ?, ?, ?, ?, ?, ?)",
				new Object[] {recetaIngrediente.getIdRecipe(), recetaIngrediente.getIdIngredient(),
						recetaIngrediente.getQuantity(), recetaIngrediente.getUnit(), recetaIngrediente.getNotes(),
						Timestamp.valueOf(recetaIngrediente.getCreatedAt()), Timestamp.valueOf(recetaIngrediente.getUpdatedAt())});
	}

	public Integer updateRecetaIngrediente(RecetasIngredientesDto recetaIngrediente) {
		return jdbcTemplate.update("UPDATE RECIPE_INGREDIENTS SET QUANTITY=?, UNIT=?, NOTES=?, UPDATED_AT=? WHERE ID_RECIPE=? AND ID_INGREDIENT=?",
				new Object[] {recetaIngrediente.getQuantity(), recetaIngrediente.getUnit(), recetaIngrediente.getNotes(),
						Timestamp.valueOf(recetaIngrediente.getUpdatedAt()), recetaIngrediente.getIdRecipe(),
						recetaIngrediente.getIdIngredient()});
	}

	public Integer deleteRecetasIngredientesByIdReceta(Integer idReceta) {
		return jdbcTemplate.update("DELETE FROM RECIPE_INGREDIENTS WHERE ID_RECIPE = ?", new Object[] {idReceta});
	}

	public Integer deleteRecetaIngrediente(Integer idReceta, Integer idIngrediente) {
		return jdbcTemplate.update("DELETE FROM RECIPE_INGREDIENTS WHERE ID_RECIPE = ? AND ID_INGREDIENT = ?",
				new Object[] {idReceta, idIngrediente});
	}

}
