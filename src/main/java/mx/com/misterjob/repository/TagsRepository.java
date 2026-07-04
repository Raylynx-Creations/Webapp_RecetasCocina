package mx.com.misterjob.repository;

import java.util.List;

import mx.com.misterjob.dto.TagsDto;

public interface TagsRepository {
	public List<TagsDto> getTags();
	public TagsDto getTagById(Integer idTag, Boolean update);
	public TagsDto getTagByName(String nameTag, Integer idTag);
	public Integer insertTag(TagsDto tag);
	public Integer updateTag(TagsDto tag);
	public Integer deleteTag(Integer idTag);
}
