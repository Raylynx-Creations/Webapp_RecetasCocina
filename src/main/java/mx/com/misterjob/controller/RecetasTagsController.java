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

import mx.com.misterjob.dto.RecetasTagsDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.service.RecetasTagsService;

@Controller
@RequestMapping("recetas-tags")
public class RecetasTagsController {
	@Autowired
	private RecetasTagsService recetasTagsService;
	
	@ResponseBody
	@RequestMapping(value="/getRecetasTagsByIdReceta/{idR}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetasTagsByIdReceta(@PathVariable("idR") Integer idR){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasTagsService.getRecetasTagsByIdReceta(idR);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getRecetasTagsByIdTag/{idT}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetasTagsByIdTag(@PathVariable("idT") Integer idT){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasTagsService.getRecetasTagsByIdTag(idT);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getRecetaTag/{idR}/{idT}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetaTag(@PathVariable("idR") Integer idR, @PathVariable("idT") Integer idT){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasTagsService.getRecetaTag(idR, idT);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertRecetaTag", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseDto> insertRecetaTag(@RequestBody RecetasTagsDto nuevaRecetaTag){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasTagsService.insertRecetaTag(nuevaRecetaTag);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteRecetasTagsByIdReceta/{idR}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteRecetasTagsByIdReceta(@PathVariable("idR") Integer idR){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasTagsService.deleteRecetasTagsByIdReceta(idR);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteRecetaTag/{idR}/{idT}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteRecetaTag(@PathVariable("idR") Integer idR, @PathVariable("idT") Integer idT){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasTagsService.deleteRecetaTag(idR, idT);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
}
