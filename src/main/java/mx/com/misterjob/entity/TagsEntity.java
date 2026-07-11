package mx.com.misterjob.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import mx.com.misterjob.attributeConverters.LocalDateTimeConverter;

@Entity
@Table(name = "TAGS", schema="ADMIN_RECETAS_WEBSITE")
public class TagsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_sequence_generator")
    @SequenceGenerator(
        name = "tag_sequence_generator", 
        sequenceName = "SEQ_TAG", 
        allocationSize = 1
    )
	@Column(name = "ID_TAG")
	private Integer idTag;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CREATED_AT")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime createdAt;
	
	@Column(name = "UPDATED_AT")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime updatedAt;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

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
