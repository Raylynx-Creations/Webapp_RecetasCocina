package mx.com.misterjob.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import mx.com.misterjob.attributeConverters.LocalDateTimeConverter;
import mx.com.misterjob.entity.compoundIds.RecetasTagsId;

@Entity
@IdClass(RecetasTagsId.class)
@Table(name = "RECIPE_TAGS", schema="ADMIN_RECETAS_WEBSITE")
public class RecetasTagsEntity {
	@Id
	@Column(name = "ID_RECIPE")
	private Integer idRecipe;
	
	@Id
	@Column(name = "ID_TAG")
	private Integer idTag;
	
	@Column(name = "CREATED_AT")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime createdAt;
	
	@Column(name = "UPDATED_AT")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime updatedAt;

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
