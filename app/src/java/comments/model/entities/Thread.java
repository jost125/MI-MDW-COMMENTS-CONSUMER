package comments.model.entities;

import java.util.Date;
import javax.persistence.Id;
import org.codehaus.jackson.annotate.JsonBackReference;

public class Thread {

	@Id
	private Long id;
	private Boolean closed;
	private Long createdAt;
	private String name;

	public Long getId() {
		return id;
	}

	public Boolean getClosed() {
		return closed;
	}

	public Date getCreatedAt() {
		return new Date(createdAt);
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{" + id + ", " + name + "}";
	}
}
