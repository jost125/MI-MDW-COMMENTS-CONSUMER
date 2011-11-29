package comments.model.entities;

import javax.persistence.Id;

public class Tag {

	@Id
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{" + id + ", " + name + "}";
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Tag)) {
			return false;
		}
		return name.equals(((Tag)o).name);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 71 * hash + (this.name != null ? this.name.hashCode() : 0);
		return hash;
	}
}
