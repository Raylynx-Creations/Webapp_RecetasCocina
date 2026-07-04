package mx.com.misterjob.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RecetasCategoriasDto {
	private Integer idRecipe;
	private Integer idCategory;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedAt;
	
	public RecetasCategoriasDto() {
		super();
	}

	public RecetasCategoriasDto(Integer idRecipe, Integer idCategory, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.idRecipe = idRecipe;
		this.idCategory = idCategory;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(Integer idRecipe) {
		this.idRecipe = idRecipe;
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "RecetasCategoriasDto [idRecipe=" + idRecipe + ", idCategory=" + idCategory + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
