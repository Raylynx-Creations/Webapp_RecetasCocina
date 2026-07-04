package mx.com.misterjob.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.misterjob.dto.UsuariosDto;
import mx.com.misterjob.mapper.UsuariosMapper;
import mx.com.misterjob.repository.UsuariosRepository;

@Repository
public class UsuariosRepositoryImpl implements UsuariosRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<UsuariosDto> getUsuarios() {
		return jdbcTemplate.query("SELECT * FROM USERS WHERE IS_ACTIVE=1", new UsuariosMapper<UsuariosDto>());
	}

	public UsuariosDto getUsuarioById(Integer idUsuario, Boolean update) {
		String query = "SELECT * FROM USERS WHERE ID_USER = ?";
		if (!update) {
			query += " AND IS_ACTIVE=1";
		}
		
		return jdbcTemplate.queryForObject(query, new Object[] { idUsuario },
				new UsuariosMapper<UsuariosDto>());
	}
	
	public UsuariosDto getUsuarioByUsername(String usernameUsuario, Integer idUsuario) {
		String query = "SELECT * FROM USERS WHERE USERNAME = ?";
		Object[] data;
		if (idUsuario == null) {
			data = new Object[] { usernameUsuario };
		} else {
			query += " AND ID_USER != ?";
			data = new Object[] { usernameUsuario, idUsuario };
		}
		
		return jdbcTemplate.queryForObject(query, data, new UsuariosMapper<UsuariosDto>());
	}
	
	public UsuariosDto getUsuarioByEmail(String emailUsuario, Integer idUsuario) {
		String query = "SELECT * FROM USERS WHERE EMAIL = ?";
		Object[] data;
		if (idUsuario == null) {
			data = new Object[] { emailUsuario };
		} else {
			query += " AND ID_USER != ?";
			data = new Object[] { emailUsuario, idUsuario };
		}
		
		return jdbcTemplate.queryForObject(query, data, new UsuariosMapper<UsuariosDto>());
	}

	public Integer insertUsuario(UsuariosDto usuario) {
		return jdbcTemplate.update("INSERT INTO USERS VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { usuario.getUsername(), usuario.getEmail(), usuario.getPasswordHash(),
						usuario.getDisplayName(), usuario.getProfilePicture(), usuario.getBio(), usuario.getRole(),
						Timestamp.valueOf(usuario.getCreatedAt()), Timestamp.valueOf(usuario.getUpdatedAt()),
						Timestamp.valueOf(usuario.getLastLogin()), usuario.isActive() });
	}

	public Integer updateUsuario(UsuariosDto usuario) {
		return jdbcTemplate.update(
				"UPDATE USERS SET USERNAME=?, EMAIL=?, PASSWORD_HASH=?, DISPLAY_NAME=?, PROFILE_PICTURE=?, BIO=?, ROLE=?, UPDATED_AT=?, LAST_LOGIN=?, IS_ACTIVE=? WHERE ID_USER=?",
				new Object[] { usuario.getUsername(), usuario.getEmail(), usuario.getPasswordHash(),
						usuario.getDisplayName(), usuario.getProfilePicture(), usuario.getBio(), usuario.getRole(),
						Timestamp.valueOf(usuario.getUpdatedAt()), Timestamp.valueOf(usuario.getLastLogin()),
						usuario.isActive(), usuario.getIdUser() });
	}

	public Integer deleteUsuario(Integer idUsuario) {
		return jdbcTemplate.update("UPDATE USERS SET IS_ACTIVE=0 WHERE ID_USER=? AND IS_ACTIVE=1", new Object[] {idUsuario});
		//return jdbcTemplate.update("DELETE FROM USERS WHERE ID_USER=?", new Object[] { idUsuario });
	}
}
