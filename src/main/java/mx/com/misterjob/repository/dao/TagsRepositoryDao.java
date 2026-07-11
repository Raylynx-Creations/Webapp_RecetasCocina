package mx.com.misterjob.repository.dao;

import java.util.List;

import mx.com.misterjob.entity.TagsEntity;

public interface TagsRepositoryDao extends Dao<TagsEntity, Integer>{
	public List<TagsEntity> getTags();
	public TagsEntity getTagById(Integer idTag, Boolean update);
	public TagsEntity getTagByName(String nameTag, Integer idTag);
}
