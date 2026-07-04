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

import mx.com.misterjob.dto.RecetasIngredientesDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.service.RecetasIngredientesService;

@Controller
@RequestMapping("recetas-ingredientes")
public class RecetasIngredientesController {
	@Autowired
	private RecetasIngredientesService recetasIngredientesService;
	
	@ResponseBody
	@RequestMapping(value="/getRecetasIngredientesByIdReceta/{idR}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetasIngredientesByIdReceta(@PathVariable("idR") Integer idR){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasIngredientesService.getRecetasIngredientesByIdReceta(idR);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getRecetasIngredientesByIdTag/{idI}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetasIngredientesByIdTag(@PathVariable("idI") Integer idI){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasIngredientesService.getRecetasIngredientesByIdIngrediente(idI);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getRecetaIngrediente/{idR}/{idI}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getRecetaIngrediente(@PathVariable("idR") Integer idR, @PathVariable("idI") Integer idI){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasIngredientesService.getRecetaIngrediente(idR, idI);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertRecetaIngrediente", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseDto> insertRecetaIngrediente(@RequestBody RecetasIngredientesDto nuevaRecetaIngrediente){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasIngredientesService.insertRecetaIngrediente(nuevaRecetaIngrediente);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateRecetaIngrediente", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseDto> updateRecetaIngrediente(@RequestBody RecetasIngredientesDto recetaIngrediente){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasIngredientesService.updateRecetaIngrediente(recetaIngrediente);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteRecetasIngredientesByIdReceta/{idR}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteRecetasIngredientesByIdReceta(@PathVariable("idR") Integer idR){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasIngredientesService.deleteRecetasIngredientesByIdReceta(idR);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteRecetaIngrediente/{idR}/{idI}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteRecetaIngrediente(@PathVariable("idR") Integer idR, @PathVariable("idI") Integer idI){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = recetasIngredientesService.deleteRecetaIngrediente(idR, idI);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
}
