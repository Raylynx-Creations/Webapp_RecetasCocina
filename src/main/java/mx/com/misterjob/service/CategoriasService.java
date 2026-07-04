package mx.com.misterjob.service;

import mx.com.misterjob.dto.CategoriasDto;
import mx.com.misterjob.dto.ResponseDto;

public interface CategoriasService {
	public ResponseDto getCategorias();
	public ResponseDto getCategoriaById(Integer idCategoria, Boolean update);
	public ResponseDto getCategoriaByName(String nameCategoria, Integer idCategoria);
	public ResponseDto insertCategoria(CategoriasDto categoria);
	public ResponseDto updateCategoria(CategoriasDto categoria);
	public ResponseDto deleteCategoria(Integer idCategoria);
}
