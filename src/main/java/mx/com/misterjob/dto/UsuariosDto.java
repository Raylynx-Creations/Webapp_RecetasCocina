package mx.com.misterjob.dto;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuariosDto {
	private Integer idUser;
	private String username;
	private String email;
	private String passwordHash;
	private String displayName;
	private byte[] profilePicture;
	private String bio;
	private Byte role;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedAt;
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime lastLogin;
	private Boolean isActive;
	
	public UsuariosDto() {
		super();
	}
	
	public UsuariosDto(Integer idUser, String username, String email, String passwordHash, String displayName,
			byte[] profilePicture, String bio, Byte role, LocalDateTime createdAt, LocalDateTime updatedAt,
			LocalDateTime lastLogin, Boolean isActive) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
		this.displayName = displayName;
		this.profilePicture = profilePicture;
		this.bio = bio;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.lastLogin = lastLogin;
		this.isActive = isActive;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] bs) {
		this.profilePicture = bs;
	}
	
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Byte getRole() {
		return role;
	}

	public void setRole(Byte role) {
		this.role = role;
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

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "UsuariosDto [idUser=" + idUser + ", username=" + username + ", email=" + email + ", passwordHash="
				+ passwordHash + ", displayName=" + displayName + ", profilePicture=" + Arrays.toString(profilePicture)
				+ ", bio=" + bio + ", role=" + role + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", lastLogin=" + lastLogin + ", isActive=" + isActive + "]";
	}
}
