package mx.com.misterjob.repository;

import java.util.List;

import mx.com.misterjob.dto.CategoriasDto;

public interface CategoriasRepository {
	public List<CategoriasDto> getCategorias();
	public CategoriasDto getCategoriaById(Integer idCategoria, Boolean update);
	public CategoriasDto getCategoriaByName(String nameCategoria, Integer idCategoria);
	public Integer insertCategoria(CategoriasDto categoria);
	public Integer updateCategoria(CategoriasDto categoria);
	public Integer deleteCategoria(Integer idCategoria);
}
