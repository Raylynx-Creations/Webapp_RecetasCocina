package mx.com.misterjob.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.misterjob.dto.UsuariosDto;

public class UsuariosMapper<T> implements RowMapper<UsuariosDto> {
	public UsuariosDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		UsuariosDto usuario = new UsuariosDto();

		usuario.setIdUser(rs.getInt("ID_USER"));
		usuario.setUsername(rs.getString("USERNAME"));
		usuario.setEmail(rs.getString("EMAIL"));
		usuario.setPasswordHash(rs.getString("PASSWORD_HASH"));
		usuario.setDisplayName(rs.getString("DISPLAY_NAME"));
		usuario.setProfilePicture(rs.getBytes("PROFILE_PICTURE"));
		usuario.setBio(rs.getString("BIO"));
		usuario.setRole(rs.getByte("ROLE"));
		usuario.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
		usuario.setUpdatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
		usuario.setLastLogin(rs.getTimestamp("LAST_LOGIN").toLocalDateTime());
		usuario.setActive(rs.getBoolean("IS_ACTIVE"));
		
		return usuario;
	}
}
