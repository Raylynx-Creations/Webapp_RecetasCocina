package mx.com.misterjob.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.misterjob.dto.RecetasCategoriasDto;
import mx.com.misterjob.mapper.RecetasCategoriasMapper;
import mx.com.misterjob.repository.RecetasCategoriasRepository;

@Repository
public class RecetasCategoriasRepositoryImpl implements RecetasCategoriasRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<RecetasCategoriasDto> getRecetasCategoriasByIdReceta(Integer idReceta) {
		return jdbcTemplate.query("SELECT * FROM RECIPE_CATEGORIES WHERE ID_RECIPE = ?", new Object[] {idReceta},
				new RecetasCategoriasMapper<RecetasCategoriasDto>());
	}

	public List<RecetasCategoriasDto> getRecetasCategoriasByIdCategoria(Integer idCategoria) {
		return jdbcTemplate.query("SELECT * FROM RECIPE_CATEGORIES WHERE ID_CATEGORY = ?", new Object[] {idCategoria},
				new RecetasCategoriasMapper<RecetasCategoriasDto>());
	}

	public RecetasCategoriasDto getRecetaCategoria(Integer idReceta, Integer idCategoria) {
		return jdbcTemplate.queryForObject("SELECT * FROM RECIPE_CATEGORIES WHERE ID_RECIPE = ? AND ID_CATEGORY = ?",
				new Object[] {idReceta, idCategoria}, new RecetasCategoriasMapper<RecetasCategoriasDto>());
	}

	public Integer insertRecetaCategoria(RecetasCategoriasDto recetaCategoria) {
		return jdbcTemplate.update("INSERT INTO RECIPE_CATEGORIES VALUES (?, ?, ?, ?)",
				new Object[] {recetaCategoria.getIdRecipe(), recetaCategoria.getIdCategory(),
						Timestamp.valueOf(recetaCategoria.getCreatedAt()), Timestamp.valueOf(recetaCategoria.getUpdatedAt())});
	}

	public Integer deleteRecetasCategoriasByIdReceta(Integer idReceta) {
		return jdbcTemplate.update("DELETE FROM RECIPE_CATEGORIES WHERE ID_RECIPE = ?", new Object[] {idReceta});
	}

	public Integer deleteRecetaCategoria(Integer idReceta, Integer idCategoria) {
		return jdbcTemplate.update("DELETE FROM RECIPE_CATEGORIES WHERE ID_RECIPE = ? AND ID_CATEGORY = ?",
				new Object[] {idReceta, idCategoria});
	}

}
