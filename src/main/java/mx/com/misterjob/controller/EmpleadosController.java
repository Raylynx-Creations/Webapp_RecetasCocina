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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.misterjob.dto.EmpleadosDto;
import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.service.EmpleadosService;

@Controller
@RequestMapping("empleados")
public class EmpleadosController {
	@Autowired
	private EmpleadosService empleadosService;
	
	@ResponseBody
	@RequestMapping(value="/getEmpleadosMasculinos", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getEmpleadosMasculinos(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = empleadosService.getEmpleadosMasculinos();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getEmpleadosFemeninosEdad35", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getEmpleadosFemeninosEdad35(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = empleadosService.getEmpleadosFemeninosEdad35();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getEmpleadoByRfc", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getEmpleadoByRfc(@RequestParam("rfc") String rfc){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = empleadosService.getEmpleadoByRfc(rfc);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertEmpleado", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseDto> insertEmpleado(@RequestBody EmpleadosDto nuevoEmpleado){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = empleadosService.insertEmpleado(nuevoEmpleado);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateEmpleado", method=RequestMethod.PUT, produces="application/json")
	public ResponseEntity<ResponseDto> updateEmpleado(@RequestBody EmpleadosDto empleado){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = empleadosService.updateEmpleado(empleado);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteEmpleado/{id}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteEmpleado(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = empleadosService.deleteEmpleado(id);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
}
