package mx.com.misterjob.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.misterjob.dto.CategoriasDto;
import mx.com.misterjob.mapper.CategoriasMapper;
import mx.com.misterjob.repository.CategoriasRepository;

@Repository
public class CategoriasRepositoryImpl implements CategoriasRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CategoriasDto> getCategorias() {
		return jdbcTemplate.query("SELECT * FROM CATEGORIES WHERE IS_ACTIVE=1", new CategoriasMapper<CategoriasDto>());
	}

	public CategoriasDto getCategoriaById(Integer idCategoria, Boolean update) {
		String query = "SELECT * FROM CATEGORIES WHERE ID_CATEGORY = ?";
		if (!update) {
			query += " AND IS_ACTIVE=1";
		}
		
		return jdbcTemplate.queryForObject(query, new Object[] {idCategoria}, new CategoriasMapper<CategoriasDto>());
	}
	
	public CategoriasDto getCategoriaByName(String nameCategoria, Integer idCategoria) {
		String query = "SELECT * FROM CATEGORIES WHERE NAME = ?";
		Object[] data;
		if (idCategoria == null) {
			data = new Object[] {nameCategoria};
		} else {
			query += " AND ID_CATEGORY = ?";
			data = new Object[] {nameCategoria, idCategoria};
		}
		
		return jdbcTemplate.queryForObject(query, data, new CategoriasMapper<CategoriasDto>());
	}

	public Integer insertCategoria(CategoriasDto categoria) {
		return jdbcTemplate.update("INSERT INTO CATEGORIES VALUES (SEQ_CATEGORY.NEXTVAL, ?, ?, ?, ?, ?, ?)",
				new Object[] {categoria.getName(), categoria.getDescription(), categoria.getIcon(),
						Timestamp.valueOf(categoria.getCreatedAt()), Timestamp.valueOf(categoria.getUpdatedAt()),
						categoria.isActive()});
	}

	public Integer updateCategoria(CategoriasDto categoria) {
		return jdbcTemplate.update("UPDATE CATEGORIES SET NAME=?, DESCRIPTION=?, ICON=?, UPDATED_AT=?, IS_ACTIVE=? WHERE ID_CATEGORY=?",
				new Object[] {categoria.getName(), categoria.getDescription(), categoria.getIcon(),
						Timestamp.valueOf(categoria.getUpdatedAt()), categoria.isActive(), categoria.getIdCategory()});
	}

	public Integer deleteCategoria(Integer idCategoria) {
		return jdbcTemplate.update("UPDATE CATEGORIES SET IS_ACTIVE=0 WHERE ID_CATEGORY=? AND IS_ACTIVE=1", new Object[] {idCategoria});
		//return jdbcTemplate.update("DELETE FROM CATEGORIES WHERE ID_CATEGORY = ?", new Object[] {idCategoria});
	}

}
