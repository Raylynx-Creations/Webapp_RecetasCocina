package mx.com.misterjob.repository.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.misterjob.entity.TagsEntity;
import mx.com.misterjob.entity.UsuariosEntity;
import mx.com.misterjob.repository.dao.TagsRepositoryDao;

@Repository
public class TagsRepositoryDaoImpl extends GenericDao<TagsEntity, Integer> implements TagsRepositoryDao {
	@Transactional()
	@SuppressWarnings("unchecked")
	public List<TagsEntity> getTags() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(TagsEntity.class);
		
		criteria.add(Restrictions.eq("isActive", true));
		
		return (List<TagsEntity>) criteria.list();
	}
	
	@Transactional()
	public TagsEntity getTagById(Integer idTag, Boolean update) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosEntity.class); 
		
		criteria.add(Restrictions.eq("idUser", idTag));
		if (!update) {
			criteria.add(Restrictions.eq("isActive", true));
		}
		
		return (TagsEntity) criteria.uniqueResult();
	}
	
	@Transactional()
	public TagsEntity getTagByName(String nameTag, Integer idTag) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosEntity.class); 
		
		criteria.add(Restrictions.eq("name", nameTag));
		if (idTag != null) {
			criteria.add(Restrictions.ne("idTag", idTag));
		}
		
		return (TagsEntity) criteria.uniqueResult();
	}
}
