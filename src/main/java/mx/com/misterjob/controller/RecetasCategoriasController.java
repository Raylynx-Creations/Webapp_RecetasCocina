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

import mx.com.misterjob.dto.RecetasCategoriasDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.service.RecetasCategoriasService;

@Controller
@RequestMapping("recetas-categorias")
public class RecetasCategoriasController {
	@Autowired
	private RecetasCategoriasService recetasCategoriasService;
	
	@ResponseBody
	@RequestMapping(value="/getRecetasCategoriasByIdReceta/{idR}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetasCategoriasByIdReceta(@PathVariable("idR") Integer idR){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasCategoriasService.getRecetasCategoriasByIdReceta(idR);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getRecetasCategoriasByIdTag/{idC}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetasCategoriasByIdTag(@PathVariable("idC") Integer idC){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasCategoriasService.getRecetasCategoriasByIdCategoria(idC);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getRecetaCategoria/{idR}/{idC}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetaCategoria(@PathVariable("idR") Integer idR, @PathVariable("idC") Integer idC){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasCategoriasService.getRecetaCategoria(idR, idC);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertRecetaCategoria", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseDto> insertRecetaCategoria(@RequestBody RecetasCategoriasDto nuevaRecetaCategoria){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasCategoriasService.insertRecetaCategoria(nuevaRecetaCategoria);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteRecetasCategoriasByIdReceta/{idR}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteRecetasCategoriasByIdReceta(@PathVariable("idR") Integer idR){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasCategoriasService.deleteRecetasCategoriasByIdReceta(idR);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteRecetaIngrediente/{idR}/{idC}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteRecetaCategoria(@PathVariable("idR") Integer idR, @PathVariable("idC") Integer idC){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasCategoriasService.deleteRecetaCategoria(idR, idC);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
}
