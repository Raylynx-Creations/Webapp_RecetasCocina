package mx.com.misterjob.entity;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "USERS", schema="ADMIN_RECETAS_WEBSITE")
public class UsuariosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_generator")
    @SequenceGenerator(
        name = "user_sequence_generator", 
        sequenceName = "SEQ_USER", 
        allocationSize = 1
    )
	@Column(name = "ID_USER")
	private Integer idUser;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD_HASH")
	private String passwordHash;
	
	@Column(name = "DISPLAY_NAME")
	private String displayName;
	
	@Column(name = "PROFILE_PICTURE")
	private byte[] profilePicture;
	
	@Column(name = "BIO")
	private String bio;
	
	@Column(name = "ROLE")
	private Byte role;
	
	@Column(name = "CREATED_AT")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	
	@Column(name = "UPDATED_AT")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime updatedAt;
	
	@Column(name = "LAST_LOGIN")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime lastLogin;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

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
