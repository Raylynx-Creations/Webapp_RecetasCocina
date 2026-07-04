package mx.com.misterjob.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.misterjob.dto.IngredientesDto;
import mx.com.misterjob.mapper.IngredientesMapper;
import mx.com.misterjob.repository.IngredientesRepository;

@Repository
public class IngredientesRepositoryImpl implements IngredientesRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<IngredientesDto> getIngredientes() {
		return jdbcTemplate.query("SELECT * FROM INGREDIENTS WHERE IS_ACTIVE=1", new IngredientesMapper<IngredientesDto>());
	}

	public IngredientesDto getIngredienteById(Integer idIngrediente, Boolean update) {
		String query = "SELECT * FROM INGREDIENTS WHERE ID_INGREDIENT = ?";
		if (!update) {
			query += " AND IS_ACTIVE=1";
		}
		
		return jdbcTemplate.queryForObject(query, new Object[] {idIngrediente},
				new IngredientesMapper<IngredientesDto>());
	}
	
	public IngredientesDto getIngredienteByName(String nameIngrediente, Integer idIngrediente) {
		String query = "SELECT * FROM INGREDIENTS WHERE NAME = ?";
		Object[] data;
		if (idIngrediente == null) {
			data = new Object[] {nameIngrediente};
		} else {
			query += " AND ID_INGREDIENT = ?";
			data = new Object[] {nameIngrediente, idIngrediente};
		}
		
		return jdbcTemplate.queryForObject(query, data, new IngredientesMapper<IngredientesDto>());
	}

	public Integer insertIngrediente(IngredientesDto ingrediente) {
		return jdbcTemplate.update("INSERT INTO INGREDIENTS VALUES (SEQ_INGREDIENT.NEXTVAL, ?, ?, ?, ?)",
				new Object[] {ingrediente.getName(), Timestamp.valueOf(ingrediente.getUpdatedAt()),
						Timestamp.valueOf(ingrediente.getUpdatedAt()), ingrediente.isActive()});
	}

	public Integer updateIngrediente(IngredientesDto ingrediente) {
		return jdbcTemplate.update("UPDATE INGREDIENTS SET NAME=?, UPDATED_AT=?, IS_ACTIVE=? WHERE ID_INGREDIENT=?",
				new Object[] {ingrediente.getName(), Timestamp.valueOf(ingrediente.getUpdatedAt()),
						ingrediente.isActive(), ingrediente.getIdIngredient()});
	}

	public Integer deleteIngrediente(Integer idIngrediente) {
		return jdbcTemplate.update("UPDATE INGREDIENTS SET IS_ACTIVE=0 WHERE ID_INGREDIENT=? AND IS_ACTIVE=1", new Object[] {idIngrediente});
		//return jdbcTemplate.update("DELETE FROM INGREDIENTES WHERE ID_INGREDIENT = ?", new Object[] {idIngrediente});
	}

}
