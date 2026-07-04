package mx.com.misterjob.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.misterjob.dto.RecetasTagsDto;
import mx.com.misterjob.mapper.RecetasTagsMapper;
import mx.com.misterjob.repository.RecetasTagsRepository;

@Repository
public class RecetasTagsRepositoryImpl implements RecetasTagsRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<RecetasTagsDto> getRecetasTagsByIdReceta(Integer idReceta) {
		return jdbcTemplate.query("SELECT * FROM RECIPE_TAGS WHERE ID_RECIPE = ?", new Object[] {idReceta},
				new RecetasTagsMapper<RecetasTagsDto>());
	}

	public List<RecetasTagsDto> getRecetasTagsByIdTag(Integer idTag) {
		return jdbcTemplate.query("SELECT * FROM RECIPE_TAGS WHERE ID_TAG = ?", new Object[] {idTag},
				new RecetasTagsMapper<RecetasTagsDto>());
	}

	public RecetasTagsDto getRecetaTag(Integer idReceta, Integer idTag) {
		return jdbcTemplate.queryForObject("SELECT * FROM RECIPE_TAGS WHERE ID_RECIPE = ? AND ID_TAG = ?",
				new Object[] {idReceta, idTag},	new RecetasTagsMapper<RecetasTagsDto>());
	}

	public Integer insertRecetaTag(RecetasTagsDto recetaTag) {
		return jdbcTemplate.update("INSERT INTO RECIPE_TAGS VALUES (?, ?, ?, ?)",
				new Object[] {recetaTag.getIdRecipe(), recetaTag.getIdTag(),
						Timestamp.valueOf(recetaTag.getCreatedAt()), Timestamp.valueOf(recetaTag.getUpdatedAt())});
	}

	public Integer deleteRecetasTagsByIdReceta(Integer idReceta) {
		return jdbcTemplate.update("DELETE FROM RECIPE_TAGS WHERE ID_RECIPE = ?", new Object[] {idReceta});
	}

	public Integer deleteRecetaTag(Integer idReceta, Integer idTag) {
		return jdbcTemplate.update("DELETE FROM RECIPE_TAGS WHERE ID_RECIPE = ? AND ID_TAG = ?",
				new Object[] {idReceta, idTag});
	}

}
