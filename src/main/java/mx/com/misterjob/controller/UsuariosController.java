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
import mx.com.misterjob.dto.UsuariosDto;
import mx.com.misterjob.service.UsuariosService;

@Controller
@RequestMapping("usuarios")
public class UsuariosController {
	@Autowired
	private UsuariosService usuariosService;
	
	@ResponseBody
	@RequestMapping(value="/getUsuarios", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getUsuarios(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = usuariosService.getUsuarios();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getUsuarioById/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getUsuarioById(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = usuariosService.getUsuarioById(id, false);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/insertUsuario", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<ResponseDto> insertUsuario(@RequestBody UsuariosDto nuevaUsuario){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = usuariosService.insertUsuario(nuevaUsuario);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateUsuario", method=RequestMethod.PUT, produces="application/json")
	public ResponseEntity<ResponseDto> updateUsuario(@RequestBody UsuariosDto usuario){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = usuariosService.updateUsuario(usuario);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteUsuario/{id}", method=RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<ResponseDto> deleteUsuario(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = usuariosService.deleteUsuario(id);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
}
