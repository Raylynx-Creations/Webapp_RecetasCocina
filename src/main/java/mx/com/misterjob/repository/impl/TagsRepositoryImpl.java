package mx.com.misterjob.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.misterjob.dto.TagsDto;
import mx.com.misterjob.mapper.TagsMapper;
import mx.com.misterjob.repository.TagsRepository;

@Repository
public class TagsRepositoryImpl implements TagsRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<TagsDto> getTags() {
		return jdbcTemplate.query("SELECT * FROM TAGS WHERE IS_ACTIVE=1", new TagsMapper<TagsDto>());
	}

	public TagsDto getTagById(Integer idTag, Boolean update) {
		String query = "SELECT * FROM TAGS WHERE ID_TAG = ?";
		if (!update) {
			query += " AND IS_ACTIVE=1";
		}
		
		return jdbcTemplate.queryForObject(query, new Object[] {idTag}, new TagsMapper<TagsDto>());
	}
	
	public TagsDto getTagByName(String nameTag, Integer idTag) {
		String query = "SELECT * FROM TAGS WHERE NAME = ?";
		Object[] data;
		if (idTag == null) {
			data = new Object[] {nameTag};
		} else {
			query += " AND ID_TAG != ?";
			data = new Object[] {nameTag, idTag};
		}
		
		return jdbcTemplate.queryForObject(query, data, new TagsMapper<TagsDto>());
	}

	public Integer insertTag(TagsDto tag) {
		return jdbcTemplate.update("INSERT INTO TAGS VALUES (SEQ_TAG.NEXTVAL, ?, ?, ?, ?)",
				new Object[] {tag.getName(), Timestamp.valueOf(tag.getCreatedAt()),
						Timestamp.valueOf(tag.getUpdatedAt()), tag.isActive()});
	}

	public Integer updateTag(TagsDto tag) {
		return jdbcTemplate.update("UPDATE TAGS SET NAME=?, UPDATED_AT=?, IS_ACTIVE=? WHERE ID_TAG=?",
				new Object[] {tag.getName(), Timestamp.valueOf(tag.getUpdatedAt()), tag.isActive(), tag.getIdTag()});
	}

	public Integer deleteTag(Integer idTag) {
		return jdbcTemplate.update("UPDATE TAGS SET IS_ACTIVE=0 WHERE ID_TAG=? AND IS_ACTIVE=1", new Object[] {idTag});
		//return jdbcTemplate.update("DELETE FROM TAGS WHERE ID_TAG=?", new Object[] {idTag});
	}

}
