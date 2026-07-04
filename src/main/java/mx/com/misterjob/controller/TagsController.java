package mx.com.misterjob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.dto.TagsDto;
import mx.com.misterjob.service.TagsService;

@Controller
@RequestMapping("tags")
public class TagsController {
	@Autowired
	private TagsService tagsService;

	@ResponseBody
	@RequestMapping(value="/getTags", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getTags(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = tagsService.getTags();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getTagById/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getTagById(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = tagsService.getTagById(id, false);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertTag", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseDto> insertTag(@RequestBody TagsDto nuevoTag){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = tagsService.insertTag(nuevoTag);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateTag", method=RequestMethod.PUT, produces="application/json")
	public ResponseEntity<ResponseDto> updateTag(@RequestBody TagsDto tag){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = tagsService.updateTag(tag);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteTag/{id}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteTag(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = tagsService.deleteTag(id);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
}
