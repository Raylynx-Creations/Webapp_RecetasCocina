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

import mx.com.misterjob.dto.CategoriasDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.service.CategoriasService;

@Controller
@RequestMapping("categorias")
public class CategoriasController {
	@Autowired
	private CategoriasService categoriasService;
	
	@ResponseBody
	@RequestMapping(value="/getCategorias", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getCategorias(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = categoriasService.getCategorias();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getCategoriaById/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getCategoriaById(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = categoriasService.getCategoriaById(id, false);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertCategoria", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseDto> insertCategoria(@RequestBody CategoriasDto nuevaCategoria){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = categoriasService.insertCategoria(nuevaCategoria);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateCategoria", method=RequestMethod.PUT, produces="application/json")
	public ResponseEntity<ResponseDto> updateCategoria(@RequestBody CategoriasDto categoria){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = categoriasService.updateCategoria(categoria);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteCategoria/{id}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteCategoria(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = categoriasService.deleteCategoria(id);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
}
