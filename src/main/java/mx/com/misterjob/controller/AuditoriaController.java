package mx.com.misterjob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.misterjob.dto.ResponseDto;
import mx.com.misterjob.service.AuditoriaService;

@Controller
@RequestMapping("auditoria")
public class AuditoriaController {
	@Autowired
	private AuditoriaService auditoriaService;
	
	@ResponseBody
	@RequestMapping(value="/getAuditoria", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getAuditoria(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = auditoriaService.getAuditoria();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/getAuditoriaById/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ResponseDto> getAuditoriaById(@PathVariable("id") Integer id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = auditoriaService.getAuditoriaById(id);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
}
