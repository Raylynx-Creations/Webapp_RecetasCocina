package mx.com.misterjob.repository.dao;

import java.util.List;

import mx.com.misterjob.entity.RecetasTagsEntity;
import mx.com.misterjob.entity.compoundIds.RecetasTagsId;

public interface RecetasTagsRepositoryDao extends Dao<RecetasTagsEntity, RecetasTagsId> {
	public List<RecetasTagsEntity> getRecetasTagsByIdReceta(Integer idReceta);
	public List<RecetasTagsEntity> getRecetasTagsByIdTag(Integer idTag);
	public Integer deleteRecetasTagsByIdReceta(Integer idReceta);
}
