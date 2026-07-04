package mx.com.misterjob.dto;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RecetasDto {
	private Integer idRecipe;
	private Integer idUser;
	private String title;
	private String description;
	private String instructions;
	private Short preparationTimeMinutes;
	private Short cookTimeMinutes;
	private Byte portions;
	private Byte difficulty;
	private byte[] image;
	private Byte visibility; //0 publico, 1 revision, 2 privado/draft
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedAt;
	private Long views;
	private Long likes;
	private Boolean isActive;
	
	public RecetasDto() {
		super();
	}

	public RecetasDto(Integer idRecipe, Integer idUser, String title, String description, String instructions,
			Short preparationTimeMinutes, Short cookTimeMinutes, Byte portions, Byte difficulty, byte[] image,
			Byte visibility, LocalDateTime createdAt, LocalDateTime updatedAt, Long views, Long likes, Boolean isActive) {
		super();
		this.idRecipe = idRecipe;
		this.idUser = idUser;
		this.title = title;
		this.description = description;
		this.instructions = instructions;
		this.preparationTimeMinutes = preparationTimeMinutes;
		this.cookTimeMinutes = cookTimeMinutes;
		this.portions = portions;
		this.difficulty = difficulty;
		this.image = image;
		this.visibility = visibility;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.views = views;
		this.likes = likes;
		this.isActive = isActive;
	}

	public Integer getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(Integer idRecipe) {
		this.idRecipe = idRecipe;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Short getPreparationTimeMinutes() {
		return preparationTimeMinutes;
	}

	public void setPreparationTimeMinutes(Short preparationTimeMinutes) {
		this.preparationTimeMinutes = preparationTimeMinutes;
	}

	public Short getCookTimeMinutes() {
		return cookTimeMinutes;
	}

	public void setCookTimeMinutes(Short cookTimeMinutes) {
		this.cookTimeMinutes = cookTimeMinutes;
	}

	public Byte getPortions() {
		return portions;
	}

	public void setPortions(Byte portions) {
		this.portions = portions;
	}

	public Byte getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Byte difficulty) {
		this.difficulty = difficulty;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] bs) {
		this.image = bs;
	}

	public Byte getVisibility() {
		return visibility;
	}

	public void setVisibility(Byte visibility) {
		this.visibility = visibility;
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

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}
	
	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "RecetasDto [idRecipe=" + idRecipe + ", idUser=" + idUser + ", title=" + title + ", description="
				+ description + ", instructions=" + instructions + ", preparationTimeMinutes=" + preparationTimeMinutes
				+ ", cookTimeMinutes=" + cookTimeMinutes + ", portions=" + portions + ", difficulty=" + difficulty
				+ ", image=" + Arrays.toString(image) + ", visibility=" + visibility + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", views=" + views + ", likes=" + likes + ", isActive=" + isActive + "]";
	}
}
