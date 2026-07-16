package mx.com.misterjob.repository.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.misterjob.entity.EmpleadosEntity;
import mx.com.misterjob.repository.dao.EmpleadosRepositoryDao;

@Repository
public class EmpleadosRepositoryDaoImpl extends GenericDao<EmpleadosEntity, Integer> implements EmpleadosRepositoryDao {
	@Transactional()
	@SuppressWarnings("unchecked")
	public List<EmpleadosEntity> getEmpleadosMasculinos() {
		final Session session = sessionFactory.getCurrentSession(); // -> obt la session actual
		final Criteria criteria = session.createCriteria(EmpleadosEntity.class); 
//		criteria -> SELECT * FROM + ESQUEMA + USUARIOS_ADMIN --> select * from esquema.tabla;
		
		criteria.add(Restrictions.eq("sexo", "M"));
		
		return (List<EmpleadosEntity>) criteria.list();
	}
	
	@Transactional()
	@SuppressWarnings("unchecked")
	public List<EmpleadosEntity> getEmpleadosFemeninosEdad35() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(EmpleadosEntity.class); 

		criteria.add(Restrictions.eq("sexo", "F"));
		criteria.add(Restrictions.ge("edad", 35));
		
		return (List<EmpleadosEntity>) criteria.list();
	}
	
	@Transactional()
	public EmpleadosEntity getEmpleadoByRfc(String rfc) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(EmpleadosEntity.class); 
		
		criteria.add(Restrictions.eq("rfc", rfc));

		return (EmpleadosEntity) criteria.uniqueResult();
	}
	
	@Transactional()
	public EmpleadosEntity getEmpleadoByNombre(String nombre) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(EmpleadosEntity.class); 
		
		criteria.add(Restrictions.eq("nombreCompleto", nombre));

		return (EmpleadosEntity) criteria.uniqueResult();
	}
	
	@Transactional()
	public EmpleadosEntity getEmpleadoById(Integer id, Boolean activo) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(EmpleadosEntity.class); 

		criteria.add(Restrictions.eq("idEmpleado", id));
		criteria.add(Restrictions.eq("activo", activo));

		return (EmpleadosEntity) criteria.uniqueResult();
	}
}
