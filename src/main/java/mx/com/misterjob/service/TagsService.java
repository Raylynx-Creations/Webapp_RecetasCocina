package mx.com.misterjob.service;

import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.dto.TagsDto;

public interface TagsService {
	public ResponseDto getTags();
	public ResponseDto getTagById(Integer idTag, Boolean update);
	public ResponseDto getTagByName(String nameTag, Integer idUsuario);
	public ResponseDto insertTag(TagsDto tag);
	public ResponseDto updateTag(TagsDto tag);
	public ResponseDto deleteTag(Integer idTag);
}
