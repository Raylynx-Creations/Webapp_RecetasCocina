package mx.com.misterjob.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IngredientesDto {
	private Integer idIngredient;
	private String name;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedAt;
	private Boolean isActive;
	
	public IngredientesDto() {
		super();
	}

	public IngredientesDto(Integer idIngredient, String name, LocalDateTime createdAt, LocalDateTime updatedAt,
			Boolean isActive) {
		super();
		this.idIngredient = idIngredient;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}

	public Integer getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(Integer idIngredient) {
		this.idIngredient = idIngredient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "IngredientesDto [idIngredient=" + idIngredient + ", name=" + name + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", isActive=" + isActive + "]";
	}

}
