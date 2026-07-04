package mx.com.misterjob.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.misterjob.dto.TagsDto;

public class TagsMapper<T> implements RowMapper<TagsDto> {
	public TagsDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		TagsDto tag = new TagsDto();
		
		tag.setIdTag(rs.getInt("ID_TAG"));
		tag.setName(rs.getString("NAME"));
		tag.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
		tag.setUpdatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
		tag.setActive(rs.getBoolean("IS_ACTIVE"));
		
		return tag;
	}
}
