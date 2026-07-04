package mx.com.misterjob.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TagsDto {
	private Integer idTag;
	private String name;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedAt;
	private Boolean isActive;
	
	public TagsDto() {
		super();
	}

	public TagsDto(Integer idTag, String name, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isActive) {
		super();
		this.idTag = idTag;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}

	public Integer getIdTag() {
		return idTag;
	}

	public void setIdTag(Integer idTag) {
		this.idTag = idTag;
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
		return "TagsDto [idTag=" + idTag + ", name=" + name + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", isActive=" + isActive + "]";
	}

}
