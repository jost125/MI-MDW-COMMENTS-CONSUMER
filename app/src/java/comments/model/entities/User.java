package comments.model.entities;

import javax.persistence.Id;

public class User {

	@Id
	private Long id;
	private String authKey;
	private Long createdAt;
	private String email;
	private Boolean enabled;
	private RoleEnum role;
	public enum RoleEnum {ADMINISTRATOR, API_KEY_OWNER};

	public User() {
	}

	public String getAuthKey() {
		return authKey;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public Long getId() {
		return id;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public RoleEnum getRole() {
		return role;
	}
	
	@Override
	public String toString() {
		return "{" + id + ", " + email + "}";
	}
}
