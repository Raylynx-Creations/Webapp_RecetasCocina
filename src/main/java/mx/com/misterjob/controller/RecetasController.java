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

import mx.com.misterjob.dto.RecetasDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.service.RecetasService;

@Controller
@RequestMapping("recetas")
public class RecetasController {
	@Autowired
	private RecetasService recetasService;
	
	@ResponseBody
	@RequestMapping(value="/getRecetas", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetas(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasService.getRecetas();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getRecetaById/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetaById(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasService.getRecetaById(id, false);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertReceta", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseDto> insertReceta(@RequestBody RecetasDto nuevaReceta){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasService.insertReceta(nuevaReceta);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateReceta", method=RequestMethod.PUT, produces="application/json")
	public ResponseEntity<ResponseDto> updateReceta(@RequestBody RecetasDto receta){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasService.updateReceta(receta);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteReceta/{id}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteReceta(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasService.deleteReceta(id);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
}
