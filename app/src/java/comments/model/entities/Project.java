package comments.model.entities;

import javax.persistence.Id;

public class Project {

	@Id
	private Long id;
	private Long createdAt;
	private String name;
	private Boolean enabled;

	public Long getId() {
		return id;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "{" + id + ", " + name + "}";
	}
}
