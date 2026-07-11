package mx.com.misterjob.repository.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.misterjob.entity.RecetasTagsEntity;
import mx.com.misterjob.entity.compoundIds.RecetasTagsId;
import mx.com.misterjob.repository.dao.RecetasTagsRepositoryDao;

@Repository
public class RecetasTagsRepositoryDaoImpl extends GenericDao<RecetasTagsEntity, RecetasTagsId> implements RecetasTagsRepositoryDao {
	@Transactional()
	@SuppressWarnings("unchecked")
	public List<RecetasTagsEntity> getRecetasTagsByIdReceta(Integer idReceta) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(RecetasTagsEntity.class);
		
		criteria.add(Restrictions.eq("idRecipe", idReceta));
		
		return (List<RecetasTagsEntity>) criteria.list();
	}
	
	@Transactional()
	@SuppressWarnings("unchecked")
	public List<RecetasTagsEntity> getRecetasTagsByIdTag(Integer idTag) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(RecetasTagsEntity.class);
		
		criteria.add(Restrictions.eq("idTag", idTag));
		
		return (List<RecetasTagsEntity>) criteria.list();
	}
	
	@Transactional()
	public Integer deleteRecetasTagsByIdReceta(Integer idReceta) {
		final Session session = sessionFactory.getCurrentSession();
        
        // HQL uses the Entity class name and field name (not the SQL table/column)
        String hql = "DELETE FROM RecetasTagsEntity r WHERE r.idReceta = :idReceta";
        
        Query query = session.createQuery(hql);
        query.setParameter("idReceta", idReceta);
        
        // executeUpdate() executes the bulk DELETE and returns rows affected
        return query.executeUpdate();
	}
}
