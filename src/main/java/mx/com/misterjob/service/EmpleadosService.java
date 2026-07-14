package mx.com.misterjob.service;

import mx.com.misterjob.dto.EmpleadosDto;
import mx.com.misterjob.dto.ResponseDto;

public interface EmpleadosService {
	public ResponseDto getEmpleadosMasculinos();
	public ResponseDto getEmpleadosFemeninosEdad35();
	public ResponseDto getEmpleadoByRfc(String rfcEmpleado);
	public ResponseDto insertEmpleado(EmpleadosDto usuario);
	public ResponseDto updateEmpleado(EmpleadosDto usuario);
	public ResponseDto deleteEmpleado(Integer idUsuario);
}
