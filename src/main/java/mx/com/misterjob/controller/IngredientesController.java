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

import mx.com.misterjob.dto.IngredientesDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.service.IngredientesService;

@Controller
@RequestMapping("ingredientes")
public class IngredientesController {
	@Autowired
	private IngredientesService ingredientesService;
	
	@ResponseBody
	@RequestMapping(value="/getIngredientes", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getIngredientes(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = ingredientesService.getIngredientes();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getIngredienteById/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getIngredienteById(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = ingredientesService.getIngredienteById(id, false);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertIngrediente", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseDto> insertIngrediente(@RequestBody IngredientesDto nuevoIngrediente){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = ingredientesService.insertIngrediente(nuevoIngrediente);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateIngrediente", method=RequestMethod.PUT, produces="application/json")
	public ResponseEntity<ResponseDto> updateIngrediente(@RequestBody IngredientesDto ingrediente){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = ingredientesService.updateIngrediente(ingrediente);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteIngrediente/{id}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteIngrediente(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = ingredientesService.deleteIngrediente(id);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
}
