package mx.com.misterjob.repository.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.misterjob.entity.UsuariosEntity;
import mx.com.misterjob.repository.dao.UsuariosRepositoryDao;

@Repository
public class UsuariosRepositoryDaoImpl extends GenericDao<UsuariosEntity, Integer> implements UsuariosRepositoryDao {
	@Transactional()
	@SuppressWarnings("unchecked")
	public List<UsuariosEntity> getUsuarios() {
		final Session session = sessionFactory.getCurrentSession(); // -> obt la session actual
		final Criteria criteria = session.createCriteria(UsuariosEntity.class); 
//		criteria -> SELECT * FROM + ESQUEMA + USUARIOS_ADMIN --> select * from esquema.tabla;
		
		criteria.add(Restrictions.eq("isActive", true));
		
		return (List<UsuariosEntity>) criteria.list();
	}
	
	@Transactional()
	public UsuariosEntity getUsuarioById(Integer idUsuario, Boolean update) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosEntity.class); 
		
		criteria.add(Restrictions.eq("idUser", idUsuario)); // --> where idUser = ?
		if (!update) {
			criteria.add(Restrictions.eq("isActive", true));
		}
//		criteria.add(Restrictions.eq("nombreCompleto", datos.getNombreCompleto())); // --> where estado = ?
//		criteria.add(Restrictions.eq("otro campo", datos.otro campo)); // --> where estado = ?
		
		return (UsuariosEntity) criteria.uniqueResult();
	}
	
	@Transactional()
	public UsuariosEntity getUsuarioByUsername(String usernameUsuario, Integer idUsuario) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosEntity.class); 
		
		criteria.add(Restrictions.eq("username", usernameUsuario));
		if (idUsuario != null) {
			criteria.add(Restrictions.ne("idUser", idUsuario));
		}
		
		return (UsuariosEntity) criteria.uniqueResult();
	}
	
	@Transactional()
	public UsuariosEntity getUsuarioByEmail(String emailUsuario, Integer idUsuario) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosEntity.class); 
		
		criteria.add(Restrictions.eq("email", emailUsuario));
		if (idUsuario != null) {
			criteria.add(Restrictions.ne("idUser", idUsuario));
		}
		
		return (UsuariosEntity) criteria.uniqueResult();
	}
}
