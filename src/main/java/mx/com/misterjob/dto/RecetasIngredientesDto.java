package mx.com.misterjob.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RecetasIngredientesDto {
	private Integer idRecipe;
	private Integer idIngredient;
	private Byte quantity;
	private String unit;
	private String notes;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedAt;
	
	public RecetasIngredientesDto() {
		super();
	}

	public RecetasIngredientesDto(Integer idRecipe, Integer idIngredient, Byte quantity, String unit, String notes,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.idRecipe = idRecipe;
		this.idIngredient = idIngredient;
		this.quantity = quantity;
		this.unit = unit;
		this.notes = notes;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(Integer idRecipe) {
		this.idRecipe = idRecipe;
	}

	public Integer getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(Integer idIngredient) {
		this.idIngredient = idIngredient;
	}

	public Byte getQuantity() {
		return quantity;
	}

	public void setQuantity(Byte quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
		return "RecetasIngredientesDto [idRecipe=" + idRecipe + ", idIngredient=" + idIngredient + ", quantity="
				+ quantity + ", unit=" + unit + ", notes=" + notes + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
