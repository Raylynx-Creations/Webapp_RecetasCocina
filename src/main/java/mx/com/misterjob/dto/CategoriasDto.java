package mx.com.misterjob.dto;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CategoriasDto {
	private Integer idCategory;
	private String name;
	private String description;
	private byte[] icon;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedAt;
	private Boolean isActive;

	public CategoriasDto() {
		super();
	}

	public CategoriasDto(Integer idCategory, String name, String description, byte[] icon, LocalDateTime createdAt,
			LocalDateTime updatedAt, Boolean isActive) {
		super();
		this.idCategory = idCategory;
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] bs) {
		this.icon = bs;
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
		return "CategoriasDto [idCategory=" + idCategory + ", name=" + name + ", description=" + description + ", icon="
				+ Arrays.toString(icon) + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isActive=" + isActive + "]";
	}
}
