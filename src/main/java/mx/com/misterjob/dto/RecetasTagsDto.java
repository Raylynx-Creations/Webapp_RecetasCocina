package mx.com.misterjob.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RecetasTagsDto {
	private Integer idRecipe;
	private Integer idTag;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedAt;
	
	public RecetasTagsDto() {
		super();
	}

	public RecetasTagsDto(Integer idRecipe, Integer idTag, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.idRecipe = idRecipe;
		this.idTag = idTag;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(Integer idRecipe) {
		this.idRecipe = idRecipe;
	}

	public Integer getIdTag() {
		return idTag;
	}

	public void setIdTag(Integer idTag) {
		this.idTag = idTag;
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
		return "RecetasTagsDto [idRecipe=" + idRecipe + ", idTag=" + idTag + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
